package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/4/25 21:05
 */

// 1��������Դ�����Լ���������
class Ticket {
    private int num = 30;

    public synchronized void sell() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "�߳� >> ������" + (num--) + "��Ʊ��ʣ�ࣺ" + num + "��Ʊ");
        }
    }

}

public class testSellTicket {
    public static void main(String[] args) {
        // ����Ticket����
        Ticket ticket = new Ticket();
        //2�������̣߳�������Դ�Ĳ�������
        new Thread(() -> {
            // ���д�����Ҫ����30�Σ�ÿ���߳̾���������ͬƱ��
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        }, "AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sell();
                }
            }
        }, "BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sell();
                }
            }
        }, "CC").start();
    }
}
