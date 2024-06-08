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
        
        // 创建子线程
        Thread childThread = new Thread(() -> {
            // 在子线程中获取父线程的 ApplicationContext
            ApplicationContext applicationContext = MyThreadContextHolder.getApplicationContext();
            // 在子线程中使用父线程的 ApplicationContext
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
