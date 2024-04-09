package com.demo.concurrency.thread;

import org.springframework.context.ApplicationContext;

/**
 * @Author Jusven
 * @Date 2023/6/21 15:49
 */
public class TestJoin {
    private static ApplicationContext context = null;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running ");
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                // t2线程需要在t1线程结束后执行
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running ");
        }, "t2");
        Thread t3 = new Thread(() -> {
            try {
                // t3线程需要在t2线程结束后执行
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running ");
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

    }
}
