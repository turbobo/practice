package com.demo.lock;

public class Deadlock {
    public static String str1 = "str1";
    public static String str2 = "str2";

    public static void main(String[] args){
        Thread a = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str1){  //�߳�0��סstr1
                        System.out.println(Thread.currentThread().getName()+"��ס str1");
                        Thread.sleep(1000);  //�߳�0����  �����߳�1
                        // �ȴ��߳�1ִ�����ټ���
                        // �߳�0��������֮����Ҫȥ��str2���ܼ�������,����str2�Ѿ����߳�1����ס�ˣ����ֻ�ܵȴ�
                        synchronized(Deadlock.str2){
                            System.out.println(Thread.currentThread().getName()+"��ס str2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str2){  //�߳�1��סstr2
                        System.out.println(Thread.currentThread().getName()+"��ס str2");
                        Thread.sleep(1000);  //�߳�1����
                        //  �ȴ��߳�0ִ�����ټ���
                        // �߳�1��������֮����Ҫȥ��str1���ܼ�������,����str1�Ѿ����߳�0����ס�ˣ����ֻ�ܵȴ����޷���������
                        synchronized(Deadlock.str1){
                            System.out.println(Thread.currentThread().getName()+"��ס str1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }
}