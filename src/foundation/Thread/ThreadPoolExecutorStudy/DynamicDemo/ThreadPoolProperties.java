package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * 线程池配置
 *
 * @author wangtongzhou 
 * @since 2022-03-11 21:41
 */
@Data
public class ThreadPoolProperties {

    /**
     * 线程池名称
     */
    private String threadPoolName;

    /**
     * 核心线程数
     */
    private Integer corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * 最大线程数
     */
    private Integer maxPoolSize;

    /**
     * 队列最大数量
     */
    private Integer queueCapacity;

    /**
     * 拒绝策略
     */
    private String rejectedExecutionType = "AbortPolicy";

    /**
     * 空闲线程存活时间
     */
    private Long keepAliveTime = 1L;

    /**
     * 空闲线程存活时间单位
     */
    private TimeUnit unit = TimeUnit.MILLISECONDS;


}