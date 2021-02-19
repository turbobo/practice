package com.demo.lock;

import java.util.List;
import java.util.Vector;
/*
* ��ʼ��һ��Vector�����������10000000��Integer����Ȼ�����ʱ���Դ�������ƫ���������ܡ�
* ����ΪʲôҪʹ��Vector����ʹ��ArrayList�أ�
* ��ΪArrayList���̲߳���ȫ�ģ�Vector���̰߳�ȫ�ġ�
*
* ����ƫ������
* -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -client -Xmx512m -Xms521m
* */
public class Biased {

    public static List<Integer> numberList = new Vector<Integer>();
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while(count<10000000){
            numberList.add(startnum);
            startnum+=2;
            count++;        
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
}