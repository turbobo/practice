package com.demo.MyThread;

import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2021/6/2 22:09
 */
public class threadTest {
    public static void main(String[] args) {
/*        Run_Start thread1 = new Run_Start();
        Thread thread2 = new Thread(thread1);  //ʵ��Runnable�ӿ�
        thread2.start();*/

        Run_Start2 run_start2 = new Run_Start2();  //�̳�Thread
        run_start2.start();

        for (int i =0; i<10; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(10);   //Ϊ����Ч���������߳�˯һ˯��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("��������--���߳�");
        }
    }
}
