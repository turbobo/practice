package com.demo.leetcode.hashset;

/**
 * @Author Jusven
 * @Date 2023/5/19 16:26
 */
public class isValidSudoku36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // 数组位置减去1
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    // 九宫格除以3后，缩小范围，3行3列中的数字统计个数，使用除以3后的行列来定位 3x3 的九宫格
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
