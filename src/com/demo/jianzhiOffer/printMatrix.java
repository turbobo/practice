package com.demo.jianzhiOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 */
public class printMatrix {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] matrix = { {10, 20, 30}, {15, 25, 35}, {22, 44, 66}, {33, 55, 77} };
        printMatrix_solution(matrix);
    }

    public static ArrayList<Integer> printMatrix_solution(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
//         int[][] matrix = new int[5][5];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] temp = new int[rows][cols];
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;
        while(true){
            //最上方第一行
            for(int i=left;i<=right;i++){
                list.add(matrix[up][i]);
            }
            up++;
            if(up>down){
                break;
            }
            //最右一列
            for(int i=up;i<=down;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(right<left){
                break;
            }
            //最下方一行
            for(int i=right;i>=left;i--){
                list.add(matrix[down][i]);
            }
            down--;
            if(down<up){
                break;
            }
            //最左边一列
            for(int i=down;i>=up;i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }
}
