package com.demo.interview.bytedance.byte20240318;

import lombok.val;

import java.util.concurrent.*;

/**
 * @Author Jusven
 * @Date 2024/3/18 14:55
 * 使用线程实现：同时执行10个任务，每个任务执行完就执行confirm方法，有一个任务执行失败就执行cancel方法
 */
public class test1 {
    private static volatile int val = 0;

    public static void main(String[] args) {
        // 线程池创建
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
        System.out.println("线程执行失败");

    }

    public static void confirm () {
        System.out.println("所有线程执行成功");

    }
}
