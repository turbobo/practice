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
            // �����ִ�����������
            System.out.println("����7������");
        });

        for (int i = 1; i <= 7 ; i++) {
            new Thread(() -> {

                try {
                    System.out.println(Thread.currentThread().getName() + "���������ҵ�");
                    // ������ 7���͵ȴ�
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
