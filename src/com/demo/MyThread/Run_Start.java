package com.demo.MyThread;

import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2021/6/2 22:03
 * Thread��run������start����������
 * ֱ�ӵ���run�������������̣߳�runֻ����Ϊ�߳����һ����ͨ����,�������߳�ȥִ��run����
 * ����start������thread1�߳̿�����������߳���ռ��Դ�ˡ�Ҳ�����������߳������ˡ�
 *
 */
//public class Run_Start extends Thread{
public class Run_Start implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("��������--ʵ��Runnable�ӿ�");
        }
    }
//    @Override
//    public void run() {
//        for (int i=0; i<10; i++){
//            System.out.println("��������");
//        }
//    }
}
