package com.demo.interview.feizhu_20230418;

public class TestSingletonQueueContainer {

    public static void main(String[] args) throws InterruptedException {
//        volatile int flag = 1;

        Thread t1 = new Thread(() -> {
            String a = "hloaiaa";
            for (int i = 0; i < a.length(); i++) {
//                if (flag != 1) {
////                    wait();
//                }
                SingletonQueueContainer2.getInstance().offer(a.charAt(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            String b = "el,lbb";
            for (int i = 0; i < b.length(); i++) {
                SingletonQueueContainer2.getInstance().offer(b.charAt(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (SingletonQueueContainer2.getInstance().size() > 0) {
                System.out.print(SingletonQueueContainer2.getInstance().poll());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
