package com.demo.concurrency.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2023/5/7 20:40
 */
// 定义资源类，属性、操作方法
class Phone {
    public  synchronized void sendMessage () throws InterruptedException {
        // 停4秒
        System.out.println("--- 停4秒");
        TimeUnit.SECONDS.sleep(4);
        System.out.println(" --- 线程1方法 sendMessage ");
    }

    public static synchronized void sendMail () {
        System.out.println(" --- 线程2方法 sendMail ");
    }

    public void hello() {
        System.out.println(" --- hello ");
    }
}
public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        /**
         * 在上述代码中，两个方法都使用了 synchronized 关键字修饰，并且都是用同一个 phone1 对象调用的，
         * 因此两个方法之间是互斥的，不能同时执行。
         * 由于线程1的代码先执行，所以 sendMessage 方法会先执行，
         * 而 sendMail 方法则要等待 sendMessage 方法执行完毕后才能执行。
         * 因此，sendMessage 先执行，sendMail 后执行。
         */
        // 1、两个方法sync 用一个对象执行 === 先执行线程1  再2
        //  --- sendMessage
        // --- sendMail
        new Thread(() -> {
            System.out.println("线程1 执行");
            try {
                phone1.sendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(100);
        System.out.println("------停100ms");


        new Thread(() -> {
            System.out.println("线程2 执行");

            phone1.sendMail();
//            phone1.hello();
//            phone2.sendMail();
        }, "BB").start();

        // 2、 1方法内部停留4秒：先执行线程1，停4秒，执行方法1，  再线程2，执行方法2

    }
}
