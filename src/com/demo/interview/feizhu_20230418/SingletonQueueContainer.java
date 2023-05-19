package com.demo.interview.feizhu_20230418;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1. 单例队列容器消费
 * 实现一个单例队列容器，提供三个方法 offer，poll，size写三个线程，
 * 线程1将字符串a每隔1s挨个添加到容器中，线程2将字符串b每隔1s挨个添加到容器中，线程1与线程2交替执行，线程3监听容器变化，调用poll每隔1s挨个输出
 * 示例：
 * 输入：a = "hloaiaa", b = "el,lbb"
 * 输出：hello,alibaba
 *
 * // 无法控制输出顺序
 */
public class SingletonQueueContainer {
    private static SingletonQueueContainer instance = new SingletonQueueContainer();
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private SingletonQueueContainer() {}

    public static SingletonQueueContainer getInstance() {
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
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                SingletonQueueContainer.getInstance().offer("a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                SingletonQueueContainer.getInstance().offer("b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            while (true) {
                if (SingletonQueueContainer.getInstance().size() > 0) {
                    System.out.println(SingletonQueueContainer.getInstance().poll());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
