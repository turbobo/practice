package com.demo.interview.huawei20230523;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/6/5 19:10
 *
 * ����
 * һ���� ֻ�ܽ���һ�Σ�����������ֵ
 * leetcode 670. ��󽻻�
 */
public class test5 {
    public static void main(String[] args) {
        System.out.println(getMaxBySwapping_DP(2736));
        System.out.println(getMaxBySwapping_DP(9973));
        System.out.println(getMaxBySwapping_DP(9937));
        System.out.println(getMaxBySwapping_DP(4567));
        System.out.println(getMaxBySwapping_DP(9876));
        System.out.println(getMaxBySwapping_DP(454646));
        System.out.println(getMaxBySwapping_DP(2776));
        System.out.println(getMaxBySwapping_DP(2276));
        System.out.println(getMaxBySwapping_DP(2266));


    }

    // ����һ��
    public static int getMax (int num) {
        // 2736 -->  7236
        // 9973 --> 9973
        // 9937 --> 9973
        String s = String.valueOf(num);

        int max = num;

        // �ҵ�����λ�ã������ҵ��ڶ���λ�ã�dp��
//        int[] dp =
        //������� ����Ӧ�±�
        Map<Integer,Integer> map = new HashMap<>();

        // ˫ָ�룿��������
        // ����ָ�붼�Ǵ�ͷ��β������O(n*n)
        int left = 0;
        while (left < s.length()) {
            int right = left+1;
            while (right < s.length()) {
                // ����left right
                int c = s.charAt(left) - '0';
                int d = s.charAt(right) - '0';
                if (c < d) {
                    //
                    String s1 = s.substring(0, left) + d + s.substring(left+1, right) + c + s.substring(right + 1, s.length());
                    Integer integer = Integer.valueOf(s1);
                    max = max > integer ? max : integer;
                }
                right++;


            }
            left++;
        }


        return max;
    }


    /**
     * gpt -- ����תΪ����ʵ��
     * @param num
     * @return
     */
    public static int getMaxBySwapping(int num) {
        // ������ת��Ϊ�ַ�����
        char[] digits = String.valueOf(num).toCharArray();

        int max = num;

        // �����ַ����飬�ҵ���Ҫ��������������λ��
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // �������ֵ�λ��
                swap(digits, i, j);

                // ����������ַ�����ת��Ϊ����
                int swappedNum = Integer.parseInt(String.valueOf(digits));

                // �������ֵ
                max = Math.max(max, swappedNum);

                // �ָ�����������λ�ã��Ա������һ�ν���
                swap(digits, i, j);
            }
        }

        return max;
    }

    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }


    /**
     * �����̬�滮����ʹ����һ����ά���� dp ���洢�м��������� dp[i][j] ��ʾ��λ�� i ��ʼ��������λ�ã�
     * ����ǰһ������Ϊ j ʱ�ܹ��õ������ֵ��ͨ���ݹ鷽ʽ�������ֵ�������ö�̬�滮���� dp �������ظ����㡣
     *
     * ���������ʱ�临�Ӷ�Ϊ O(n^2)������ n ��ʾ������λ����
     * @param num
     * @return
     */
    public static int getMaxBySwapping_DP(int num) {
        String strNum = String.valueOf(num);
        int n = strNum.length();
        int[][] dp = new int[n][n];

        int maxLeft = 0;
        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, Integer.parseInt(strNum.substring(0, i)));
            dp[i][0] = maxLeft;
        }

        int maxRight = 0;
        for (int j = n - 2; j >= 0; j--) {
            maxRight = Math.max(maxRight, Integer.parseInt(strNum.substring(j + 1)));
            dp[n - 1][j] = maxRight;
        }

        int max = num;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                swap(dp, i, j);
                int swappedNum = Integer.parseInt(strNum.substring(0, i) + strNum.charAt(j) + strNum.substring(i + 1, j) + strNum.charAt(i) + strNum.substring(j + 1));
                max = Math.max(max, Math.max(dp[i][j], swappedNum));
                swap(dp, i, j);
            }
        }

        return max;
    }

    private static void swap(int[][] dp, int i, int j) {
        int temp = dp[i][j];
        dp[i][j] = dp[j][i];
        dp[j][i] = temp;
    }



}
