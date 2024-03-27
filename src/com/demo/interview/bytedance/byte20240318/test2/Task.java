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
            // 模拟任务执行
            System.out.println("Task " + id + " is executing...");
//            int b = 10 / 0;

            Thread.sleep(1000); // 模拟任务执行时间
            System.out.println("Task " + id + " completed.");
            return true;

//            throw new InterruptedException(); // 模拟线程执行中断

        } catch (InterruptedException e) {
            // 如果任务执行中断，抛出异常表示任务失败
//            throw new Exception("Task " + id + " failed.", e);
            return false;
        }
    }
}