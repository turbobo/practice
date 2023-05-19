package com.demo.interview.feizhu_20230418;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��δ���ʵ����һ�����������������ṩ������������offer��poll��size�����У�offer������������������Ԫ�أ�
 * poll�������ڴӶ�����ȡ��Ԫ�ز��Ƴ���size�������ڻ�ȡ������Ԫ�صĸ�����
 * �ó���ͬʱ�����������̣߳�
 * ǰ�����̸߳����ַ�����a��b�е��ַ���һ��ӵ������У�ÿ�����һ���ַ���ȴ�1���ӣ�
 * Ȼ���ٽ�����Ȩ������һ���̡߳��������̲߳��ϼ������еı仯��
 * ÿ����������Ԫ��ʱ���ʹӶ�����ȡ��һ��Ԫ�ز������Ȼ��ȴ�1���ӣ�ֱ�����������µ�Ԫ�ء�
 * ��󣬸ó��������Ϊa="hloaiaa"��b="el,lbb"�����Ϊ"hello,alibaba"��
 */

public class AlternateExecution {
    private Queue<Character> queue = new LinkedList<>();
    private static AlternateExecution instance = new AlternateExecution();
    private boolean flag = false; // �߳�3 ���еı�־----����Ҫ�α�־��Ҳ�ܱ�֤�߳�3ÿ�����߳�1 2�����ִ��
    private volatile int flag_int = 1;  // �����߳�1���߳�2����ִ�еı�־

    private AlternateExecution() {
    }

    public static AlternateExecution getInstance() {
        return instance;
    }

    public synchronized void offerA(char[] arr) {
        for (char c : arr) {

            try {
                Thread.sleep(1000);
                // ����߳�3 ��Ҫ���У����߳�1Ҳ��Ҫ�ȴ�
//                while (flag_int != 1 || flag) {
                    while (flag_int != 1 ) {
                    wait();
                }
                queue.offer(c);
                System.out.println("�߳�1 ����");
                // �߳�1 ִ����һ�Σ����߳�3��Ҫ�����ӡ
                flag = true;
                flag_int = 2;
                // ������notify();���ѵ����̣߳���Ϊ�����߳�3 ����Ϊ�գ��߳�3Ҳ��ȴ�����ʱ�߳�1��3���ڵȴ����Ҷ�������������ֻ�������߳�2
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
                // ����߳�3 ��Ҫ���У����߳�2Ҳ��Ҫ�ȴ�
//                while (flag_int != 2 || flag) {
                while (flag_int != 2) {
                    wait();
                }
                queue.offer(c);
                System.out.println("�߳�2 ����");
                flag = true;
                flag_int = 1;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ϊʲô�߳�1ִ�����֮�������߳�3ִ�У��������߳�2  ��������������������������������
     */
    public synchronized void poll() {
        while (true) {
            // �߳�1 2�ǽ������� �������ַ�������ģ����Բ����߳�3ִ��˳����Σ����˳��������ȷ��
            if (!queue.isEmpty()) {
                System.out.println("�߳�3 >> " + queue.poll());
                // �߳�3 ִ�й�һ�Σ����Խ����߳�1��2����ִ��
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
