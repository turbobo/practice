package com.demo.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/5/7 16:55
 * lock 实现线程间定制化通信
 */
// 定义资源类
class ShareResource {
    private Lock lock = new ReentrantLock();
    // 标志位：不同的线程执行 1-AA  2-BB  3-CC
    private int flag = 1;
    // 定义3个
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    /**
     * 线程1 打印方法
     *
     * @param loop 循环轮数
     */
    public void print5(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            // 判断
            while (flag != 1) {
                condition1.await();
            }

            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " 轮数: " + loop);
            }
            // 修改标志位
            flag = 2;
            // 通知 线程2
            condition2.signal();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    /**
     * 线程2 打印方法
     *
     * @param loop 循环轮数
     */
    public void print10(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            // 判断
            while (flag != 2) {
                condition2.await();
            }

            // 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " 轮数: " + loop);
            }
            // 修改标志位
            flag = 3;
            // 通知 线程2
            condition3.signal();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    /**
     * 线程3 打印方法
     *
     * @param loop 循环轮数
     */
    public void print15(int loop) throws InterruptedException {
        //上锁
        lock.lock();
        try {
            // 判断
            while (flag != 3) {
                condition3.await();
            }

            // 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " 轮数: " + loop);
            }
            // 修改标志位
            flag = 1;
            // 通知 线程2
            condition1.signal();
        } finally {
            //解锁
            lock.unlock();
        }
    }

}

public class ThreadDemo3 {
    public static void main(String[] args) {
        System.out.println("============================");
        // 创建资源类
        ShareResource shareResource = new ShareResource();
        // 创建多个线程执行
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
