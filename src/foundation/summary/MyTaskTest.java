package foundation.summary;

import com.demo.MyThread.ThreadPoolTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangbo82
 * @Date: 2022��06��09�� 21:03
 */
public class MyTaskTest {
    public static void main(String[] args) {
        //����һ���̳߳ض���
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
        //����ѭ������
        for (int i = 1; i <= 20; i++) {
            MyTask myTask = new MyTask("�ͻ�" + i);
            poolExecutor.submit(myTask);
        }
        //�ر��̳߳�
        poolExecutor.shutdown();
    }
}
