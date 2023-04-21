package com.demo.interview.feizhu_20230418;

/**
 * @Author Jusven
 * @Date 2023/4/19 11:21
 * 飞猪面试题  2023 04 18
 * 1. 单例队列容器消费
 * 实现一个单例队列容器，提供三个方法 offer，poll，size写三个线程，
 * 线程1将字符串a每隔1s挨个添加到容器中，线程2将字符串b每隔1s挨个添加到容器中，线程1与线程2交替执行，线程3监听容器变化，调用poll每隔1s挨个输出
 * 示例：
 * 输入：a = "hloaiaa", b = "el,lbb"
 * 输出：hello,alibaba
 */
public class feizhu_20230418 {
        public static void main(String[] args) {
            String a = "hloaiaa";
            String b = "el,lbb";
            new Thread(new Thread1(a)).start();
            new Thread(new Thread2(b)).start();
            new Thread(new Thread3()).start();
        }
}
