package com.demo.interview.feizhu_20230418;

public class Thread2 implements Runnable {
    private String str;

    public Thread2(String str) {
        this.str = str;
    }

    public void run() {
        Container container = Container.getInstance();
        for (int i = 0; i < str.length(); i++) {
            container.offer(String.valueOf(str.charAt(i)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
