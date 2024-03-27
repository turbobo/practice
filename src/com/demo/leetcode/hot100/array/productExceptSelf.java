package com.demo.leetcode.hot100.array;

/**
 * @Author Jusven
 * @Date 2024/3/25 21:57
 */
public class productExceptSelf {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));

    }
    public static int[] productExceptSelf(int[] nums) {
        // ֻ��Ҫ����һ�Σ���һ����������һ�����Ƶ�����

        int length = nums.length;
        if (length<=1) {
            return new int[1];
        }
        // �������飬�ֱ����ͷ����˻�
        // ��ͷ��ʼ ��ʾiλ��֮ǰ����Ԫ�س˻�
        int[] p1 = new int[length];
        p1[0] = 1;
        for (int i=1;i<length;i++) {
            p1[i] = p1[i-1] * nums[i-1];
        }

        // �Ӻ��濪ʼ ��ʾiλ��֮������Ԫ�س˻�
        int[] p2 = new int[length];
        p2[0] = 1;
        for (int i=1;i<length;i++) {
            p2[i] = p2[i-1] * nums[length-i];
        }

        int[] res = new int[length];
        for (int i=0;i<length;i++) {
            res[i] = p1[i] * p2[length-i-1];
        }
        return res;




    }
}
