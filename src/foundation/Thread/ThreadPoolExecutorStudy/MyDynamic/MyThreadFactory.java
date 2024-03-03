package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Jusven
 * @Date 2024/3/3 15:41
 */
public class MyThreadFactory implements ThreadFactory {
    private String threadNamePrefix;
    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    public MyThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        t.setName(threadNamePrefix + "_" +  poolNumber.getAndIncrement() + "_thread");
        return null;
    }


}
