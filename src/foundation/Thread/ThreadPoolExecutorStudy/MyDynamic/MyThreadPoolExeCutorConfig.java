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
    // �̳߳�mapͳһ���������̳߳�

    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new HashMap<>();
//
//
    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // ��ӡ��ǰ�̳߳ع�����Ϣ
        System.out.println("��ǰ�� " + threadPoolExecutorMap.size() + " ���̳߳�");
        for (String s : threadPoolExecutorMap.keySet()) {
            System.out.println("�̳߳����� " + s);
        }
        return threadPoolExecutorMap;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExeCutorConfig.class);

//    // TODO �ṩ�����޸�
//
//    // TODO �����࣬���Ը����̳߳������޸�ָ������
    public void configThreadPoolByName(String poolName, Integer corePoolSize, Integer maxPoolSize, Long keepAliveTime) {
        if (StringUtils.isEmpty(poolName)) {
            LOGGER.info("�̳߳�����Ϊ�գ��޷��޸�");
            return;
        }
        MyThreadPoolExecutor myThreadPoolExecutor = getThreadPoolExecutorMap().get(poolName);
        if (null == myThreadPoolExecutor) {
            LOGGER.info("�̳߳����Ʋ����ڣ��޷��޸�");
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

        // �޸Ķ������� https://www.cnblogs.com/thisiswhy/p/15457810.html
        ResizeableCapacityLinkedBlockingQueue<Runnable> queue = (ResizeableCapacityLinkedBlockingQueue)executor.getQueue();
        queue.setCapacity(100);
    }


    //

}
