package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/3/3 17:22
 */
@Component
public class MyThreadPoolExecutorManage {
    private static MyThreadPoolExecutorManage intance = null;
    // 可以做单例

    public static MyThreadPoolExecutorManage getInstance() {
        if (null == intance) {
            intance = new MyThreadPoolExecutorManage();
        }
        return intance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExecutorManage.class);

    /**
     * 存储线程池对象
     * 每个线程池 手动去实现MyThreadPoolExecutor，创建后加入map，销毁后从map移除
     */
    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new HashMap<>();

    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // 打印当前线程池管理信息
        System.out.println("当前有 " + threadPoolExecutorMap.size() + " 个线程池");
        for (java.lang.String s : threadPoolExecutorMap.keySet()) {
            System.out.println("线程池名称 " + s);
        }
        return threadPoolExecutorMap;
    }

    // 创建线程池
    public MyThreadPoolExecutor createThreadPool(String poolName, int corePoolSize, int maximumPoolSize,
                                 long keepAliveTime, TimeUnit unit, Integer capacity) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(poolName, corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, capacity);
        // TODO 加入线程池管理map
        getThreadPoolExecutorMap().put(poolName, myThreadPoolExecutor);
        return myThreadPoolExecutor;
    }


    // TODO 提供参数修改

    // TODO 公共类，可以根据线程池名称修改指定参数
    // 分布式修改，加锁
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
    }

    //


}
