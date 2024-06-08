package foundation.Thread;

/**
 * @Author Jusven
 * @Date 2024/4/14 18:22
 */
public class ThreadPrint {
    private static final int MAX_COUNT = 100; // ��ӡ���������
    private static int count = 1; // ��ǰ��ӡ������
    private static final int THREAD_COUNT = 5; // �߳�����
    private static final Object lock = new Object(); // ������
    private static int currentThreadIndex = 0; // ��ǰִ�д�ӡ���߳�����

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        // �ж��Ƿ��ֵ���ǰ�̴߳�ӡ
                        if (currentThreadIndex % THREAD_COUNT != threadIndex) {
                            try {
                                lock.wait(); // ������ǵ�ǰ�̴߳�ӡ�����ͷ������ȴ�
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // ��ӡ���ֲ�������һ���߳�
                            if (count <= MAX_COUNT) {
                                System.out.println(Thread.currentThread().getName() + ": " + count++);
                                currentThreadIndex++;
                                lock.notifyAll();
                            } else {
                                return;
                            }
                        }
                    }
                }
            });
            threads[i].start();
        }
    }

}
