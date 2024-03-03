//package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 动态修改线程池参数
// *
// * @author wangtongzhou
// * @since 2022-03-13 17:27
// */
//@RestController
//public class DynamicThreadPoolPropertiesController {
//
//    @Autowired
//    private ContextRefresher contextRefresher;
//
//
//    @Autowired
//    private DynamicThreadPoolProperties dynamicThreadPoolProperties;
//
//
//    @Autowired
//    private DynamicThreadPoolManager dynamicThreadPoolManager;
//
//
//    @PostMapping("/threadPool/properties")
//    public void update() {
//        ThreadPoolProperties threadPoolProperties =
//                dynamicThreadPoolProperties.getExecutors().get(0);
//        threadPoolProperties.setCorePoolSize(20);
//        threadPoolProperties.setMaxPoolSize(50);
//        threadPoolProperties.setQueueCapacity(200);
//        threadPoolProperties.setRejectedExecutionType("CallerRunsPolicy");
//        contextRefresher.refresh();
//    }
//
//    @GetMapping("/threadPool/properties")
//    public Map<String, Object> queryThreadPoolProperties() {
//        Map<String, Object> metricMap = new HashMap<>();
//        List<Map> threadPools = new ArrayList<>();
//        dynamicThreadPoolManager.getThreadPoolExecutorMap().forEach((k, v) -> {
//            ThreadPoolMonitor threadPoolMonitor = (ThreadPoolMonitor) v;
//            Map<String, Object> poolInfo = new HashMap<>();
//            poolInfo.put("thread.pool.name", k);
//            poolInfo.put("thread.pool.core.size", threadPoolMonitor.getCorePoolSize());
//            poolInfo.put("thread.pool.largest.size", threadPoolMonitor.getLargestPoolSize());
//            poolInfo.put("thread.pool.max.size", threadPoolMonitor.getMaximumPoolSize());
//            poolInfo.put("thread.pool.thread.count", threadPoolMonitor.getPoolSize());
//            poolInfo.put("thread.pool.max.costTime", threadPoolMonitor.getMaxCostTime());
//            poolInfo.put("thread.pool.average.costTime", threadPoolMonitor.getAverageCostTime());
//            poolInfo.put("thread.pool.min.costTime", threadPoolMonitor.getMinCostTime());
//            poolInfo.put("thread.pool.active.count", threadPoolMonitor.getActiveCount());
//            poolInfo.put("thread.pool.completed.taskCount", threadPoolMonitor.getCompletedTaskCount());
//            poolInfo.put("thread.pool.queue.name", threadPoolMonitor.getQueue().getClass().getName());
//            poolInfo.put("thread.pool.rejected.name", threadPoolMonitor.getRejectedExecutionHandler().getClass().getName());
//            poolInfo.put("thread.pool.task.count", threadPoolMonitor.getTaskCount());
//            threadPools.add(poolInfo);
//        });
//        metricMap.put("threadPools", threadPools);
//        return metricMap;
//    }
//
//}