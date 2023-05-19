package com.demo.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/5/7 16:55
 * lock ʵ���̼߳䶨�ƻ�ͨ��
 */
// ������Դ��
class ShareResource {
    private Lock lock = new ReentrantLock();
    // ��־λ����ͬ���߳�ִ�� 1-AA  2-BB  3-CC
    private int flag = 1;
    // ����3��
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    /**
     * �߳�1 ��ӡ����
     *
     * @param loop ѭ������
     */
    public void print5(int loop) throws InterruptedException {
        //����
        lock.lock();
        try {
            // �ж�
            while (flag != 1) {
                condition1.await();
            }

            // �ɻ�
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " ����: " + loop);
            }
            // �޸ı�־λ
            flag = 2;
            // ֪ͨ �߳�2
            condition2.signal();
        } finally {
            //����
            lock.unlock();
        }
    }

    /**
     * �߳�2 ��ӡ����
     *
     * @param loop ѭ������
     */
    public void print10(int loop) throws InterruptedException {
        //����
        lock.lock();
        try {
            // �ж�
            while (flag != 2) {
                condition2.await();
            }

            // �ɻ�
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " ����: " + loop);
            }
            // �޸ı�־λ
            flag = 3;
            // ֪ͨ �߳�2
            condition3.signal();
        } finally {
            //����
            lock.unlock();
        }
    }

    /**
     * �߳�3 ��ӡ����
     *
     * @param loop ѭ������
     */
    public void print15(int loop) throws InterruptedException {
        //����
        lock.lock();
        try {
            // �ж�
            while (flag != 3) {
                condition3.await();
            }

            // �ɻ�
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " ����: " + loop);
            }
            // �޸ı�־λ
            flag = 1;
            // ֪ͨ �߳�2
            condition1.signal();
        } finally {
            //����
            lock.unlock();
        }
    }

}

public class ThreadDemo3 {
    public static void main(String[] args) {
        System.out.println("============================");
        // ������Դ��
        ShareResource shareResource = new ShareResource();
        // ��������߳�ִ��
        new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
