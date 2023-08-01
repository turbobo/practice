package com.demo.concurrency.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2023/7/2 21:39
 * �ź���
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //�����ź����������������: 3����λ
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=6 ; i++) {
            new Thread(() -> {
                try {
                    // ��ռ
                    semaphore.acquire();
                    // ��ռ��ִ��
                    System.out.println(Thread.currentThread().getName() + "�ų�  ����  �˳�λ");


                    // ģ��ͣ��ʱ��
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // �ͷų�λ
                    semaphore.release();
                    // �ͷź�ִ��
                    System.out.println(Thread.currentThread().getName() + "�ų�  �뿪  �˳�λ");


                }
            },String.valueOf(i)).start();
        }
    }
}
