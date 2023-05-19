package com.demo.interview.feizhu_20230418;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author Jusven
 * @Date 2023/4/26 17:28
 *
 * 1. 单例队列容器消费
 * 实现一个单例队列容器，提供三个方法 offer，poll，size写三个线程，
 * 线程1将字符串a每隔1s挨个添加到容器中，线程2将字符串b每隔1s挨个添加到容器中，线程1与线程2交替执行，线程3监听容器变化，调用poll每隔1s挨个输出
 * 示例：
 * 输入：a = "hloaiaa", b = "el,lbb"
 * 输出：hello,alibaba
 *
 * //  控制输出顺序
 */
public class SingletonQueueContainerBySequence {

    private static SingletonQueueContainerBySequence instance = null;

    private Queue<Character> queue = new LinkedList<>();

    private SingletonQueueContainerBySequence() {}

    public static SingletonQueueContainerBySequence getInstance() {
        if (instance == null) {
            synchronized(SingletonQueueContainerBySequence.class) {
                if (instance == null) {
                    instance = new SingletonQueueContainerBySequence();
                }
            }
        }
        return instance;
    }

    public synchronized void offer(char ch) {
        queue.offer(ch);
    }

    public synchronized Character poll() {
        return queue.poll();
    }

    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            String a = "hloaiaa";
            for (int i = 0; i < a.length(); i++) {
                SingletonQueueContainerBySequence.getInstance().offer(a.charAt(i));
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
                SingletonQueueContainerBySequence.getInstance().offer(b.charAt(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (SingletonQueueContainer.getInstance().size() > 0) {
                System.out.print(SingletonQueueContainer.getInstance().poll());
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

//        t1.join();
//        t2.join();
//        t3.join();
    }
}
