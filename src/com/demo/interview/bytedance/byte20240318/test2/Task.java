package com.demo.interview.bytedance.byte20240318.test2;

import java.util.concurrent.Callable;

class Task implements Callable<Boolean> {
    private final int id;
    
    public Task(int id) {
        this.id = id;
    }
    
    @Override
    public Boolean call() throws Exception {
        try {
            // ģ������ִ��
            System.out.println("Task " + id + " is executing...");
//            int b = 10 / 0;

            Thread.sleep(1000); // ģ������ִ��ʱ��
            System.out.println("Task " + id + " completed.");
            return true;

//            throw new InterruptedException(); // ģ���߳�ִ���ж�

        } catch (InterruptedException e) {
            // �������ִ���жϣ��׳��쳣��ʾ����ʧ��
//            throw new Exception("Task " + id + " failed.", e);
            return false;
        }
    }
}