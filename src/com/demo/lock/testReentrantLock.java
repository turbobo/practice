package com.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/1/12 20:53
 */
public class testReentrantLock {
    static int num = 11;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(testReentrantLock::tt, "thread1").start();
        new Thread(testReentrantLock::tt,"thread2").start();
        new Thread(testReentrantLock::tt,"thread3").start();
    }
    static void tt() {
        String name = Thread.currentThread().getName();

        while (num > 1) {
            lock.lock();
            num--;
            System.out.println(name + " --- " + num);
            if (num < 1) {
                break;
            }
            lock.unlock();
        }
    }

}
