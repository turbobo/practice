package com.demo.interview.huawei20230523;

/**
 * @Author Jusven
 * @Date 2023/6/4 20:39
 * <p>
 * /** * ����һ�����������һ������n,�ҵ���������̵�һ������������ * ʹ����������������ֺ� sum >= n��
 * ���������̵�����������ĳ���ֵ * *
 * ���磺����[2,3,1,2,4,3,7],n = 10 * ��̵�����������Ϊ[3,7] ������ֵӦ�÷���2
  leetcode 209. ������С��������
      */

public class test4 {
    public static void main(String[] args) {
        int[] words = {2, 3, 1, 2, -1, 4, 3, -1,7};
        System.out.println(getLength(words, 10));
        System.out.println(minSubArrayLen( 10, words));
    }

    // ��������
    public static int getLength(int[] words, int n) {
        if (words == null || words.length ==0) {
            return 0;
        }
        // ˫ָ�룿
        int left = 0;
        // ��ǰ��С����
        int len = words.length + 1;
        while (left <  words.length ) {
            int right = left + 1;
            int temp = words[left];
            while (right < words.length) {
                temp += words[right];

                if (temp >= n) {
                    len = len < (right - left+1) ? len : (right - left+1);
                    break;
                }
                right++;
            }
            left++;

        }
        return len;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
