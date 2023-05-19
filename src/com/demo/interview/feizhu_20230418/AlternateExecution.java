package com.demo.interview.feizhu_20230418;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这段代码实现了一个单例队列容器，提供了三个方法：offer、poll、size，其中，offer方法用于向队列中添加元素，
 * poll方法用于从队列中取出元素并移除，size方法用于获取队列中元素的个数。
 * 该程序同时运行了三个线程，
 * 前两个线程负责将字符数组a和b中的字符逐一添加到队列中，每次添加一个字符后等待1秒钟，
 * 然后再将控制权交给另一个线程。第三个线程不断监听队列的变化，
 * 每当队列中有元素时，就从队列中取出一个元素并输出，然后等待1秒钟，直到队列中有新的元素。
 * 最后，该程序的输入为a="hloaiaa"，b="el,lbb"，输出为"hello,alibaba"。
 */

public class AlternateExecution {
    private Queue<Character> queue = new LinkedList<>();
    private static AlternateExecution instance = new AlternateExecution();
    private boolean flag = false; // 线程3 运行的标志----不需要次标志，也能保证线程3每次在线程1 2插入后执行
    private volatile int flag_int = 1;  // 控制线程1和线程2交替执行的标志

    private AlternateExecution() {
    }

    public static AlternateExecution getInstance() {
        return instance;
    }

    public synchronized void offerA(char[] arr) {
        for (char c : arr) {

            try {
                Thread.sleep(1000);
                // 如果线程3 需要运行，则线程1也需要等待
//                while (flag_int != 1 || flag) {
                    while (flag_int != 1 ) {
                    wait();
                }
                queue.offer(c);
                System.out.println("线程1 插入");
                // 线程1 执行了一次，则线程3需要输出打印
                flag = true;
                flag_int = 2;
                // 可以用notify();唤醒单个线程，因为唤醒线程3 队列为空，线程3也会等待，此时线程1、3都在等待，且都不符合条件，只能运行线程2
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void offerB(char[] arr) {
        for (char c : arr) {

            try {
                Thread.sleep(1000);
                // 如果线程3 需要运行，则线程2也需要等待
//                while (flag_int != 2 || flag) {
                while (flag_int != 2) {
                    wait();
                }
                queue.offer(c);
                System.out.println("线程2 插入");
                flag = true;
                flag_int = 1;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 为什么线程1执行完成之后，先是线程3执行，而不是线程2  ？？？？？？？？？？？？？？？？
     */
    public synchronized void poll() {
        while (true) {
            // 线程1 2是交替运行 容器的字符是有序的，所以不管线程3执行顺序如何，输出顺序总是正确的
            if (!queue.isEmpty()) {
                System.out.println("线程3 >> " + queue.poll());
                // 线程3 执行过一次，可以交由线程1、2继续执行
//                flag = false;
                notifyAll();
                try {
                    Thread.sleep(1000);
                    while (queue.isEmpty()) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        AlternateExecution instance = AlternateExecution.getInstance();
        char[] a = "hloaiaa".toCharArray();
        char[] b = "el,lbb".toCharArray();
        new Thread(() -> instance.offerA(a)).start();
        new Thread(() -> instance.offerB(b)).start();

//        new Thread(()->
//        {
//            System.out.println();
//        }, "AA").start();
//        new Thread(()->
//        {
//            System.out.println();
//        }, "BB").start();

        new Thread(instance::poll).start();
    }
}
