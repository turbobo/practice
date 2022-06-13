package foundation.summary;

import com.demo.MyThread.ThreadPoolTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangbo82
 * @Date: 2022年06月09日 21:03
 */
public class MyTaskTest {
    public static void main(String[] args) {
        //创建一个线程池对象
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
        //创建循环对象
        for (int i = 1; i <= 20; i++) {
            MyTask myTask = new MyTask("客户" + i);
            poolExecutor.submit(myTask);
        }
        //关闭线程池
        poolExecutor.shutdown();
    }
}
