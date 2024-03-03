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
 * ����ע�⣬������spring������Ҫ��������̳߳�
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor implements DisposableBean {
//    @Resource
//    private MyThreadPoolExecutorManage myThreadPoolExecutorManage;

    private static final Logger logger = LoggerFactory.getLogger(MyThreadPoolExecutor.class);

    // TODO �Զ���ܾ����ԣ����߼�����
    /**
     * Ĭ�Ͼܾ�����
     */
    private static RejectedExecutionHandler defaultHandler = new AbortPolicy();
    /**
     * �̳߳����ƣ�һ����ҵ��������������������
     */
    private String poolName;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    // todo �Զ����̹߳��������Զ������ƹ���
    private static CustomizableThreadFactory myThreadFactoty = new CustomizableThreadFactory("_�Զ����߳���_");

    // ʹ��ThreadLocalͳ��ÿ���̵߳���Ϣ
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
        System.out.println("�����߳�ִ��ǰ");
        threadLocal.set(System.currentTimeMillis());
        // Worker�߳�ִ������֮ǰ����õķ�����
//        super.beforeExecute(t, r);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        System.out.println("�����߳�ִ�к�");

        long costTime = System.currentTimeMillis() - threadLocal.get();
        // TODO ʹ����֮�󣬼ǵ�����ThreadLocal����ֹ�ڴ�й©
        threadLocal.remove();

        logger.info("{}-pool-monitor: " +
                        "�����ʱ: {} ms, ��ʼ�߳���: {}, �����߳���: {}, ִ�е���������: {}, " +
                        "�������������: {}, ��������: {}, �����ﻺ�����������: {}, ���д��ڵ�����߳���: {}, " +
                        "���������߳���: {},  �߳̿���ʱ��: {}, �̳߳��Ƿ�ر�: {}, �̳߳��Ƿ���ֹ: {}",
                this.poolName,
                costTime, this.getPoolSize(), this.getCorePoolSize(), this.getActiveCount(),
                this.getCompletedTaskCount(), this.getTaskCount(), this.getQueue().size(), this.getLargestPoolSize(),
                this.getMaximumPoolSize(), this.getKeepAliveTime(TimeUnit.MILLISECONDS), this.isShutdown(), this.isTerminated());

        // TODO ��ֵ����
//        super.afterExecute(r, t);
    }


// TODO �Զ������ٷ�������ӡ��Ϣ

    /**
     * �̳߳��ӳٹر�ʱ���ȴ��̳߳��������ִ����ϣ���ͳ���̳߳����
     */
    @Override
    public void shutdown() {
        try {
            // ͳ����ִ����������ִ������δִ����������
            logger.info("{} �ر��̳߳أ� ��ִ������: {}, ����ִ������: {}, δִ�ж�����������: {}",
                    this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
            super.shutdown();
        } catch (Exception e) {

        }

        // TODO �̳߳ع���map �Ƴ�
        MyThreadPoolExecutorManage.getInstance().getThreadPoolExecutorMap().remove(poolName);
    }

    /**
     * �̳߳������ر�ʱ��ͳ���̳߳����
     */
    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> runnables = null;
        try {
            // ͳ����ִ����������ִ������δִ����������
            logger.info("{} �����ر��̳߳أ���ִ������: {}, ����ִ������: {}, δִ�ж�����������: {}",
                    this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
            runnables = super.shutdownNow();
        } catch (Exception e) {

        }
        MyThreadPoolExecutorManage.getInstance().getThreadPoolExecutorMap().remove(poolName);
        return runnables;
        // TODO �̳߳ع���map �Ƴ�


    }
}
