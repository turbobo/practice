package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/7/18 21:20
 */
public class SynchronizedDemo {
    private synchronized void fun1() {

    }

    private void func2() {
        synchronized (this) {
            System.out.println();
        }
    }

    private synchronized static void fun3() {

    }

    public static void main(String[] args) {
//        ObjectMonitor
        String version = System.getProperty("java.version");
        System.out.println("JDK °æ±¾£º" + version);
    }
}

