package com.demo.interview.didi;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 16:27
 * 小明和小花在玩一个删除数字的游戏。 游戏规则如下：  首先随机写下N个正整数，然后任选一个数字作为起始点，从起始点开始从左往右每次可以删除一个数字，但是必须满足下一个删除的数字要小于上一个删除的数字。每成功删除一个数字计1分。 请问对于给定的N个正整数，一局游戏过后可以得到的最大计分是多少？
 * 最大逆序长度
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //最大逆序长度
        //dp[i][j] 表示arr的i位置到j位置的最大逆序个数
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i >= j) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0 && arr[j] >= arr[j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j > 0 && arr[j] < arr[j - 1]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
            }
        }

        System.out.println(dp[0][n]);
    }

}
