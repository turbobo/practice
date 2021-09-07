package com.demo.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/4 17:56
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxAvg = 0;
        for (int i = 0; i <= n-m; i++) {
            //计算当前平均值
            maxAvg = Math.max(maxAvg,maxAverage(arr,i,m));
        }
//        Math.min
        System.out.println(maxAvg);
    }

    public static int maxAverage(int[] arr, int index, int m){
        int sum = 0;
        for (int i = index; i < index+m; i++) {
            sum += arr[i];
        }
        return sum/m;
    }
}
