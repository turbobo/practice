package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Jusven
 * @Date 2024/3/3 14:01
 *
 * 不加注解，不交给spring管理，需要创建多个线程池
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor implements DisposableBean {
//    @Resource
//    private MyThreadPoolExecutorManage myThreadPoolExecutorManage;

    private static final Logger logger = LoggerFactory.getLogger(MyThreadPoolExecutor.class);

    // TODO 自定义拒绝策略，做逻辑处理
    /**
     * 默认拒绝策略
     */
    private static RejectedExecutionHandler defaultHandler = new AbortPolicy();
    /**
     * 线程池名称，一般以业务名称命名，方便区分
     */
    private String poolName;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    // todo 自定义线程工厂，可以定义名称规则
    private static CustomizableThreadFactory myThreadFactoty = new CustomizableThreadFactory("_自定义线程名_");

    // 使用ThreadLocal统计每个线程的信息
    ThreadLocal<Long> threadLocal = new ThreadLocal();


    public MyThreadPoolExecutor(String poolName, int corePoolSize, int maximumPoolSize,
                                long keepAliveTime, TimeUnit unit, Integer capacity) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>(capacity), myThreadFactoty, defaultHandler);
        this.poolName = poolName;

    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void destroy() throws Exception {

    }

//    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
//                             TimeUnit unit, BlockingQueue<Runnable> workQueue,
//                             String threadNamePrefix, String poolName) {
////        ThreadFactory myThreadFactory = new MyThreadFactory(threadNamePrefix);
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, myThreadFactory, defaultHandler);
//        this.poolName = poolName;
//    }

    static class MyThreadFactory implements ThreadFactory {
        private String threadNamePrefix;
        private static final AtomicInteger poolNumber = new AtomicInteger(1);

        public MyThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread();
            t.setName(threadNamePrefix + "_" +  poolNumber.getAndIncrement() + "_thread");
            return t;
        }
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("任务线程执行前");
        threadLocal.set(System.currentTimeMillis());
        // Worker线程执行任务之前会调用的方法；
//        super.beforeExecute(t, r);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        System.out.println("任务线程执行后");

        long costTime = System.currentTimeMillis() - threadLocal.get();
        // TODO 使用完之后，记得清理ThreadLocal，防止内存泄漏
        threadLocal.remove();

        logger.info("{}-pool-monitor: " +
                        "任务耗时: {} ms, 初始线程数: {}, 核心线程数: {}, 执行的任务数量: {}, " +
                        "已完成任务数量: {}, 任务总数: {}, 队列里缓存的任务数量: {}, 池中存在的最大线程数: {}, " +
                        "最大允许的线程数: {},  线程空闲时间: {}, 线程池是否关闭: {}, 线程池是否终止: {}",
                this.poolName,
                costTime, this.getPoolSize(), this.getCorePoolSize(), this.getActiveCount(),
                this.getCompletedTaskCount(), this.getTaskCount(), this.getQueue().size(), this.getLargestPoolSize(),
                this.getMaximumPoolSize(), this.getKeepAliveTime(TimeUnit.MILLISECONDS), this.isShutdown(), this.isTerminated());

        // TODO 阈值报警
//        super.afterExecute(r, t);
    }


// TODO 自定义销毁方法，打印信息

    /**
     * 线程池延迟关闭时（等待线程池里的任务都执行完毕），统计线程池情况
     */
    @Override
    public void shutdown() {
        try {
            // 统计已执行任务、正在执行任务、未执行任务数量
            logger.info("{} 关闭线程池， 已执行任务: {}, 正在执行任务: {}, 未执行队列任务数量: {}",
                    this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
            super.shutdown();
        } catch (Exception e) {

        }

        // TODO 线程池管理map 移除
        MyThreadPoolExecutorManage.getInstance().getThreadPoolExecutorMap().remove(poolName);
    }

    /**
     * 线程池立即关闭时，统计线程池情况
     */
    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> runnables = null;
        try {
            // 统计已执行任务、正在执行任务、未执行任务数量
            logger.info("{} 立即关闭线程池，已执行任务: {}, 正在执行任务: {}, 未执行队列任务数量: {}",
                    this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
            runnables = super.shutdownNow();
        } catch (Exception e) {

        }
        MyThreadPoolExecutorManage.getInstance().getThreadPoolExecutorMap().remove(poolName);
        return runnables;
        // TODO 线程池管理map 移除


    }
}
