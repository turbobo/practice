package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/4/25 22:05
 *
 * sync + wait + notify 实现线程间通信--线程交替执行
 */

// 1、创建资源类，定义属性和操作方法

// 需要共享线程资源
class Share {
    // 初始值
    private int num = 0;

    // +1方法
    public synchronized void increase () throws InterruptedException {
        // 1) 首先判断为0  不是0 不可以执行+1操作,需要等待
        if (num != 0) {
//            System.out.println("线程1 wait >> ");
            this.wait();  // 哪里睡眠，哪里唤醒，会导致虚假唤醒，之前的判断直接被跳过，需要将if判断改为while循环判断！！！！！！！！！！
//            System.out.println("线程1 唤醒位置>> ");

        }
        // 2) 执行操作
        num++;
        System.out.println(Thread.currentThread().getName() + "线程 >> " + num);

        // 3)通知b线程
        this.notifyAll();
    }

    // -1方法
    public synchronized void decrease () throws InterruptedException {
        // 1) 首先判断为1 不是1 不可以执行 -1操作,需要等待
        while (num != 1) {
//            System.out.println("线程2 wait >> ");
            this.wait();
//            System.out.println("线程1 唤醒位置>> ");
        }
        // 2) 执行操作
        num--;
        System.out.println(Thread.currentThread().getName() + "线程 >> " + num);

        // 3)通知a线程
        this.notifyAll();
    }

}
public class ShareSyncDemo {
    public static void main(String[] args) {
        // 创建资源类
        Share share = new Share();

        // 创建线程
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

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }

}
