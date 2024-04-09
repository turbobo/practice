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
 * redis �ֲ�ʽ��
 *
 * TODO �ֲ�ʽ�� ִ�е��߼� ��Ҫ�����ݵ��ԣ����۲�ȡ���ִ���ʽ������Ҫ��֤�����������ݵ��ԡ���ʹ�ڻ�ȡ��ʧ�ܻ�����ʧЧ������£�Ҳ��Ҫȷ������������ִ�в��ᵼ�����ݵ��ظ�������߲�һ���ԡ�
 * ���� �ֲ�ʽ���� �߼�����ʱ�����������ݣ������ظ�����ͬһ���ݣ�����������ʱ������������Ѿ�����������Ҫ�ٴ�����ɾ����ͬ��
 */
public class RedisDistributedLock implements AbstractLock {
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // �����ƣ���Ӧҵ�����
    private String lockKey;

    // ��ǰʹ�����Ľڵ㣬�̣߳�Ψһֵ����ͬ����������ͬtomcat����ͬʵ������ͬ�̣߳�
    private String lockValue;

    private String uuid;

    // ������Դ�ʱ
    private Integer maxRetry;

    // �������Լ��  ����
    private Long retryInterval;

    // ������ʱ��  30����
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

    // �ɹ�����1 ʧ�ܷ���0
    // EXPIRE key seconds  ��
    // PEXPIRE key milliseconds  ����
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
     * ��Լlua�ű�
     * ͬһ���̲߳���Ҫ�������ڣ������߳�ֻ��ע�� ��ȡ���ͷž���
     */
    private static final String RENEW_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                    "   return redis.call('expire', KEYS[1], ARGV[2]) " +
                    "else " +
                    "   return 0 " +
                    "end";


    // ��ȡ��
    public boolean tryLock(String value) throws InterruptedException {
//        String value = 127001 + "_"  + "acs.1" + "_"  + System.currentTimeMillis();
        for (int i = 0; i < this.maxRetry; i++) {
            if (lock(this.lockKey, value)){
                return true;
            }
            Thread.sleep(this.retryInterval); // ����һ��ʱ�������
        }
        return false; // ��ȡ��ʧ��
    }

    /**
     * ����
     * lua�� setnx  expire�����װ��ԭ�Ӳ���
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
     * �ͷ���
     *
     * @param key
     * @param value ��redisֵ���� Ԥ��ֵ����ɾ������ֹ��ɾ
     * @return
     */
    @Override
    public boolean unLock(String key, String value) {
        RedisScript<String> script = new DefaultRedisScript<>(RELEASE_LOCK_SCRIPT, String.class);
        String result = redisTemplate.execute(script, Collections.singletonList(key), value);
        return "1".equals(result);
    }

    // ������
    /**
     * ��Լ: �����ɹ���������һ����ʱ����ȥִ�� ʱ��Ĺ���1/4  ������������
     * ͬһ���̲߳���Ҫ�������ڣ������߳�ֻ��ע�� ��ȡ���ͷž���
     *
     * @param key
     * @param value
     * @param expireTime  �������ڵ�ʱ��
     * @return true:��Լ�ɹ���false:��Լʧ�ܣ�1����Լ�ڼ�ִ����ɣ������ͷ� 2�������Լ�������3����Լ�ڼ��������ˣ�δ�������
     */
    public boolean reExpire(String key, String value, Long expireTime) {

//        // ���ִ��ҵ���̵߳�״̬
//        Thread.State state = lockContent.getThread().getState();
//        if (Thread.State.TERMINATED == state) {
//            log.info("ִ��ҵ����߳�����ֹ,������Լ lockKey ={}, lockContent={}", lockKey, lockContent);
//            return false;
//        }
//        String requestId = lockContent.getRequestId();

        // ��⵱ǰvalue��redis��valueһ�£�������
        RedisScript<String> script = RedisScript.of(RENEW_SCRIPT, String.class);
        String result = redisTemplate.execute(script, Collections.singletonList(key), value, String.valueOf(expireTime));
        return "1".equals(result);
    }
}
