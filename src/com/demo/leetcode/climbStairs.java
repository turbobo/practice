package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/10/23 20:37
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * <p>
 * ÿ��������� 1 �� n ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * <p>
 * ע�⣺���� n ��һ����������
 * <p>
 * ʾ�� 1�� ���룺 2 ����� 2 ���ͣ� �����ַ�����������¥����
 * <p>
 * 1 �� + 1 ��
 * 2 ��
 */
public class climbStairs {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        //1��ȷ��dp[i]���壺����n¥�м��ַ���
        //2�����ƹ�ʽ������n¥��������1¥ֱ�ӵ�n¥����2¥ֱ�ӵ�n¥����3¥ֱ�ӵ�n¥������������������n-1¥ֱ�ӵ�n¥��ֱ�ӵ�n¥
        //dp[i] = dp[1] + dp[2] + .... + dp[n-1] = 2dp[i-1]
        //3����γ�ʼ����dp[1] = 1, dp[2] = 2
        //4��ȷ������˳�򣺴�ǰ����
        //5�������Ƶ�dp���飺dp[4] = 8
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i];
        }
        return dp[n];
    }

//    public static int sumHelp(int[] dp, int n) {
//        int sum
//        for (int i = 0; i <= n; i++) {
//
//        }
//    }
}
