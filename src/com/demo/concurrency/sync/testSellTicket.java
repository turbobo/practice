package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/4/25 21:05
 */

// 1、创建资源，属性及操作方法
class Ticket {
    private int num = 30;

    public synchronized void sell() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "线程 >> 卖出第" + (num--) + "张票，剩余：" + num + "张票");
        }
    }

}

public class testSellTicket {
    public static void main(String[] args) {
        // 创建Ticket对象
        Ticket ticket = new Ticket();
        //2、创建线程，调用资源的操作方法
        new Thread(() -> {
            // 运行次数需要大于30次，每个线程就能卖出不同票数
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
