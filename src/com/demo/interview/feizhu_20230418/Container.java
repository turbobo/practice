package com.demo.interview.feizhu_20230418;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Container {
    private static Container instance = new Container();
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private Container() {}

    public static Container getInstance() {
        return instance;
    }

    public void offer(String element) {
        queue.offer(element);
    }

    public String poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
