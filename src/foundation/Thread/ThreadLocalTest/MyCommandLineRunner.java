package foundation.Thread.ThreadLocalTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private MyThreadContextHolder threadContextHolder = new MyThreadContextHolder();

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext1 = ApplicationContextProvider.getApplicationContext();
        System.out.println(applicationContext1);
        threadContextHolder.setApplicationContext(applicationContext1);
        
        // �������߳�
        Thread childThread = new Thread(() -> {
            // �����߳��л�ȡ���̵߳� ApplicationContext
            ApplicationContext applicationContext = MyThreadContextHolder.getApplicationContext();
            // �����߳���ʹ�ø��̵߳� ApplicationContext
            // Your code here...
            System.out.println(applicationContext);
        });
        childThread.start();
    }

    public static void main(String[] args) throws Exception {
        MyCommandLineRunner  runner = new MyCommandLineRunner();
        runner.run();
    }
}
