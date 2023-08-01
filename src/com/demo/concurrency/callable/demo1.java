package com.demo.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Jusven
 * @Date 2023/7/2 16:50
 */

class DemoThread implements Runnable {
    @Override
    public void run() {
        System.out.println();
    }
}

class CallableDemo implements Callable {

    @Override
    public Integer call() throws Exception {
        return 200;
    }
}
public class demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new DemoThread(), "AA").start();

        // 写法错误
//        new Thread(new CallableDemo(), "BB").start();

        // FutureTask传入Callable接口作为参数
        FutureTask<Integer> futureTask1 = new FutureTask<>(new CallableDemo());


        // lamda表达式
        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            return 1024;
        });


        new Thread(futureTask1, "aa").start();
        new Thread(futureTask2, "bb").start();
//        while(!futureTask1.isDone()) {
//            System.out.println(Thread.currentThread().getName() + " waiting ");
//        }
        System.out.println(futureTask1.get());
        // 第二次调用直接返回了
        System.out.println(futureTask2.get());


    }
}
