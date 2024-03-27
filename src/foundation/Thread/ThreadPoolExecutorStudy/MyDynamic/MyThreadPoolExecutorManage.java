package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/3/3 17:22
 * 执行任务时，从map中获取线程池对象，判断其状态，再去执行任务
 */
@Component
public class MyThreadPoolExecutorManage {
    private volatile static MyThreadPoolExecutorManage intance;
    // 可以做单例

    public static MyThreadPoolExecutorManage getInstance() {
        //第一层检查，检查是否有引用指向对象，高并发情况下会有多个线程同时进入
        if (null == intance) {
            //双重检查，防止多个线程同时进入第一层检查(因单例模式只允许存在一个对象，故在创建对象之前无引用指向对象，所有线程均可进入第一层检查)
            //当某一线程获得锁创建一个Singleton对象时,即已有引用指向对象，singleton不为空，从而保证只会创建一个对象
            //假设没有第二层检查，那么第一个线程创建完对象释放锁后，后面进入对象也会创建对象，会产生多个对象
            //synchronized只能保证有序性，但无法禁止指令重排
            synchronized (MyThreadPoolExecutorManage.class) {


                //第二层检查，第二个线程获取到的singleton是内存最新的值，因为volatile修饰了
                if(intance == null){
                    intance = new MyThreadPoolExecutorManage();
                }
            }
        }
        return intance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExecutorManage.class);

    /**
     * 存储线程池对象
     * 每个线程池 手动去实现MyThreadPoolExecutor，创建后加入map，销毁后从map移除
     */
    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new ConcurrentHashMap<>();

    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // 打印当前线程池管理信息
        System.out.println("当前有 " + threadPoolExecutorMap.size() + " 个线程池");
        for (java.lang.String s : threadPoolExecutorMap.keySet()) {
            System.out.println("线程池名称 " + s);
        }
        return threadPoolExecutorMap;
    }

    // 创建线程池
    public MyThreadPoolExecutor createThreadPool(String poolName, Integer activeThreshold, Integer alarmFlag, int corePoolSize, int maximumPoolSize,
                                 long keepAliveTime, TimeUnit unit, Integer capacity) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(poolName, activeThreshold, alarmFlag, corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, capacity);
        // TODO 加入线程池管理map
        getThreadPoolExecutorMap().put(poolName, myThreadPoolExecutor);
        // 初始化
        return myThreadPoolExecutor;
    }

    // 销毁线程池
    public void cancelThreadPool(String poolName) {
        MyThreadPoolExecutor myThreadPoolExecutor = getThreadPoolExecutorMap().get(poolName);
        if (null != myThreadPoolExecutor) {
            myThreadPoolExecutor.shutdown();
        }
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
