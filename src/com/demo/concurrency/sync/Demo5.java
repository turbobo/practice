package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/6/19 21:20
 * ���� ������--�ݹ���
 */
class Counter {
    private int num= 0;
    public synchronized void increase () {
        num++;
        System.out.println("num >> " + num);


        // �ݹ��������: �����롢�ݹ�
        if (num < 5) {
            increase();
        }
    }

}
public class Demo5 {
    public static void main(String[] args) {
        Counter c = new Counter();
        new Thread(() -> {
            c.increase();
        }, "aa").start();
    }
}
