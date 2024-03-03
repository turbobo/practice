//package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * 动态刷新线程池
// *
// * @author wangtongzhou
// * @since 2022-03-13 14:13
// */
//@Component
//@Slf4j
//public class DynamicThreadPoolManager {
//
//
//    @Autowired
//    private DynamicThreadPoolProperties dynamicThreadPoolProperties;
//
//    /**
//     * 存储线程池对象
//     */
//    public Map<String, ThreadPoolMonitor> threadPoolExecutorMap = new HashMap<>();
//
//
//    public Map<String, ThreadPoolMonitor> getThreadPoolExecutorMap() {
//        return threadPoolExecutorMap;
//    }
//
//
//    /**
//     * 初始化线程池
//     */
//    @PostConstruct
//    public void init() {
//        createThreadPools(dynamicThreadPoolProperties);
//    }
//
//    /**
//     * 初始化线程池的创建
//     *
//     * @param dynamicThreadPoolProperties
//     */
//    private void createThreadPools(DynamicThreadPoolProperties dynamicThreadPoolProperties) {
//        dynamicThreadPoolProperties.getExecutors().forEach(config -> {
//            if (!threadPoolExecutorMap.containsKey(config.getThreadPoolName())) {
//                ThreadPoolMonitor threadPoolMonitor = new ThreadPoolMonitor(
//                        config.getCorePoolSize(),
//                        config.getMaxPoolSize(),
//                        config.getKeepAliveTime(),
//                        config.getUnit(),
//                        new ResizableCapacityLinkedBlockingQueue<>(config.getQueueCapacity()),
//                        RejectedExecutionHandlerEnum.getRejectedExecutionHandler(config.getRejectedExecutionType()),
//                        config.getThreadPoolName()
//                );
//                threadPoolExecutorMap.put(config.getThreadPoolName(),
//                        threadPoolMonitor);
//            }
//
//        });
//    }
//
//    /**
//     * 调整线程池
//     *
//     * @param dynamicThreadPoolProperties
//     */
//    private void changeThreadPools(DynamicThreadPoolProperties dynamicThreadPoolProperties) {
//        dynamicThreadPoolProperties.getExecutors().forEach(config -> {
//            ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorMap.get(config.getThreadPoolName());
//            if (Objects.nonNull(threadPoolExecutor)) {
//                threadPoolExecutor.setCorePoolSize(config.getCorePoolSize());
//                threadPoolExecutor.setMaximumPoolSize(config.getMaxPoolSize());
//                threadPoolExecutor.setKeepAliveTime(config.getKeepAliveTime(), config.getUnit());
//                threadPoolExecutor.setRejectedExecutionHandler(RejectedExecutionHandlerEnum.getRejectedExecutionHandler(config.getRejectedExecutionType()));
//                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
//                if (queue instanceof ResizableCapacityLinkedBlockingQueue) {
//                    ((ResizableCapacityLinkedBlockingQueue<Runnable>) queue).setCapacity(config.getQueueCapacity());
//                }
//            }
//        });
//    }
//
//
//    @EventListener
//    public void envListener(EnvironmentChangeEvent event) {
//        log.info("配置发生变更" + event);
//        changeThreadPools(dynamicThreadPoolProperties);
//    }
//
//}