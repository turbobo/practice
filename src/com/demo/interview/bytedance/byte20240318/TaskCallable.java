package com.demo.interview.bytedance.byte20240318;

import java.util.concurrent.Callable;

/**
 * @Author Jusven
 * @Date 2024/3/20 9:47
 */
// ������
public class TaskCallable implements Callable<Integer> {
    // static ���εı����Ǿ�̬������Ҳ��Ϊ�������������������������ʵ�������ֻ��һ�ݸ����ᱻ����ʵ������
    // ��̬�����������ʱ����ʼ������������ʵ������ʱ��ʼ����
    private static Integer flag = 0;
    @Override
    public Integer call() throws Exception {
        // ִ������
        try {
            System.out.println("ִ������---");
            Thread.sleep(1000);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
