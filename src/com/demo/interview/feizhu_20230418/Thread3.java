package com.demo.interview.feizhu_20230418;

public class Thread3 implements Runnable {
    public void run() {
        Container container = Container.getInstance();
        while (true) {
            if (container.size() > 0) {
                String element = container.poll();
                System.out.print(element);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
