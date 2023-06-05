package com.demo.interview.huawei20230523;

/**
 * @Author Jusven
 * @Date 2023/6/4 20:39
 * <p>
 * /** * 给定一个整型数组和一个数字n,找到数组中最短的一个连续子数组 * 使得连续子数组的数字和 sum >= n，
 * 返回这个最短的连续子数组的长度值 * *
 * 例如：数组[2,3,1,2,4,3,7],n = 10 * 最短的连续子数组为[3,7] ，长度值应该返回2
  leetcode 209. 长度最小的子数组
      */

public class test4 {
    public static void main(String[] args) {
        int[] words = {2, 3, 1, 2, -1, 4, 3, -1,7};
        System.out.println(getLength(words, 10));
        System.out.println(minSubArrayLen( 10, words));
    }

    // 连续数组
    public static int getLength(int[] words, int n) {
        if (words == null || words.length ==0) {
            return 0;
        }
        // 双指针？
        int left = 0;
        // 当前最小长度
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
