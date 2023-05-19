package com.demo.concurrency.sync;

import com.demo.interview.feizhu_20230418.SingletonQueueContainer2;

/**
 *  3个线程交替执行
 */

public class Test4 {
    volatile int flag = 1;
    static Test4 test4 = new Test4();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        test4.method1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
 
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        test4.method2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
 
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        test4.method3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
 
            }
        }).start();
 
    }
 
    public synchronized void method1() throws InterruptedException {
        String a = "hloaiaa";
        // 一直等到 flag为1才执行后面代码
//        while (flag != 1){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        for (int i = 0; i < a.length(); i++) {
            if (flag != 1) {
                wait();
            }
            SingletonQueueContainer2.getInstance().offer(a.charAt(i));
            // 指定线程2执行
            flag = 2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 全部唤醒，然后自行选择是否等待，因为无法控制唤醒指定的线程
            notifyAll();
        }
//        System.out.println("method1=========1");
//        changeState();
        

 
 
 
    }
 
    public synchronized void method2() throws InterruptedException {
        String b = "el,lbb";
//        while (flag != 2){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("method2==================2");
//        changeState();
        for (int i = 0; i < b.length(); i++) {
            if (flag != 2) {
                wait();
            }
            SingletonQueueContainer2.getInstance().offer(b.charAt(i));
            flag = 3;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }


    }
 
    public synchronized void method3() throws InterruptedException {
        while (flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("method3=============================3");
        while (SingletonQueueContainer2.getInstance().size() > 0) {
            if (flag != 3) {
                wait();
            }
            System.out.print(SingletonQueueContainer2.getInstance().poll());
            flag = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }
//        changeState();

    }
 
    public void changeState(){
 
        if (flag == 1){
            flag = 2;
        }
 
        if (flag == 2){
            flag = 3;
        }
 
        if (flag == 3){
            flag = 1;
        }
    }
}
