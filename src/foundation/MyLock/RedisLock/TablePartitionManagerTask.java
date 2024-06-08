package foundation.MyLock.RedisLock;

import cn.hutool.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/4/6 22:12
 */
public class TablePartitionManagerTask {
    /***
     * 门禁每天定时任务持有锁的失效时间（毫秒） 60分钟
     */
    public static final long ACCESS_TASK_EXPIRE_TIEM = 60*60*1000;

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    private StringRedisTemplate redisTemplate;

    // TODO 加入超时，锁续期，雪花算法生成UUID
    // （1）存在问题：
    // ① 假如线程A成功得到了锁，并且设置的超时时间是 30 秒。如果某些原因导致线程 A 执行的很慢，过了 30 秒都没执行完，这时候锁过期自动释放，线程 B 得到了锁。
    // ② 随后，线程A执行完任务，接着执行del指令来释放锁。但这时候线程 B 还没执行完，线程A实际上删除的是线程B加的锁。
    // （2）解决方案：
    // 可以在 del 释放锁之前做一个判断，验证当前的锁是不是自己加的锁。在加锁的时候把当前的线程 ID 当做value，并在删除之前验证 key 对应的 value 是不是自己线程的 ID。
    // 但是，这样做其实隐含了一个新的问题，get操作、判断和释放锁是两个独立操作，不是原子性。对于非原子性的问题，我们可以使用Lua脚本来确保操作的原子性

    // 每天的 0 点 1 分执行，不关心日期、月份和星期。
    @Scheduled(cron = "0 1 0 ? * *")
    public void createPartitionTable(String instanceName) {
        // key 存储的是操作名称，例如：acs.redis.key.prefix.acs.task.lock.key 表示需要加锁的一个任务表示
        // 当前时间作为value可以确定唯一操作的线程
//        long lockExpireTime = System.currentTimeMillis() + ACCESS_TASK_EXPIRE_TIEM + 1;//锁超时时间
        // 分布式锁，需要全局唯一的场景不是太多，直接使用 ip地址+实例名称+过期时间即可： 127001_acs.1_128012831
//        instanceName = instanceName.replaceAll("_", "");
//        String stringOfLockExpireTime = instanceName + "_" + String.valueOf(lockExpireTime);
        String lockKey = "acs:acsRedis"  + ":acsTaskLockKey";
        RedisDistributedLock lock = new RedisDistributedLock(lockKey, 3, 500L, ACCESS_TASK_EXPIRE_TIEM, redisTemplate);

        // TODO 释放锁时校验：分布式实例所在ip地址 + 实例名称 + 获取锁的时间
        String lockValue = "127.0.0.1" + "_" + "acs.1"  + "_" + System.currentTimeMillis();
        try {
            if (lock.tryLock(lockValue)) { // 加锁成功
                // TODO 执行分表逻辑

                // 删除历史记录分区表

                // 加锁成功，就开启定时任务，每隔一段时间续期锁
                // command：要执行的任务，通常是一个实现了 Runnable 接口的对象。
                // initialDelay：任务首次执行的延迟时间，即从调用 scheduleAtFixedRate 方法到首次执行任务之间的时间间隔。
                // period：任务的执行周期，即每次任务执行完成后，下一次任务开始执行之间的时间间隔。
                // unit：时间单位，用于指定 initialDelay 和 period 的时间单位。
                scheduler.scheduleAtFixedRate(() -> {
                    // 检查当前时间是否接近锁的过期时间，如果是，则续期
                    // 还剩20%的时间，则执行
                    String[] split = lockValue.split("_");
                    Long startLockTime = Long.valueOf(split[2]);
                    if (System.currentTimeMillis() - startLockTime <= (long) (lock.getExpireTime() * 0.25)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        // TODO lua脚本，先判断key存在，再续期
                        lock.reExpire(lockKey, lockValue, lock.getExpireTime());
                        System.out.println("锁续期 下次过期时间为 " + currentTimeMillis + lock.getExpireTime());

                    }
                }, 30, (long) (lock.getExpireTime() * 0.25), TimeUnit.MILLISECONDS); // 每隔 时间的过期1/4 秒执行一次
            }
        } catch (InterruptedException e) {
            // 获取锁失败
            System.out.println("获取锁失败");
            e.printStackTrace();
        } finally {
            // 释放锁
            if (lock.unLock(lockKey, lockValue)) {
                System.out.println("删除锁成功");
            } else {
                // 打印当前锁 和 redis中的锁
                System.out.println("当前需要加锁 " + lockValue);
                System.out.println("redis中存在的锁 " + redisTemplate.opsForValue().get(lockKey));

            }
            // 锁任务 执行结束，关闭 锁续期 定时任务
            scheduler.shutdown();
            scheduler = null;
        }
    }

}
