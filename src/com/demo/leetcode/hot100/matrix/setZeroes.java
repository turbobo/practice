package com.demo.leetcode.hot100.matrix;

/**
 * @Author Jusven
 * @Date 2024/3/31 21:11
 */
public class setZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        // 获取 0 的行、列
        int row = matrix.length;
        int col = matrix[0].length;

        int[] row_arr = new int[row];
        int[] col_arr = new int[col];

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (matrix[i][j] == 0) {
                    row_arr[i] = 1;
                    col_arr[j] = 1;
                }

            }
        }

        for (int r:row_arr) {
            for (int i=0;i<col;i++) {
                matrix[r][i] = 0;
            }
        }
        for (int c:col_arr) {
            for (int i=0;i<row;i++) {
                matrix[i][c] = 0;
            }
        }

    }
}
