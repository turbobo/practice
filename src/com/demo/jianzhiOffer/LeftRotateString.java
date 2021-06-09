package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/5/11 19:24
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public static void main(String[] args) {
        LeftRotateString_("abcXYZdef",3);
    }

    public static String LeftRotateString_(String str,int n) {
        int length = str.length();
        int k = n%length;
        String right = str.substring(0,k);
        String left = str.substring(k,str.length());
        return left+right;
    }
}
