package com.demo.concurrency;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Jusven
 * @Date 2023/5/30 19:54
 */
public class TestCallable implements Callable<String>{
    // 重写 泛型 的方法，一个方法名只能存在一个
    @Override
    public String call() throws Exception {
        return "Hello,i am running!";
    }

    // 泛型方法在编译时会进行类型擦除，将泛型参数替换为其边界或实际类型。由于类型擦除的存在，编译器无法区分这两个方法。
//        public Integer call() throws Exception {
//            return null;
//        }


    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> task=new FutureTask<String>(new TestCallable());
        //启动线程
        new Thread(task).start();
        try {
            //等待执行完成，并获取返回结果
            String result=task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
