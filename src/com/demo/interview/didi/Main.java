package com.demo.interview.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] result = new int[n];
        int res = 0;
        //最大逆序长度
        //dp[i][j] 表示arr的i位置到j位置的最大逆序个数
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < temp) {
                    result[i] += 1;
                    temp = arr[j];
                    //continue;
                }
            }
            res = Math.max(res,result[i]);
        }
        System.out.println(res);
//        Arrays.sort(result);
//        if (result[result.length - 1] == 0) {
//            System.out.println(0);
//        } else {
//            System.out.println(result[result.length - 1] + 1);
//        }
    }
}