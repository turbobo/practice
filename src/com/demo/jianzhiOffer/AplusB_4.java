package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 16:39
 * 输入数据包括多组。
 * 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
 * 接下来n个正整数,即需要求和的每个正整数。
 */
public class AplusB_4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            int sum = 0;
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                sum += a;
            }
            System.out.println(sum);
        }

    }
}
