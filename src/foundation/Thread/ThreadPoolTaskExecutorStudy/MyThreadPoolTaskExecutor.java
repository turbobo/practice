package foundation.Thread.ThreadPoolTaskExecutorStudy;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jusven
 * @Date 2024/3/3 12:57
 * �Զ����̳߳ط�װ
 */
public class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    ThreadPoolExecutor threadPoolExecutor = threadPoolTaskExecutor.getThreadPoolExecutor();
    //

    // �Զ��幤������

    // �Զ�������ִ��ǰ�� �߼���ǿ
//    public beforeExecute(Thread t, Runnable r) {
//        super.be
//    }
}
