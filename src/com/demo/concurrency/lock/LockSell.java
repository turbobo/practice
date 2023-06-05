package com.demo.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/4/25 21:39
 *
 * 3个售票员卖出30张票
 */

//1、创建资源类，定义属性和操作方法
class LockTicket {
    //票数
    private int num = 30;
    //定义可重入锁
    private final ReentrantLock lock = new ReentrantLock(true);
    // false 非公平锁：可能导致有些线程获取不到锁
    //卖票
    public void sell () {
        //上锁
        lock.lock();

        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "线程 >> 卖出第" + (num--) + "张票，剩余：" + num + "张票");
            }
        } finally {
            // 无论发生什么异常，都要解锁
            lock.unlock();
        }
    }

}

public class LockSell {
    public static void main(String[] args) {
        LockTicket ticket = new LockTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        }, "CC").start();
    }

}
