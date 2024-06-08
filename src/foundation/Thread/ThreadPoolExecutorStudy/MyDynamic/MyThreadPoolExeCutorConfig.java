package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo.ThreadPoolMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/3/3 16:26
 */
@Component
public class MyThreadPoolExeCutorConfig {
    // 线程池map统一管理所以线程池

    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new HashMap<>();
//
//
    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // 打印当前线程池管理信息
        System.out.println("当前有 " + threadPoolExecutorMap.size() + " 个线程池");
        for (String s : threadPoolExecutorMap.keySet()) {
            System.out.println("线程池名称 " + s);
        }
        return threadPoolExecutorMap;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExeCutorConfig.class);

//    // TODO 提供参数修改
//
//    // TODO 公共类，可以根据线程池名称修改指定参数
    public void configThreadPoolByName(String poolName, Integer corePoolSize, Integer maxPoolSize, Long keepAliveTime) {
        if (StringUtils.isEmpty(poolName)) {
            LOGGER.info("线程池名称为空，无法修改");
            return;
        }
        MyThreadPoolExecutor myThreadPoolExecutor = getThreadPoolExecutorMap().get(poolName);
        if (null == myThreadPoolExecutor) {
            LOGGER.info("线程池名称不存在，无法修改");
            return;
        }
        if (null != corePoolSize) {
            myThreadPoolExecutor.setCorePoolSize(corePoolSize);
        }
        if (null != maxPoolSize) {
            myThreadPoolExecutor.setMaximumPoolSize(maxPoolSize);
        }
        if (null != keepAliveTime) {
            myThreadPoolExecutor.setKeepAliveTime(keepAliveTime, TimeUnit.SECONDS);
        }

        // 修改队列容量 https://www.cnblogs.com/thisiswhy/p/15457810.html
        ResizeableCapacityLinkedBlockingQueue<Runnable> queue = (ResizeableCapacityLinkedBlockingQueue)executor.getQueue();
        queue.setCapacity(100);
    }


    //

}
