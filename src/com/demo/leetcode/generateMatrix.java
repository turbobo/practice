package com.demo.leetcode;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/11/22 17:04
 * �������� II
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
        //ѭ����������ʹ�����鳤���ж�
        int i = 1;
        while(i<=n){
            //�ϱ�
            for(int j=left;j<=right;j++){
                matrix[top][j] = i++;
            }
            top++;
            //�ұ�
            for(int j=top;j<=bottom;j++){
                matrix[j][right] = i++;
            }
            right--;
            //�±�
            for(int j=right;j>=left;j--){
                matrix[bottom][j] = i++;
            }
            bottom--;
            //���
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
