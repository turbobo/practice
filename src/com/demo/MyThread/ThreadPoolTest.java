package com.demo.MyThread;

import java.util.concurrent.*;

/**
 * @Author Jusven
 * @Date 2021/4/27 18:10
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
/*        Integer a;   //����Ҫ��ʼ��a  �ſ���
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
                5,  //��ഴ��5���߳�
                1,  //1s���
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),  //������8���ȴ�
                Executors.defaultThreadFactory()
                );
        for (int i = 1; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "����ҵ��");
            });
        }
    }
}
