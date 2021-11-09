package com.demo.leetcode;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 20:21
 * 쳲�������
 * F(0) = 0��F(1) = 1 F(n) = F(n - 1) + F(n - 2)������ n > 1
 */
public class fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("fib(" + n + ") = " + fib(n));
    }

    public static int fib(int n) {
        //1��dp���飨dp table���Լ��±�ĺ��壺dp[i]�Ķ���Ϊ����i������쳲�������ֵ��dp[i]
        //2��ȷ�����ƹ�ʽ��dp[i]=dp[i-1]+dp[i-2], n>1
        //3��dp������γ�ʼ����dp[0]=, dp[1]=1
        //4��ȷ������˳�򣺴ӵݹ鹫ʽdp[i] = dp[i - 1] + dp[i - 2];�п��Կ�����dp[i]������ dp[i - 1] �� dp[i - 2]����ô������˳��һ���Ǵ�ǰ���������
        //5�������Ƶ�dp���飺��NΪ10��ʱ��dp����Ӧ�������µ����У�0 1 1 2 3 5 8 13 21 34 55
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
