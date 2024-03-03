package foundation.Thread.ThreadPoolTaskExecutorStudy;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jusven
 * @Date 2024/3/3 12:57
 * 自定义线程池封装
 */
public class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    ThreadPoolExecutor threadPoolExecutor = threadPoolTaskExecutor.getThreadPoolExecutor();
    //

    // 自定义工作队列

    // 自定义任务执行前后 逻辑增强
//    public beforeExecute(Thread t, Runnable r) {
//        super.be
//    }
}
