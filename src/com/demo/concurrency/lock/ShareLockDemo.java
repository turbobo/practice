package com.demo.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/5/7 15:16
 * lock�ӿ�ʵ�� �̼߳�ͨ��--�߳̽���ִ��
 *  ��������������
 */
// 1��������Դ�ࣺ���ԡ�����
class Share {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int num = 0;

    // +1
    public void increase() throws InterruptedException {
        // ��������������
        lock.lock();
        try {
            // i.�ж�
            while (num != 0) {
                condition.await();
            }
            // ii.�ɻ�
            num++;
            System.out.println(Thread.currentThread().getName() + "�߳� >> " + num);
            // iii.֪ͨ
            condition.signalAll();
        } finally {
            // ����
            lock.unlock();
        }

    }

    // -1
    public void decrease() throws InterruptedException {
        // ��������������
        lock.lock();
        try {
            // i.�ж�
            while (num != 1) {
                condition.await();
            }
            // ii.�ɻ�
            num--;
            System.out.println(Thread.currentThread().getName() + "�߳� >> " + num);
            // iii.֪ͨ
            condition.signalAll();
        } finally {
            // ����
            lock.unlock();
        }

    }
}

public class ShareLockDemo {
    public static void main(String[] args) {
        // ������Դ��
        Share share = new Share();
        // ���ö���̵߳���
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }


}
