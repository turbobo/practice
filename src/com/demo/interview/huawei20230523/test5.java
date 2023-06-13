package com.demo.interview.huawei20230523;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/6/5 19:10
 *
 * 二面
 * 一个数 只能交换一次，怎样获得最大值
 * leetcode 670. 最大交换
 */
public class test5 {
    public static void main(String[] args) {
        System.out.println(getMaxBySwapping_DP(2736));
        System.out.println(getMaxBySwapping_DP(9973));
        System.out.println(getMaxBySwapping_DP(9937));
        System.out.println(getMaxBySwapping_DP(4567));
        System.out.println(getMaxBySwapping_DP(9876));
        System.out.println(getMaxBySwapping_DP(454646));
        System.out.println(getMaxBySwapping_DP(2776));
        System.out.println(getMaxBySwapping_DP(2276));
        System.out.println(getMaxBySwapping_DP(2266));


    }

    // 交换一次
    public static int getMax (int num) {
        // 2736 -->  7236
        // 9973 --> 9973
        // 9937 --> 9973
        String s = String.valueOf(num);

        int max = num;

        // 找到最大的位置，依次找到第二大位置，dp？
//        int[] dp =
        //存放数字 及对应下标
        Map<Integer,Integer> map = new HashMap<>();

        // 双指针？滑动窗口
        // 两个指针都是从头到尾，所以O(n*n)
        int left = 0;
        while (left < s.length()) {
            int right = left+1;
            while (right < s.length()) {
                // 交换left right
                int c = s.charAt(left) - '0';
                int d = s.charAt(right) - '0';
                if (c < d) {
                    //
                    String s1 = s.substring(0, left) + d + s.substring(left+1, right) + c + s.substring(right + 1, s.length());
                    Integer integer = Integer.valueOf(s1);
                    max = max > integer ? max : integer;
                }
                right++;


            }
            left++;
        }


        return max;
    }


    /**
     * gpt -- 数字转为数组实现
     * @param num
     * @return
     */
    public static int getMaxBySwapping(int num) {
        // 将整数转换为字符数组
        char[] digits = String.valueOf(num).toCharArray();

        int max = num;

        // 遍历字符数组，找到需要交换的两个数字位置
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // 交换数字的位置
                swap(digits, i, j);

                // 将交换后的字符数组转换为整数
                int swappedNum = Integer.parseInt(String.valueOf(digits));

                // 更新最大值
                max = Math.max(max, swappedNum);

                // 恢复交换的数字位置，以便进行下一次交换
                swap(digits, i, j);
            }
        }

        return max;
    }

    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }


    /**
     * 这个动态规划方法使用了一个二维数组 dp 来存储中间结果，其中 dp[i][j] 表示从位置 i 开始交换数字位置，
     * 并且前一个数字为 j 时能够得到的最大值。通过递归方式计算最大值，并利用动态规划数组 dp 来避免重复计算。
     *
     * 这个方法的时间复杂度为 O(n^2)，其中 n 表示整数的位数。
     * @param num
     * @return
     */
    public static int getMaxBySwapping_DP(int num) {
        String strNum = String.valueOf(num);
        int n = strNum.length();
        int[][] dp = new int[n][n];

        int maxLeft = 0;
        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, Integer.parseInt(strNum.substring(0, i)));
            dp[i][0] = maxLeft;
        }

        int maxRight = 0;
        for (int j = n - 2; j >= 0; j--) {
            maxRight = Math.max(maxRight, Integer.parseInt(strNum.substring(j + 1)));
            dp[n - 1][j] = maxRight;
        }

        int max = num;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                swap(dp, i, j);
                int swappedNum = Integer.parseInt(strNum.substring(0, i) + strNum.charAt(j) + strNum.substring(i + 1, j) + strNum.charAt(i) + strNum.substring(j + 1));
                max = Math.max(max, Math.max(dp[i][j], swappedNum));
                swap(dp, i, j);
            }
        }

        return max;
    }

    private static void swap(int[][] dp, int i, int j) {
        int temp = dp[i][j];
        dp[i][j] = dp[j][i];
        dp[j][i] = temp;
    }



}
