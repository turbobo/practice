package com.demo.lock;

public class Deadlock {
    public static String str1 = "str1";
    public static String str2 = "str2";

    public static void main(String[] args){
        Thread a = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str1){  //线程0锁住str1
                        System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        Thread.sleep(1000);  //线程0休眠  唤醒线程1
                        // 等待线程1执行完再继续
                        // 线程0休眠完了之后需要去锁str2才能继续运行,但是str2已经被线程1给锁住了，这边只能等待
                        synchronized(Deadlock.str2){
                            System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str2){  //线程1锁住str2
                        System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        Thread.sleep(1000);  //线程1休眠
                        //  等待线程0执行完再继续
                        // 线程1休眠完了之后需要去锁str1才能继续运行,但是str1已经被线程0给锁住了，这边只能等待，无法继续运行
                        synchronized(Deadlock.str1){
                            System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }
}