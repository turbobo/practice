package com.demo.interview.pdd;

/**
 * @Author Jusven
 * @Date 2024/4/15 12:54
 *  53. 最大子数组和
 */
class Solution {
    public static void main(String[] args) {
//        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        maxSubArray(new int[]{-2,-1,0,3,-1,2,1,-5,4});
        maxSubArray(new int[]{-2,-1,0,122,-1,2,1,-5,4});
    }
    public static int maxSubArray(int[] nums) {
        return getArraySum(nums);
    }

    // pdd笔试题 通过
    public static Integer getArraySum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] pre = new int[arr.length];
        int max = arr[0];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 前一个位置最大和 加上 当前位置数字
             int sum = pre[i - 1] + arr[i];
            // 当前最大和
            pre[i] = Math.max(sum, arr[i]);
            max = Math.max(max, pre[i]);
        }
        return max;
    }
}
