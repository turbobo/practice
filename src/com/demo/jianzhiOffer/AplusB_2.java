package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 16:19
 * �����һ�а���һ����������t(1 <= t <= 100)
 * ������ÿ�а�������������a,b(1 <= a, b <= 10^9)
 */
public class AplusB_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            while(sc.hasNext()){
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a + b);
            }
        }

    }

}
