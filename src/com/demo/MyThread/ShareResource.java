package com.demo.MyThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Jusven
 * @Date 2021/4/9 16:56
 */
public class ShareResource {
    //��־λ����־�ĸ��߳̿�ʼִ��
    private int number = 1;  //A 1 ,B 2, C 3  3���ֳ�������ӡ
    private Lock lock = new ReentrantLock();
    //lock��3����
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //1.�ж�
            while(number!=1){  //���β���1�߳�ִ��
                c1.await();
            }
            //2.�ɻ�
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.֪ͨ�����߳�
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void print10(){
        lock.lock();
        try {
            //1.�ж�
            while(number!=2){  //���β���1�߳�ִ��
                c2.await();
            }
            //2.�ɻ�
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.֪ͨ�����߳�
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void print15(){
        lock.lock();
        try {
            //1.�ж�
            while(number!=3){  //���β���1�߳�ִ��
                c3.await();
            }
            //2.�ɻ�
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.֪ͨ�����߳�
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
class SyncAndReentrantLock{
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
