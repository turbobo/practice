package com.demo.concurrency;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Jusven
 * @Date 2023/5/30 19:54
 */
public class TestCallable implements Callable<String>{
    // ��д ���� �ķ�����һ��������ֻ�ܴ���һ��
    @Override
    public String call() throws Exception {
        return "Hello,i am running!";
    }

    // ���ͷ����ڱ���ʱ��������Ͳ����������Ͳ����滻Ϊ��߽��ʵ�����͡��������Ͳ����Ĵ��ڣ��������޷�����������������
//        public Integer call() throws Exception {
//            return null;
//        }


    public static void main(String[] args) {
        //�����첽����
        FutureTask<String> task=new FutureTask<String>(new TestCallable());
        //�����߳�
        new Thread(task).start();
        try {
            //�ȴ�ִ����ɣ�����ȡ���ؽ��
            String result=task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
