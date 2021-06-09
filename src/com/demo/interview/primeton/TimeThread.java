package com.demo.interview.primeton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Jusven
 * @Date 2021/5/23 16:14
 *
 * test2 实现遍历D:\test\src目录下的所有图片(jpg)
 * test3 D:\test\src下test.txt文件中出现字母的个数
 * TimeThread，负责计时，并打出当前的时间,输出小时分钟秒钟，时间格式要求为：12:35:28。并做测试
 */
public class TimeThread extends Thread {
    public static void main(String[] args) {
        TimeThread t = new TimeThread();
        t.start();
    }

    @Override
    public void run() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String str = sdf.format(d);
        System.out.println(str);
    }
}
