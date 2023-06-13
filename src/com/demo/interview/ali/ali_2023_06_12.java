package com.demo.interview.ali;

/**
 * @Author Jusven
 * @Date 2023/6/13 16:27
 *
 *  �����߳̽����ӡ1����100��
 */
class ShareResource {
    private int num = 1;
    int flag = 1;

    // ������������
    public synchronized void func_A() throws InterruptedException {
        // �ж�
        if (flag != 1) {
            this.wait();
        }
        // ִ��
        System.out.println(Thread.currentThread().getName() + " num >> " + num);
        num++;
        // ����
        flag = 2;

        // ֪ͨ
        this.notify();
    }
    public synchronized void func_B() throws InterruptedException {
        // �ж�
        if (flag != 2) {
            this.wait();
        }
        // ִ��
        System.out.println(Thread.currentThread().getName() + " num >> " + num);
        num++;
        // ����
        flag = 1;

        // ֪ͨ
        this.notify();
    }
}
public class ali_2023_06_12 {
    public static void main(String[] args) throws InterruptedException {
        ShareResource share = new ShareResource();
        final int flag = 1;
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try {
                    share.func_A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (flag != 1) {
//                    try {
//                        share.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                share.func_A();
//                // �ڷ����ڲ����ƣ���������������������������������������������������������������������������
//                flag = 2;
//                share.notify();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try {
                    share.func_B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                if (flag != 2) {
//                    share.wait();
//                }
//                share.func_B();
//                flag = 1;
//                share.notify();
            }
        }, "B").start();
    }

}
