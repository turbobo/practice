package com.demo.interview.NetCase;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/18 18:59
 * 100%
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int a = num;
        int b = a;
        int count = 0;
        while (a > 0) {
            b = a % 10;
            if (b != 0) {
                if (num % b == 0) {
                    count++;
                }
            }
            a = a / 10;
        }
        System.out.println(count);
    }
}
