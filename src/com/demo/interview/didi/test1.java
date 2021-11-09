package com.demo.interview.didi;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 16:27
 * С����С������һ��ɾ�����ֵ���Ϸ�� ��Ϸ�������£�  �������д��N����������Ȼ����ѡһ��������Ϊ��ʼ�㣬����ʼ�㿪ʼ��������ÿ�ο���ɾ��һ�����֣����Ǳ���������һ��ɾ��������ҪС����һ��ɾ�������֡�ÿ�ɹ�ɾ��һ�����ּ�1�֡� ���ʶ��ڸ�����N����������һ����Ϸ������Եõ������Ʒ��Ƕ��٣�
 * ������򳤶�
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //������򳤶�
        //dp[i][j] ��ʾarr��iλ�õ�jλ�õ�����������
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i >= j) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0 && arr[j] >= arr[j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j > 0 && arr[j] < arr[j - 1]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
            }
        }

        System.out.println(dp[0][n]);
    }

}
