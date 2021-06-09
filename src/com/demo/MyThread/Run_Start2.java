package com.demo.MyThread;

/**
 * @Author Jusven
 * @Date 2021/6/2 22:14
 */
public class Run_Start2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是李四--继承Thread");
        }
    }
}
