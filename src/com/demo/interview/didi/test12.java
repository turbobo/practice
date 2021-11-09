package com.demo.interview.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 17:07
 *
 * X星大学新校区终于建成啦！  新校区一共有N栋教学楼和办公楼。现在需要用光纤把这N栋连接起来，保证任意两栋楼之间都有一条有线网络通讯链路。
 * 已知任意两栋楼之间的直线距离（单位：千米）。为了降低成本，要求两栋楼之间都用直线光纤连接。
 * 光纤的单位成本C已知（单位：X星币/千米），请问最少需要多少X星币才能保证任意两栋楼之间都有光纤直接或者间接相连？
 * 注意：如果1号楼和2号楼相连，2号楼和3号楼相连，则1号楼和3号楼间接相连
 *
 * 3 10
 * 1 2 5
 * 1 3 6
 * 2 3 7
 */
public class test12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        in.nextLine();
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        int[] result = new int[n];
//        //最大逆序长度
//        //dp[i][j] 表示arr的i位置到j位置的最大逆序个数
////        for (int i = 0; i < n; i++) {
////            int temp = arr[i];
////            for (int j = i + 1; j < n; j++) {
////                if (arr[j] < temp) {
////                    result[i] += 1;
////                    temp = arr[j];
////                }
////            }
////        }
        int n = in.nextInt();
        int c = in.nextInt();
        int row = n*(n-1)/2;
        int[][] arr = new int[row][3];
        in.nextLine();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
        }
//        Arrays.sort(result);
//        System.out.println(result[result.length - 1] + 1);
    }
}
