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
        //一次性全部放进去
        for (int i = 0; i < 98; i++) {
            AppTask appTask = new AppTask(i);
            poolExecutor.execute(appTask);
            System.out.println("线程池中线程的数目:" + poolExecutor.getPoolSize() + ",线程池中等待的队列数目：" + poolExecutor.getQueue().size() + ";线程池中已执行完毕的任务数据:" + poolExecutor.getCompletedTaskCount());
        }

        poolExecutor.getLargestPoolSize();
//        poolExecutor.set();

/*        for (int i = 21; i < 29; i++) {
            AppTask appTask = new AppTask(i);
            poolExecutor.execute(appTask);
            System.out.println("线程池中线程的数目:" + poolExecutor.getPoolSize() + ",线程池中等待的队列数目：" + poolExecutor.getQueue().size() + ";线程池中已执行完毕的任务数据:" + poolExecutor.getCompletedTaskCount());
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
                //每个线程下发1000个权限
                Thread.sleep(10000L);  //线程创建后，休眠10秒再执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "_task_" + this.taskNum + ":执行完毕");
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