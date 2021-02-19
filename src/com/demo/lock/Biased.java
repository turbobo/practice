package com.demo.lock;

import java.util.List;
import java.util.Vector;
/*
* 初始化一个Vector，往里面添加10000000个Integer对象，然后输出时间差。以此来测试偏向锁的性能。
* 至于为什么要使用Vector而不使用ArrayList呢？
* 因为ArrayList是线程不安全的，Vector是线程安全的。
*
* 开启偏向锁：
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