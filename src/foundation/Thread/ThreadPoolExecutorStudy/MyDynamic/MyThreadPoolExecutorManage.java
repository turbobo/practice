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
    // ����������

    public static MyThreadPoolExecutorManage getInstance() {
        if (null == intance) {
            intance = new MyThreadPoolExecutorManage();
        }
        return intance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExecutorManage.class);

    /**
     * �洢�̳߳ض���
     * ÿ���̳߳� �ֶ�ȥʵ��MyThreadPoolExecutor�����������map�����ٺ��map�Ƴ�
     */
    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new HashMap<>();

    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // ��ӡ��ǰ�̳߳ع�����Ϣ
        System.out.println("��ǰ�� " + threadPoolExecutorMap.size() + " ���̳߳�");
        for (java.lang.String s : threadPoolExecutorMap.keySet()) {
            System.out.println("�̳߳����� " + s);
        }
        return threadPoolExecutorMap;
    }

    // �����̳߳�
    public MyThreadPoolExecutor createThreadPool(String poolName, int corePoolSize, int maximumPoolSize,
                                 long keepAliveTime, TimeUnit unit, Integer capacity) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(poolName, corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, capacity);
        // TODO �����̳߳ع���map
        getThreadPoolExecutorMap().put(poolName, myThreadPoolExecutor);
        return myThreadPoolExecutor;
    }


    // TODO �ṩ�����޸�

    // TODO �����࣬���Ը����̳߳������޸�ָ������
    // �ֲ�ʽ�޸ģ�����
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
    }

    //


}
