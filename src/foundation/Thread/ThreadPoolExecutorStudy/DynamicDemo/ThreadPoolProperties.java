package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * �̳߳�����
 *
 * @author wangtongzhou 
 * @since 2022-03-11 21:41
 */
@Data
public class ThreadPoolProperties {

    /**
     * �̳߳�����
     */
    private String threadPoolName;

    /**
     * �����߳���
     */
    private Integer corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * ����߳���
     */
    private Integer maxPoolSize;

    /**
     * �����������
     */
    private Integer queueCapacity;

    /**
     * �ܾ�����
     */
    private String rejectedExecutionType = "AbortPolicy";

    /**
     * �����̴߳��ʱ��
     */
    private Long keepAliveTime = 1L;

    /**
     * �����̴߳��ʱ�䵥λ
     */
    private TimeUnit unit = TimeUnit.MILLISECONDS;


}