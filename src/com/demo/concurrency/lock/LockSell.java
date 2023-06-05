package com.demo.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2023/4/25 21:39
 *
 * 3����ƱԱ����30��Ʊ
 */

//1��������Դ�࣬�������ԺͲ�������
class LockTicket {
    //Ʊ��
    private int num = 30;
    //�����������
    private final ReentrantLock lock = new ReentrantLock(true);
    // false �ǹ�ƽ�������ܵ�����Щ�̻߳�ȡ������
    //��Ʊ
    public void sell () {
        //����
        lock.lock();

        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "�߳� >> ������" + (num--) + "��Ʊ��ʣ�ࣺ" + num + "��Ʊ");
            }
        } finally {
            // ���۷���ʲô�쳣����Ҫ����
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
