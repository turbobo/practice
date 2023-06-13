package com.demo.interview.ali;

/**
 * @Author Jusven
 * @Date 2023/6/13 16:27
 *
 *  两个线程交替打印1，到100？
 */
class ShareResource {
    private int num = 1;
    int flag = 1;

    // 定义两个方法
    public synchronized void func_A() throws InterruptedException {
        // 判断
        if (flag != 1) {
            this.wait();
        }
        // 执行
        System.out.println(Thread.currentThread().getName() + " num >> " + num);
        num++;
        // 控制
        flag = 2;

        // 通知
        this.notify();
    }
    public synchronized void func_B() throws InterruptedException {
        // 判断
        if (flag != 2) {
            this.wait();
        }
        // 执行
        System.out.println(Thread.currentThread().getName() + " num >> " + num);
        num++;
        // 控制
        flag = 1;

        // 通知
        this.notify();
    }
}
public class ali_2023_06_12 {
    public static void main(String[] args) throws InterruptedException {
        ShareResource share = new ShareResource();
        final int flag = 1;
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try {
                    share.func_A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (flag != 1) {
//                    try {
//                        share.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                share.func_A();
//                // 在方法内部控制！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//                flag = 2;
//                share.notify();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try {
                    share.func_B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                if (flag != 2) {
//                    share.wait();
//                }
//                share.func_B();
//                flag = 1;
//                share.notify();
            }
        }, "B").start();
    }

}
