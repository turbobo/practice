package foundation.Thread;

/**
 * @Author Jusven
 * @Date 2024/4/14 18:22
 */
public class ThreadPrint {
    private static final int MAX_COUNT = 100; // 打印的最大数字
    private static int count = 1; // 当前打印的数字
    private static final int THREAD_COUNT = 5; // 线程数量
    private static final Object lock = new Object(); // 锁对象
    private static int currentThreadIndex = 0; // 当前执行打印的线程索引

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        // 判断是否轮到当前线程打印
                        if (currentThreadIndex % THREAD_COUNT != threadIndex) {
                            try {
                                lock.wait(); // 如果不是当前线程打印，则释放锁并等待
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // 打印数字并唤醒下一个线程
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
