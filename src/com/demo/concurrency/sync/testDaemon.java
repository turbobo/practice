package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/4/25 20:48
 */
public class testDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " ==> " + Thread.currentThread().isDaemon());
            while (true) {
//                System.out.println("user thread is running");
            }
        });
//        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
