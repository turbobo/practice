package com.demo.interview.bytedance.byte20240318;

import lombok.val;

import java.util.concurrent.*;

/**
 * @Author Jusven
 * @Date 2024/3/18 14:55
 * ʹ���߳�ʵ�֣�ͬʱִ��10������ÿ������ִ�����ִ��confirm��������һ������ִ��ʧ�ܾ�ִ��cancel����
 */
public class test1 {
    private static volatile int val = 0;

    public static void main(String[] args) {
        // �̳߳ش���
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        try {
            for (int i = 0; i < 10 ; i++) {
                TaskCallable t = new TaskCallable();
                Future<Integer> submit = executor.submit(t);
                    if (submit.get() == 0) {
                        cancel();
                    } else {
                        val = val + 1;
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        if (val == 10) {
            confirm();
        }
    }

    public static void cancel () {
        System.out.println("�߳�ִ��ʧ��");

    }

    public static void confirm () {
        System.out.println("�����߳�ִ�гɹ�");

    }
}
