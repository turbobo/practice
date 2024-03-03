package com.demo.concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Jusven
 * @Date 2023/8/20 20:06
 * ��д�� ����
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();


        // 2 ��ȡ����
        readLock.lock();
        System.out.println("��ȡ����");   // �Ȼ�ȡ�������ٻ�ȡд���������һֱִ�У���Ϊ�����޷�����Ϊд��


        // 1 ��ȡд��
        writeLock.lock();
        System.out.println("��ȡд��");

        // 2 ��ȡ����
//        readLock.lock();
//        System.out.println("��ȡ����");

        // �ͷ�д��
        writeLock.unlock();

        readLock.unlock();



    }
}
