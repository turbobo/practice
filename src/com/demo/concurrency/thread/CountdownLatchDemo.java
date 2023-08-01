package com.demo.concurrency.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Jusven
 * @Date 2023/7/2 21:14
 * CountDownLatch 模拟 6个同学离开教室后，班长锁门
 */
public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " 号同学 离开");
                // 计数器减一
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 计数器为0时，才会继续执行后面的代码
        countDownLatch.await();

        // 主线程可能先执行
        System.out.println("班长锁门");

    }
}
