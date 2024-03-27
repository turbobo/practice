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
 * ִ������ʱ����map�л�ȡ�̳߳ض����ж���״̬����ȥִ������
 */
@Component
public class MyThreadPoolExecutorManage {
    private volatile static MyThreadPoolExecutorManage intance;
    // ����������

    public static MyThreadPoolExecutorManage getInstance() {
        //��һ���飬����Ƿ�������ָ����󣬸߲�������»��ж���߳�ͬʱ����
        if (null == intance) {
            //˫�ؼ�飬��ֹ����߳�ͬʱ�����һ����(����ģʽֻ�������һ�����󣬹��ڴ�������֮ǰ������ָ����������߳̾��ɽ����һ����)
            //��ĳһ�̻߳��������һ��Singleton����ʱ,����������ָ�����singleton��Ϊ�գ��Ӷ���ֻ֤�ᴴ��һ������
            //����û�еڶ����飬��ô��һ���̴߳���������ͷ����󣬺���������Ҳ�ᴴ�����󣬻�����������
            //synchronizedֻ�ܱ�֤�����ԣ����޷���ָֹ������
            synchronized (MyThreadPoolExecutorManage.class) {


                //�ڶ����飬�ڶ����̻߳�ȡ����singleton���ڴ����µ�ֵ����Ϊvolatile������
                if(intance == null){
                    intance = new MyThreadPoolExecutorManage();
                }
            }
        }
        return intance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPoolExecutorManage.class);

    /**
     * �洢�̳߳ض���
     * ÿ���̳߳� �ֶ�ȥʵ��MyThreadPoolExecutor�����������map�����ٺ��map�Ƴ�
     */
    public Map<String, MyThreadPoolExecutor> threadPoolExecutorMap = new ConcurrentHashMap<>();

    public Map<String, MyThreadPoolExecutor> getThreadPoolExecutorMap() {
        // ��ӡ��ǰ�̳߳ع�����Ϣ
        System.out.println("��ǰ�� " + threadPoolExecutorMap.size() + " ���̳߳�");
        for (java.lang.String s : threadPoolExecutorMap.keySet()) {
            System.out.println("�̳߳����� " + s);
        }
        return threadPoolExecutorMap;
    }

    // �����̳߳�
    public MyThreadPoolExecutor createThreadPool(String poolName, Integer activeThreshold, Integer alarmFlag, int corePoolSize, int maximumPoolSize,
                                 long keepAliveTime, TimeUnit unit, Integer capacity) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(poolName, activeThreshold, alarmFlag, corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, capacity);
        // TODO �����̳߳ع���map
        getThreadPoolExecutorMap().put(poolName, myThreadPoolExecutor);
        // ��ʼ��
        return myThreadPoolExecutor;
    }

    // �����̳߳�
    public void cancelThreadPool(String poolName) {
        MyThreadPoolExecutor myThreadPoolExecutor = getThreadPoolExecutorMap().get(poolName);
        if (null != myThreadPoolExecutor) {
            myThreadPoolExecutor.shutdown();
        }
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
