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
     * �Ž�ÿ�춨ʱ�����������ʧЧʱ�䣨���룩 60����
     */
    public static final long ACCESS_TASK_EXPIRE_TIEM = 60*60*1000;

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    private StringRedisTemplate redisTemplate;

    // TODO ���볬ʱ�������ڣ�ѩ���㷨����UUID
    // ��1���������⣺
    // �� �����߳�A�ɹ��õ��������������õĳ�ʱʱ���� 30 �롣���ĳЩԭ�����߳� A ִ�еĺ��������� 30 �붼ûִ���꣬��ʱ���������Զ��ͷţ��߳� B �õ�������
    // �� ����߳�Aִ�������񣬽���ִ��delָ�����ͷ���������ʱ���߳� B ��ûִ���꣬�߳�Aʵ����ɾ�������߳�B�ӵ�����
    // ��2�����������
    // ������ del �ͷ���֮ǰ��һ���жϣ���֤��ǰ�����ǲ����Լ��ӵ������ڼ�����ʱ��ѵ�ǰ���߳� ID ����value������ɾ��֮ǰ��֤ key ��Ӧ�� value �ǲ����Լ��̵߳� ID��
    // ���ǣ���������ʵ������һ���µ����⣬get�������жϺ��ͷ�����������������������ԭ���ԡ����ڷ�ԭ���Ե����⣬���ǿ���ʹ��Lua�ű���ȷ��������ԭ����

    // ÿ��� 0 �� 1 ��ִ�У����������ڡ��·ݺ����ڡ�
    @Scheduled(cron = "0 1 0 ? * *")
    public void createPartitionTable(String instanceName) {
        // key �洢���ǲ������ƣ����磺acs.redis.key.prefix.acs.task.lock.key ��ʾ��Ҫ������һ�������ʾ
        // ��ǰʱ����Ϊvalue����ȷ��Ψһ�������߳�
//        long lockExpireTime = System.currentTimeMillis() + ACCESS_TASK_EXPIRE_TIEM + 1;//����ʱʱ��
        // �ֲ�ʽ������Ҫȫ��Ψһ�ĳ�������̫�ֱ࣬��ʹ�� ip��ַ+ʵ������+����ʱ�伴�ɣ� 127001_acs.1_128012831
//        instanceName = instanceName.replaceAll("_", "");
//        String stringOfLockExpireTime = instanceName + "_" + String.valueOf(lockExpireTime);
        String lockKey = "acs:acsRedis"  + ":acsTaskLockKey";
        RedisDistributedLock lock = new RedisDistributedLock(lockKey, 3, 500L, ACCESS_TASK_EXPIRE_TIEM, redisTemplate);

        // TODO �ͷ���ʱУ�飺�ֲ�ʽʵ������ip��ַ + ʵ������ + ��ȡ����ʱ��
        String lockValue = "127.0.0.1" + "_" + "acs.1"  + "_" + System.currentTimeMillis();
        try {
            if (lock.tryLock(lockValue)) { // �����ɹ�
                // TODO ִ�зֱ��߼�

                // ɾ����ʷ��¼������

                // �����ɹ����Ϳ�����ʱ����ÿ��һ��ʱ��������
                // command��Ҫִ�е�����ͨ����һ��ʵ���� Runnable �ӿڵĶ���
                // initialDelay�������״�ִ�е��ӳ�ʱ�䣬���ӵ��� scheduleAtFixedRate �������״�ִ������֮���ʱ������
                // period�������ִ�����ڣ���ÿ������ִ����ɺ���һ������ʼִ��֮���ʱ������
                // unit��ʱ�䵥λ������ָ�� initialDelay �� period ��ʱ�䵥λ��
                scheduler.scheduleAtFixedRate(() -> {
                    // ��鵱ǰʱ���Ƿ�ӽ����Ĺ���ʱ�䣬����ǣ�������
                    // ��ʣ20%��ʱ�䣬��ִ��
                    String[] split = lockValue.split("_");
                    Long startLockTime = Long.valueOf(split[2]);
                    if (System.currentTimeMillis() - startLockTime <= (long) (lock.getExpireTime() * 0.25)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        // TODO lua�ű������ж�key���ڣ�������
                        lock.reExpire(lockKey, lockValue, lock.getExpireTime());
                        System.out.println("������ �´ι���ʱ��Ϊ " + currentTimeMillis + lock.getExpireTime());

                    }
                }, 30, (long) (lock.getExpireTime() * 0.25), TimeUnit.MILLISECONDS); // ÿ�� ʱ��Ĺ���1/4 ��ִ��һ��
            }
        } catch (InterruptedException e) {
            // ��ȡ��ʧ��
            System.out.println("��ȡ��ʧ��");
            e.printStackTrace();
        } finally {
            // �ͷ���
            if (lock.unLock(lockKey, lockValue)) {
                System.out.println("ɾ�����ɹ�");
            } else {
                // ��ӡ��ǰ�� �� redis�е���
                System.out.println("��ǰ��Ҫ���� " + lockValue);
                System.out.println("redis�д��ڵ��� " + redisTemplate.opsForValue().get(lockKey));

            }
            // ������ ִ�н������ر� ������ ��ʱ����
            scheduler.shutdown();
            scheduler = null;
        }
    }

}
