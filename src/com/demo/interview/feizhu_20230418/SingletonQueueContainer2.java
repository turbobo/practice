package com.demo.interview.feizhu_20230418;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Jusven
 * @Date 2023/4/27 20:57
 */
public class SingletonQueueContainer2 {
    private static SingletonQueueContainer2 instance = null;

    private Queue<Character> queue = new LinkedList<>();

    private SingletonQueueContainer2() {}

    public static SingletonQueueContainer2 getInstance() {
        if (instance == null) {
            synchronized(SingletonQueueContainer2.class) {
                if (instance == null) {
                    instance = new SingletonQueueContainer2();
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
}
