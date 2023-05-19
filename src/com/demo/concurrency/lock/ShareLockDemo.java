package com.demo.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/5/7 15:16
 * lock接口实现 线程间通信--线程交替执行
 *  首先上锁、解锁
 */
// 1、创建资源类：属性、方法
class Share {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int num = 0;

    // +1
    public void increase() throws InterruptedException {
        // 首先上锁、解锁
        lock.lock();
        try {
            // i.判断
            while (num != 0) {
                condition.await();
            }
            // ii.干活
            num++;
            System.out.println(Thread.currentThread().getName() + "线程 >> " + num);
            // iii.通知
            condition.signalAll();
        } finally {
            // 解锁
            lock.unlock();
        }

    }

    // -1
    public void decrease() throws InterruptedException {
        // 首先上锁、解锁
        lock.lock();
        try {
            // i.判断
            while (num != 1) {
                condition.await();
            }
            // ii.干活
            num--;
            System.out.println(Thread.currentThread().getName() + "线程 >> " + num);
            // iii.通知
            condition.signalAll();
        } finally {
            // 解锁
            lock.unlock();
        }

    }
}

public class ShareLockDemo {
    public static void main(String[] args) {
        // 创建资源类
        Share share = new Share();
        // 启用多个线程调用
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
