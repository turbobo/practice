package com.demo.leetcode;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/11/22 17:04
 * 螺旋矩阵 II
 */
public class generateMatrix {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.toString(res));
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = top;
        int right = bottom;
        //循环条件可以使用数组长度判断
        int i = 1;
        while(i<=n){
            //上边
            for(int j=left;j<=right;j++){
                matrix[top][j] = i++;
            }
            top++;
            //右边
            for(int j=top;j<=bottom;j++){
                matrix[j][right] = i++;
            }
            right--;
            //下边
            for(int j=right;j>=left;j--){
                matrix[bottom][j] = i++;
            }
            bottom--;
            //左边
            for(int j=bottom;j>=top;j--){
                matrix[j][left] = i++;
            }
            left++;
        }

        //    if(n%2!=0){
        //        matrix[n/2][n/2] = i;
        //    }
        return matrix;
    }
}
