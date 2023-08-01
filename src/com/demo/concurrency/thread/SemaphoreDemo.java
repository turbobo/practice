package com.demo.concurrency.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2023/7/2 21:39
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建信号量，设置许可数量: 3个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=6 ; i++) {
            new Thread(() -> {
                try {
                    // 抢占
                    semaphore.acquire();
                    // 抢占后执行
                    System.out.println(Thread.currentThread().getName() + "号车  抢到  了车位");


                    // 模拟停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放车位
                    semaphore.release();
                    // 释放后执行
                    System.out.println(Thread.currentThread().getName() + "号车  离开  了车位");


                }
            },String.valueOf(i)).start();
        }
    }
}
