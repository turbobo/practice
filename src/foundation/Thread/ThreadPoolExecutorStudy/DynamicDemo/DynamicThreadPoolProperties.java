package foundation.Thread.ThreadPoolExecutorStudy.DynamicDemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ��̬ˢ���̳߳�����
 *
 * @author wangtongzhou 
 * @since 2022-03-13 14:09
 */
@ConfigurationProperties(prefix = "monitor.threadpool")
@Data
@Component
public class DynamicThreadPoolProperties {

    private List<ThreadPoolProperties> executors;
}