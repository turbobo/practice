package com.demo.interview.bytedance.byte20240318.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskExecutor {
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<Boolean>> tasks = new ArrayList<>();
        
        // 添加10个任务到任务列表
        for (int i = 0; i < 10; i++) {
            tasks.add(new Task(i));
        }
        
        try {
            // 执行所有任务并获取结果
            List<Future<Boolean>> results = executor.invokeAll(tasks);
            
            boolean hasFailed = false;
            for (Future<Boolean> result : results) {
                if (!result.get()) {
                    hasFailed = true;
                    break;
                }
            }
            
            // 检查是否有任务执行失败
            if (hasFailed) {
                cancel();
            } else {
                confirm();
            }
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
    
    public static void confirm() {
        System.out.println("All tasks completed successfully. Confirming...");
    }
    
    public static void cancel() {
        System.out.println("At least one task failed. Cancelling...");
    }
}