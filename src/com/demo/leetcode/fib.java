package com.demo.leetcode;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 20:21
 * 斐波那契数
 * F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("fib(" + n + ") = " + fib(n));
    }

    public static int fib(int n) {
        //1、dp数组（dp table）以及下标的含义：dp[i]的定义为：第i个数的斐波那契数值是dp[i]
        //2、确定递推公式：dp[i]=dp[i-1]+dp[i-2], n>1
        //3、dp数组如何初始化：dp[0]=, dp[1]=1
        //4、确定遍历顺序：从递归公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
        //5、举例推导dp数组：当N为10的时候，dp数组应该是如下的数列：0 1 1 2 3 5 8 13 21 34 55
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
