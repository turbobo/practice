package foundation.MyLock.LockDemo;

/**
 * @Author Jusven
 * @Date 2024/4/7 16:49
 * 抽象锁，具体让实现类去实现各自的锁逻辑
 */
public interface AbstractLock {

    public boolean lock(String lockKey, String lockValue);

    public boolean unLock(String lockKey, String lockValue);
}
