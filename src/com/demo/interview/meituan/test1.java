package com.demo.interview.meituan;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/4 16:03
 * С����ѧ�ܺã�С����ѧ����ô�á���һ��С����������ѧ���۸�С�ţ�
 * �����������һ�����⣺���ж��ٸ�����Ϊn�Ľ���a��b��ɵ��ַ����Ȳ�����abaҲ������bab��
 * ������㲻����������Ը������������Ĵ�ģ��998244353�Ƕ��١�С��ʵ���̲�ס�ˣ������������������æ��
 */
public class test1 {
    public static void main(String[] args) {
        //kn=2^n-6n+14
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        if (n < 3) {
            k = 0;
        } else if (n == 3) {
            k = 6;
        } else {
//            int d = 2;
//            for (int i = 4; i <= n; i++) {
//                d = (1 + d) * 2;
//            }

            int d = 1;
            for (int i = 4; i <= n; i++) {
                d = d * 2 + 1;
            }
            k = (int) Math.pow(2, n) - 2 * d;
        }
        System.out.println(k % 998244353);

//        int x =1;
//        for (int i = 4; i <= n; i++) {
//            x=x*2+1;
//        }


//        int k = 0;
//        if (n < 3) {
//            k = 0;
//        } else {
//            k = (int) Math.pow(2, n) - 6 * n + 14;
//        }
//        System.out.println(k % 998244353);
    }

}
