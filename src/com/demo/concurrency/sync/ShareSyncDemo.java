package com.demo.concurrency.sync;

/**
 * @Author Jusven
 * @Date 2023/4/25 22:05
 *
 * sync + wait + notify ʵ���̼߳�ͨ��--�߳̽���ִ��
 */

// 1��������Դ�࣬�������ԺͲ�������

// ��Ҫ�����߳���Դ
class Share {
    // ��ʼֵ
    private int num = 0;

    // +1����
    public synchronized void increase () throws InterruptedException {
        // 1) �����ж�Ϊ0  ����0 ������ִ��+1����,��Ҫ�ȴ�
        if (num != 0) {
//            System.out.println("�߳�1 wait >> ");
            this.wait();  // ����˯�ߣ����﻽�ѣ��ᵼ����ٻ��ѣ�֮ǰ���ж�ֱ�ӱ���������Ҫ��if�жϸ�Ϊwhileѭ���жϣ�������������������
//            System.out.println("�߳�1 ����λ��>> ");

        }
        // 2) ִ�в���
        num++;
        System.out.println(Thread.currentThread().getName() + "�߳� >> " + num);

        // 3)֪ͨb�߳�
        this.notifyAll();
    }

    // -1����
    public synchronized void decrease () throws InterruptedException {
        // 1) �����ж�Ϊ1 ����1 ������ִ�� -1����,��Ҫ�ȴ�
        while (num != 1) {
//            System.out.println("�߳�2 wait >> ");
            this.wait();
//            System.out.println("�߳�1 ����λ��>> ");
        }
        // 2) ִ�в���
        num--;
        System.out.println(Thread.currentThread().getName() + "�߳� >> " + num);

        // 3)֪ͨa�߳�
        this.notifyAll();
    }

}
public class ShareSyncDemo {
    public static void main(String[] args) {
        // ������Դ��
        Share share = new Share();

        // �����߳�
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }

}
