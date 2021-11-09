package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/10/23 20:37
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 n 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。
 * <p>
 * 1 阶 + 1 阶
 * 2 阶
 */
public class climbStairs {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        //1、确定dp[i]意义：到第n楼有几种方法
        //2、递推公式：到达n楼方法：从1楼直接到n楼、从2楼直接到n楼、从3楼直接到n楼、。。。。。。、从n-1楼直接到n楼、直接到n楼
        //dp[i] = dp[1] + dp[2] + .... + dp[n-1] = 2dp[i-1]
        //3、如何初始化：dp[1] = 1, dp[2] = 2
        //4、确定遍历顺序：从前往后
        //5、举例推导dp数组：dp[4] = 8
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i];
        }
        return dp[n];
    }

//    public static int sumHelp(int[] dp, int n) {
//        int sum
//        for (int i = 0; i <= n; i++) {
//
//        }
//    }
}
