package com.demo.concurrency.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2023/5/7 20:40
 */
// ������Դ�࣬���ԡ���������
class Phone {
    public  synchronized void sendMessage () throws InterruptedException {
        // ͣ4��
        System.out.println("--- ͣ4��");
        TimeUnit.SECONDS.sleep(4);
        System.out.println(" --- �߳�1���� sendMessage ");
    }

    public static synchronized void sendMail () {
        System.out.println(" --- �߳�2���� sendMail ");
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
         * �����������У�����������ʹ���� synchronized �ؼ������Σ����Ҷ�����ͬһ�� phone1 ������õģ�
         * �����������֮���ǻ���ģ�����ͬʱִ�С�
         * �����߳�1�Ĵ�����ִ�У����� sendMessage ��������ִ�У�
         * �� sendMail ������Ҫ�ȴ� sendMessage ����ִ����Ϻ����ִ�С�
         * ��ˣ�sendMessage ��ִ�У�sendMail ��ִ�С�
         */
        // 1����������sync ��һ������ִ�� === ��ִ���߳�1  ��2
        //  --- sendMessage
        // --- sendMail
        new Thread(() -> {
            System.out.println("�߳�1 ִ��");
            try {
                phone1.sendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(100);
        System.out.println("------ͣ100ms");


        new Thread(() -> {
            System.out.println("�߳�2 ִ��");

            phone1.sendMail();
//            phone1.hello();
//            phone2.sendMail();
        }, "BB").start();

        // 2�� 1�����ڲ�ͣ��4�룺��ִ���߳�1��ͣ4�룬ִ�з���1��  ���߳�2��ִ�з���2

    }
}
