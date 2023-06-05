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

        // lock显示 手动加解锁
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " 内层");
                } finally {
                    lock.unlock();  // 必须要释放锁
                }
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            // 被上面的 内层方法占用了锁，一直在获取锁，程序无法结束
            lock.lock();
            System.out.println("aa");
            lock.unlock();
        }, "aa").start();

        // sync 隐式  自动加解锁
        // 循环调用，栈溢出
//        SyncDemo.add();
//        Object o = new Object();
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(Thread.currentThread().getName() + "外层");
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + "中层");
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName() + "内层");
//                    }
//                }
//            }
//        }, "t1").start();

    }
}
