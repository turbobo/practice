package com.demo.concurrency.thread;

/**
 * @Author Jusven
 * @Date 2023/7/2 16:19
 */
public class deadLockDemo {
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "�߳��������У�����ͼ��ȡb��Դ");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "�߳���������, ��ȡb��Դ�ɹ�");

                }
            }

        }, "a").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "�߳��������У�����ͼ��ȡa��Դ");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "�߳���������, ��ȡa��Դ�ɹ�");

                }
            }

        }, "b").start();

    }
}
