package com.demo.interview.bytedance.byte20240318;

import java.util.concurrent.Callable;

/**
 * @Author Jusven
 * @Date 2024/3/20 9:47
 */
// 任务类
public class TaskCallable implements Callable<Integer> {
    // static 修饰的变量是静态变量，也称为类变量。它们属于类而不是类的实例，因此只有一份副本会被所有实例共享。
    // 静态变量在类加载时被初始化，而不是在实例创建时初始化。
    private static Integer flag = 0;
    @Override
    public Integer call() throws Exception {
        // 执行任务
        try {
            System.out.println("执行任务---");
            Thread.sleep(1000);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
