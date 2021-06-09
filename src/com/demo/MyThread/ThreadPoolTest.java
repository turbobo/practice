package com.demo.MyThread;

import java.util.concurrent.*;

/**
 * @Author Jusven
 * @Date 2021/4/27 18:10
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
/*        Integer a;   //必须要初始化a  才可以
        int b = a;
        b = 2;
        System.out.println(b);*/

        Integer a =127;
        Integer b =127;
        System.out.println(a == b);
        System.out.println("Byte: "+Byte.MAX_VALUE+"###"+Byte.MIN_VALUE+" byte_number: "+Byte.SIZE);
        boolean bl = true;
        Boolean aBoolean = new Boolean(true);
//        aBoolean.
//        System.out.println(bl.getB);



        ExecutorService executorService = new ThreadPoolExecutor(3,
                5,  //最多创建5个线程
                1,  //1s存活
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),  //最多可以8个等待
                Executors.defaultThreadFactory()
                );
        for (int i = 1; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "办理业务");
            });
        }
    }
}
