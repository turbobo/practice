package foundation.Thread.ThreadPoolExecutorStudy.MyDynamic;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/3/3 16:04
 */
public class test {

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.class.path"));



//        MyThreadPoolExecutorManage myThreadPoolExecutorManage = new MyThreadPoolExecutorManage();
        MyThreadPoolExecutor myThreadPoolExecutor = MyThreadPoolExecutorManage.getInstance().createThreadPool(
                "自定义线程池", 10, 1,
                1, 20, 60, TimeUnit.SECONDS, 4);

        MyThreadPoolExecutor myThreadPoolExecutor2 = MyThreadPoolExecutorManage.getInstance().createThreadPool(
                "自定义线程池2", 10, 1,
                1, 20, 60, TimeUnit.SECONDS, 50);
//        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
//                "自定义线程池",
//                5, 10, 60, TimeUnit.SECONDS, 50);
        for (int i = 0; i < 50; i++) {
            myThreadPoolExecutor.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " is running ");
            });

        }

//        myThreadPoolExecutor.shutdown();
    }
}
