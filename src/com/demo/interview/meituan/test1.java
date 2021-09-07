package com.demo.interview.meituan;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/4 16:03
 * 小美数学很好，小团数学不怎么好。有一天小美又在用数学题欺负小团，
 * 她提出了这样一个问题：“有多少个长度为n的仅由a和b组成的字符串既不包含aba也不包含bab？
 * 如果你算不来大数你可以告诉我这个问题的答案模上998244353是多少”小团实在忍不住了，所以他决定来找你帮忙。
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
