package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022Äê07ÔÂ15ÈÕ 9:45
 */
public class spiralOrder2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{11,12,13}};
        spiralOrder(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        int len = 0;
        int amount = matrix[0].length * matrix.length;
//        int[] res = new int[amount];
        while (true) {
            for (int i = left; i <= right && len < amount; i++) {
                res.add(matrix[up][i]);
//                res[len++] = matrix[up][i];
                len++;
            }
            up++;
            if (len >= amount) {
                break;
            }
            for (int i = up; i <= bottom && len < amount; i++) {
                res.add(matrix[i][right]);
//                res[len++] = matrix[i][right];
                len++;
            }
            right--;
            if (len >= amount) {
                break;
            }
            for (int i = right; i >= left && len < amount; i--) {
                res.add(matrix[bottom][i]);
//                res[len++] = matrix[bottom][i];
                len++;
            }
            bottom--;
            if (len >= amount){
                break;
            }
            for (int i = bottom; i >= up && len < amount; i--) {
                res.add(matrix[i][left]);
//                res[len++] = matrix[i][left];
                len++;
            }
            left++;
            if (len >= amount){
                break;
            }
        }
        return res;
    }
}
