package foundation.MyLock.LockDemo;

/**
 * @Author Jusven
 * @Date 2024/4/7 16:49
 * ��������������ʵ����ȥʵ�ָ��Ե����߼�
 */
public interface AbstractLock {

    public boolean lock(String lockKey, String lockValue);

    public boolean unLock(String lockKey, String lockValue);
}
