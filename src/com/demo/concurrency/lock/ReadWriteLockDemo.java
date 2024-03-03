package com.demo.concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Jusven
 * @Date 2023/8/20 20:06
 * 读写锁 案例
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();


        // 2 获取读锁
        readLock.lock();
        System.out.println("获取读锁");   // 先获取读锁，再获取写锁，程序会一直执行，因为读锁无法升级为写锁


        // 1 获取写锁
        writeLock.lock();
        System.out.println("获取写锁");

        // 2 获取读锁
//        readLock.lock();
//        System.out.println("获取读锁");

        // 释放写锁
        writeLock.unlock();

        readLock.unlock();



    }
}
