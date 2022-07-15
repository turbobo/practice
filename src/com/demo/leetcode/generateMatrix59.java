package com.demo.leetcode;

import java.util.Arrays;

/**
 * @author: wangbo82
 * @Date: 2022年07月13日 9:44
 */
public class generateMatrix59 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateMatrix(5)));
    }

    public static int[][] generateMatrix(int n) {
//        if (n == 0) {
//            return new int[][]{1};
//        }
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, up = 0, bottom = n - 1;
        int i = 1;
        while (true) {
            //首先第一行
            for (int j = up; j <= right && i <= n * n; j++) {
                res[up][j] = i;
                i++;
            }
            up++;
            //判断i
            if (i > n * n) {
                break;
            }
            for (int j = up; j <= bottom && i <= n * n; j++) {
                res[j][right] = i;
                i++;
            }
            right--;
            //判断i
            if (i > n * n) {
                break;
            }
            for (int j = right; j >= left && i <= n * n; j--) {
                res[bottom][j] = i;
                i++;
            }
            bottom--;
            //判断i
            if (i > n * n) {
                break;
            }
            for (int j = bottom; j >= up && i <= n * n; j--) {
                res[j][left] = i;
                i++;
            }
            left++;
            //判断i
            if (i > n * n) {
                break;
            }
        }
        return res;
    }
}
