package com.demo.interview.feizhu_20230418;

import java.util.LinkedList;
import java.util.Queue;

public class ThreeThread {
    // 记录字符顺序
    private Queue<Character> queue = new LinkedList<>();
    // 懒汉式
    private static ThreeThread instance = null;
    private ThreeThread () {}
    public static ThreeThread getInstance() {
        if (null == instance) {
            synchronized (ThreeThread.class) {
                if (null == instance) {
                    instance = new ThreeThread();
                }
            }
        }
        return instance;
    }

    public char peek() {
        return queue.peek();
    }

    public char poll() {
        return queue.poll();
    }

    public void put(char ch) {
        queue.offer(ch);
    }

    public int size() {
        return queue.size();
    }

    public synchronized void insertA(String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            while (ThreeThread.getInstance().size() > 0) {
                wait();
            }
            queue.offer(str.charAt(i));
            Thread.sleep(1000);
            notifyAll();
        }
    }

    public synchronized void insertB(String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            while (ThreeThread.getInstance().size() > 0) {
                wait();
            }
            queue.offer(str.charAt(i));
            Thread.sleep(1000);
            notifyAll();
        }
    }

    public synchronized String remove() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            while (ThreeThread.getInstance().size() == 0) {
                wait();
            }
            char c = ThreeThread.getInstance().poll();
            sb.append(c);
            Thread.sleep(1000);
            if (ThreeThread.getInstance().size() == 0) {
                notifyAll();
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ThreeThread example = new ThreeThread();

        Thread threadA = new Thread(() -> {
            try {
                example.insertA("hloaiaa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                example.insertB("el,lbb");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                while (true) {
                    String str = example.remove();
                    System.out.print(str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
