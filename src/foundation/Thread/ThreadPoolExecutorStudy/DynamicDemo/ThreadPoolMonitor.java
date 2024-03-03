package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * �̳߳ؼ����
 *
 * @author wangtongzhou 
 * @since 2022-02-23 07:27
 */
public class ThreadPoolMonitor extends ThreadPoolExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolMonitor.class);

    /**
     * Ĭ�Ͼܾ�����
     */
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();

    /**
     * �̳߳����ƣ�һ����ҵ��������������������
     */
    private String poolName;

    /**
     * ���ִ��ʱ��
     */
    private Long minCostTime;

    /**
     * �ִ��ʱ��
     */
    private Long maxCostTime;
    /**
     * �ܵĺ�ʱ
     */
    private AtomicLong totalCostTime = new AtomicLong();

    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    /**
     * ���ø���Ĺ��췽��������ʼ��HashMap���̳߳�����
     *
     * @param corePoolSize    �̳߳غ����߳���
     * @param maximumPoolSize �̳߳�����߳���
     * @param keepAliveTime   �̵߳�������ʱ��
     * @param unit            ����ʱ��ĵ�λ
     * @param workQueue       ���汻�ύ����Ķ���
     * @param poolName        �̳߳�����
     */
    public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                             TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory(), poolName);
    }


    /**
     * ���ø���Ĺ��췽��������ʼ��HashMap���̳߳�����
     *
     * @param corePoolSize    �̳߳غ����߳���
     * @param maximumPoolSize �̳߳�����߳���
     * @param keepAliveTime   �̵߳�������ʱ��
     * @param unit            ����ʱ��ĵ�λ
     * @param workQueue       ���汻�ύ����Ķ���
     * @param
     * @param poolName        �̳߳�����
     */
    public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                             TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler, String poolName) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory(), handler, poolName);
    }


    /**
     * ���ø���Ĺ��췽��������ʼ��HashMap���̳߳�����
     *
     * @param corePoolSize    �̳߳غ����߳���
     * @param maximumPoolSize �̳߳�����߳���
     * @param keepAliveTime   �̵߳�������ʱ��
     * @param unit            ����ʱ��ĵ�λ
     * @param workQueue       ���汻�ύ����Ķ���
     * @param threadFactory   �̹߳���
     * @param poolName        �̳߳�����
     */
    public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                             TimeUnit unit, BlockingQueue<Runnable> workQueue,
                             ThreadFactory threadFactory, String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
        this.poolName = poolName;
    }


    /**
     * ���ø���Ĺ��췽��������ʼ��HashMap���̳߳�����
     *
     * @param corePoolSize    �̳߳غ����߳���
     * @param maximumPoolSize �̳߳�����߳���
     * @param keepAliveTime   �̵߳�������ʱ��
     * @param unit            ����ʱ��ĵ�λ
     * @param workQueue       ���汻�ύ����Ķ���
     * @param threadFactory   �̹߳���
     * @param handler         �ܾ�����
     * @param poolName        �̳߳�����
     */
    public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                             TimeUnit unit, BlockingQueue<Runnable> workQueue,
                             ThreadFactory threadFactory, RejectedExecutionHandler handler, String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        this.poolName = poolName;
    }


    /**
     * �̳߳��ӳٹر�ʱ���ȴ��̳߳��������ִ����ϣ���ͳ���̳߳����
     */
    @Override
    public void shutdown() {
        // ͳ����ִ����������ִ������δִ����������
        LOGGER.info("{} �ر��̳߳أ� ��ִ������: {}, ����ִ������: {}, δִ����������: {}",
                this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
        super.shutdown();
    }

    /**
     * �̳߳������ر�ʱ��ͳ���̳߳����
     */
    @Override
    public List<Runnable> shutdownNow() {
        // ͳ����ִ����������ִ������δִ����������
        LOGGER.info("{} �����ر��̳߳أ���ִ������: {}, ����ִ������: {}, δִ����������: {}",
                this.poolName, this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size());
        return super.shutdownNow();
    }

    /**
     * ����ִ��֮ǰ����¼����ʼʱ��
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimeThreadLocal.set(System.currentTimeMillis());
    }

    /**
     * ����ִ��֮�󣬼����������ʱ��
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long costTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        // TODO ʹ����֮�󣬼ǵ�����ThreadLocal����ֹ�ڴ�й©
        startTimeThreadLocal.remove();
        maxCostTime = maxCostTime > costTime ? maxCostTime : costTime;
        if (getCompletedTaskCount() == 0) {
            minCostTime = costTime;
        }
        minCostTime = minCostTime < costTime ? minCostTime : costTime;
        totalCostTime.addAndGet(costTime);
        LOGGER.info("{}-pool-monitor: " +
                        "�����ʱ: {} ms, ��ʼ�߳���: {}, �����߳���: {}, ִ�е���������: {}, " +
                        "�������������: {}, ��������: {}, �����ﻺ�����������: {}, ���д��ڵ�����߳���: {}, " +
                        "���������߳���: {},  �߳̿���ʱ��: {}, �̳߳��Ƿ�ر�: {}, �̳߳��Ƿ���ֹ: {}",
                this.poolName,
                costTime, this.getPoolSize(), this.getCorePoolSize(), this.getActiveCount(),
                this.getCompletedTaskCount(), this.getTaskCount(), this.getQueue().size(), this.getLargestPoolSize(),
                this.getMaximumPoolSize(), this.getKeepAliveTime(TimeUnit.MILLISECONDS), this.isShutdown(), this.isTerminated());
    }


    public Long getMinCostTime() {
        return minCostTime;
    }

    public Long getMaxCostTime() {
        return maxCostTime;
    }

    public long getAverageCostTime(){
        if(getCompletedTaskCount()==0||totalCostTime.get()==0){
            return 0;
        }
        return totalCostTime.get()/getCompletedTaskCount();
    }

    /**
     * �����̳߳����õ��̣߳���д���̳߳�Ĭ�ϵ��̹߳����������̳߳����ƣ���������׷��
     */
    static class MonitorThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        /**
         * ��ʼ���̹߳���
         *
         * @param poolName �̳߳�����
         */
        MonitorThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            group = Objects.nonNull(s) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}