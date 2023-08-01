package com.demo.concurrency.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author Jusven
 * @Date 2023/7/2 21:29
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            // 满足就执行下下面代码
            System.out.println("集齐7个龙珠");
        });

        for (int i = 1; i <= 7 ; i++) {
            new Thread(() -> {

                try {
                    System.out.println(Thread.currentThread().getName() + "个龙珠已找到");
                    // 不满足 7个就等待
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }


    }
}
