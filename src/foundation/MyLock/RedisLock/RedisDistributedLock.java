package foundation.MyLock.RedisLock;

import foundation.MyLock.LockDemo.AbstractLock;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/4/7 16:52
 * redis 分布式锁
 *
 * TODO 分布式锁 执行的逻辑 需要考虑幂等性：无论采取何种处理方式，都需要保证后续操作的幂等性。即使在获取锁失败或者锁失效的情况下，也需要确保后续操作的执行不会导致数据的重复处理或者不一致性。
 * 建议 分布式锁的 逻辑，定时处理任务数据，不会重复操作同一数据；创建分区表时，如果分区表已经创建，则不需要再创建；删除表同样
 */
public class RedisDistributedLock implements AbstractLock {
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // 锁名称：对应业务操作
    private String lockKey;

    // 当前使用锁的节点，线程，唯一值（不同服务器，不同tomcat，不同实例，不同线程）
    private String lockValue;

    private String uuid;

    // 最大重试此时
    private Integer maxRetry;

    // 休眠重试间隔  毫秒
    private Long retryInterval;

    // 锁过期时间  30分钟
    private long expireTime = 30 * 60 * 1000;

    private final StringRedisTemplate redisTemplate;

//    public RedisDistributedLock(StringRedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
//        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
//    }

    public RedisDistributedLock(String lockKey, Integer maxRetry, Long retryInterval, long expireTime, StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
        this.lockKey = lockKey;
        this.maxRetry = maxRetry;
        this.retryInterval = retryInterval;
        this.expireTime = expireTime;
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public String getLockValue() {
        return lockValue;
    }

    public void setLockValue(String lockValue) {
        this.lockValue = lockValue;
    }

    public Integer getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    public Long getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Long retryInterval) {
        this.retryInterval = retryInterval;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    // 成功返回1 失败返回0
    // EXPIRE key seconds  秒
    // PEXPIRE key milliseconds  毫秒
    private static final String LOCK_SCRIPT =
            "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then " +
                    "    return redis.call('expire', KEYS[1], ARGV[2]) " +
                    "else " +
                    "    return 0 " +
                    "end";

    private static final String RELEASE_LOCK_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                    "   return redis.call('del', KEYS[1]) " +
                    "else " +
                    "   return 0 " +
                    "end";

    /**
     * 续约lua脚本
     * 同一个线程才需要给锁续期，其他线程只关注锁 获取和释放就行
     */
    private static final String RENEW_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                    "   return redis.call('expire', KEYS[1], ARGV[2]) " +
                    "else " +
                    "   return 0 " +
                    "end";


    // 获取锁
    public boolean tryLock(String value) throws InterruptedException {
//        String value = 127001 + "_"  + "acs.1" + "_"  + System.currentTimeMillis();
        for (int i = 0; i < this.maxRetry; i++) {
            if (lock(this.lockKey, value)){
                return true;
            }
            Thread.sleep(this.retryInterval); // 休眠一段时间后重试
        }
        return false; // 获取锁失败
    }

    /**
     * 加锁
     * lua将 setnx  expire命令封装成原子操作
     *
     * @return
     */
    @Override
    public boolean lock(String key, String value) {
        RedisScript<String> script = new DefaultRedisScript<>(LOCK_SCRIPT, String.class);
        String result = redisTemplate.execute(script, Collections.singletonList(key), value, String.valueOf(expireTime));
        return "1".equals(result);
    }

    /**
     * 释放锁
     *
     * @param key
     * @param value 当redis值等于 预期值，才删除，防止误删
     * @return
     */
    @Override
    public boolean unLock(String key, String value) {
        RedisScript<String> script = new DefaultRedisScript<>(RELEASE_LOCK_SCRIPT, String.class);
        String result = redisTemplate.execute(script, Collections.singletonList(key), value);
        return "1".equals(result);
    }

    // 锁续期
    /**
     * 续约: 加锁成功，就启动一个定时任务去执行 时间的过期1/4  将锁重新续期
     * 同一个线程才需要给锁续期，其他线程只关注锁 获取和释放就行
     *
     * @param key
     * @param value
     * @param expireTime  重新续期的时间
     * @return true:续约成功，false:续约失败（1、续约期间执行完成，锁被释放 2、不是自己的锁，3、续约期间锁过期了（未解决））
     */
    public boolean reExpire(String key, String value, Long expireTime) {

//        // 检测执行业务线程的状态
//        Thread.State state = lockContent.getThread().getState();
//        if (Thread.State.TERMINATED == state) {
//            log.info("执行业务的线程已终止,不再续约 lockKey ={}, lockContent={}", lockKey, lockContent);
//            return false;
//        }
//        String requestId = lockContent.getRequestId();

        // 检测当前value和redis中value一致，则续期
        RedisScript<String> script = RedisScript.of(RENEW_SCRIPT, String.class);
        String result = redisTemplate.execute(script, Collections.singletonList(key), value, String.valueOf(expireTime));
        return "1".equals(result);
    }
}
