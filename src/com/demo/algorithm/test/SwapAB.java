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
        System.out.println("ԭ����a="+ a +" b="+b);
        //�Ӽ���
/*        a = a + b;
        b = a - b;
        a = a - b;*/


       //�������ţ����Ա���a+b��ֵ���
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println("���ڵ�a="+ a +" b="+b);
    }
}
