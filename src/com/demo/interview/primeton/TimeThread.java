package com.demo.interview.primeton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Jusven
 * @Date 2021/5/23 16:14
 *
 * test2 ʵ�ֱ���D:\test\srcĿ¼�µ�����ͼƬ(jpg)
 * test3 D:\test\src��test.txt�ļ��г�����ĸ�ĸ���
 * TimeThread�������ʱ���������ǰ��ʱ��,���Сʱ�������ӣ�ʱ���ʽҪ��Ϊ��12:35:28����������
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
