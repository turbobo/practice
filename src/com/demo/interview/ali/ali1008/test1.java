package com.demo.interview.ali.ali1008;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/8 20:02
 * 补码相加
 *
 * 2
 * 00000000000000000000000000000101 11111111111111111111111111111111
 * 00000000000000000000000000011111 00000000000000000000000000000111
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        String[] input = new String[t];
        for (int i = 0; i < t; i++) {
            input[i] = in.nextLine();
        }

        String[] temp = new String[2];
        for (int i = 0; i < t; i++) {
            temp = input[i].split(" ");


        }
        //还原为原码
        //判断正负
        byte b1= (byte) 11111011;
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(-5));

        //相加

//        long l = 1000;
//        Byte b1 = 0000010;
//        System.out.println("b1 = " + b1);
//        System.out.println(l);
//        System.out.println(7>>2);
    }

//    public static int help(String[] temp){
//        String s0 = temp[0];
//        String s1 = temp[1];
//        //还原为原码
//        if(s0.charAt(0) == 1){
//
//        }
//        if(s1.charAt(0) == 1){
//
//        }
//    }
}
