package com.demo.concurrency.sync;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/5/28 17:12
 */
public class SyncDemo {

    public static synchronized void add() {
        add();
    }
    public static void main(String[] args) {

        // lock��ʾ �ֶ��ӽ���
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " ���");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " �ڲ�");
                } finally {
                    lock.unlock();  // ����Ҫ�ͷ���
                }
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            // ������� �ڲ㷽��ռ��������һֱ�ڻ�ȡ���������޷�����
            lock.lock();
            System.out.println("aa");
            lock.unlock();
        }, "aa").start();

        // sync ��ʽ  �Զ��ӽ���
        // ѭ�����ã�ջ���
//        SyncDemo.add();
//        Object o = new Object();
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(Thread.currentThread().getName() + "���");
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + "�в�");
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName() + "�ڲ�");
//                    }
//                }
//            }
//        }, "t1").start();

    }
}
