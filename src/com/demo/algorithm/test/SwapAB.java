package com.demo.algorithm.test;

/**
 * @Author Jusven
 * @Date 2021/4/23 21:00
 */
public class SwapAB {
    public static void main(String[] args) {
        SwapAB swapAB = new SwapAB();
        System.out.println(swapAB.getClass().getClassLoader());
        System.out.println(swapAB.getClass().getClassLoader().getParent());
        String s = "dfds";
        System.out.println(s.getClass().getClassLoader());

        int a = 1;
        int b = 2;
        System.out.println("原来的a="+ a +" b="+b);
        //加减法
/*        a = a + b;
        b = a - b;
        a = a - b;*/


       //用异或符号，可以避免a+b的值溢出
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println("现在的a="+ a +" b="+b);
    }
}
