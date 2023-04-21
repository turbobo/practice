package com.demo.interview.feizhu_20230418;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SingletonQueue {

    private static SingletonQueue instance;

    private Queue<String> queue;

    private SingletonQueue() {
        queue = new ConcurrentLinkedQueue<>();
    }

    public static SingletonQueue getInstance() {
        if (instance == null) {
            synchronized (SingletonQueue.class) {
                if (instance == null) {
                    instance = new SingletonQueue();
                }
            }
        }
        return instance;
    }

    public void offer(String str) {
        queue.offer(str);
    }

    public String poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        SingletonQueue queue = SingletonQueue.getInstance();
        Thread t1 = new Thread(() -> {
            String a = "hloaiaa";
            for (int i = 0; i < a.length(); i++) {
                queue.offer(String.valueOf(a.charAt(i)));
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
                queue.offer(String.valueOf(b.charAt(i)));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                if (queue.size() > 0) {
                    System.out.print(queue.poll());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (queue.size() == 0) {
                    break;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
