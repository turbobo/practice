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
                System.out.println(Thread.currentThread().getName() + "线程正在运行，并试图获取b资源");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "线程正在运行, 获取b资源成功");

                }
            }

        }, "a").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "线程正在运行，并试图获取a资源");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "线程正在运行, 获取a资源成功");

                }
            }

        }, "b").start();

    }
}
