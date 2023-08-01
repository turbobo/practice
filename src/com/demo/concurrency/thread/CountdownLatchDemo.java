package com.demo.concurrency.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Jusven
 * @Date 2023/7/2 21:14
 * CountDownLatch ģ�� 6��ͬѧ�뿪���Һ󣬰೤����
 */
public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " ��ͬѧ �뿪");
                // ��������һ
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // ������Ϊ0ʱ���Ż����ִ�к���Ĵ���
        countDownLatch.await();

        // ���߳̿�����ִ��
        System.out.println("�೤����");

    }
}
