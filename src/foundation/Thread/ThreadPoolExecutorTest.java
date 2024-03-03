package foundation.Thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandlerImpl handler;
        handler = new RejectedExecutionHandlerImpl();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        ThreadPoolExecutor threadPoolExecutor = threadPoolTaskExecutor.getThreadPoolExecutor();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 5, 20L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
        //һ����ȫ���Ž�ȥ
        for (int i = 0; i < 98; i++) {
            AppTask appTask = new AppTask(i);
            poolExecutor.execute(appTask);
            System.out.println("�̳߳����̵߳���Ŀ:" + poolExecutor.getPoolSize() + ",�̳߳��еȴ��Ķ�����Ŀ��" + poolExecutor.getQueue().size() + ";�̳߳�����ִ����ϵ���������:" + poolExecutor.getCompletedTaskCount());
        }

        poolExecutor.getLargestPoolSize();
//        poolExecutor.set();

/*        for (int i = 21; i < 29; i++) {
            AppTask appTask = new AppTask(i);
            poolExecutor.execute(appTask);
            System.out.println("�̳߳����̵߳���Ŀ:" + poolExecutor.getPoolSize() + ",�̳߳��еȴ��Ķ�����Ŀ��" + poolExecutor.getQueue().size() + ";�̳߳�����ִ����ϵ���������:" + poolExecutor.getCompletedTaskCount());
        }*/
        poolExecutor.allowCoreThreadTimeOut(true);
        if (!poolExecutor.isShutdown()) {
            poolExecutor.shutdown();
        }
    }

    static class AppTask implements Runnable {
        private int taskNum;

        public AppTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            try {
                //ÿ���߳��·�1000��Ȩ��
                Thread.sleep(10000L);  //�̴߳���������10����ִ��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "_task_" + this.taskNum + ":ִ�����");
        }
    }

    static LinkedBlockingQueue<Runnable> xs = new LinkedBlockingQueue(10000);
    static int i = 0;

    static class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                xs.put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}