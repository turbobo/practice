package com.demo.MyThread;

import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2021/6/2 22:03
 * Thread中run方法和start方法的区别
 * 直接调用run方法不会启动线程，run只是作为线程类的一个普通方法,交给主线程去执行run方法
 * 调用start方法，thread1线程开启，会和主线程抢占资源了。也就是有两个线程在跑了。
 *
 */
//public class Run_Start extends Thread{
public class Run_Start implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("我是张三--实现Runnable接口");
        }
    }
//    @Override
//    public void run() {
//        for (int i=0; i<10; i++){
//            System.out.println("我是李四");
//        }
//    }
}
