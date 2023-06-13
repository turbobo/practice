package com.demo.interview.huawei20230523;

/**
 * @Author Jusven
 * @Date 2023/6/4 20:39
 *
 *  一面
 *
 * /** * 给定一个整型数组和一个数字n,找到数组中最短的一个连续子数组 * 使得连续子数组的数字和 sum >= n，
 * 返回这个最短的连续子数组的长度值 * *
 * 例如：数组[2,3,1,2,4,3,7],n = 10 * 最短的连续子数组为[3,7] ，长度值应该返回2
  leetcode 209. 长度最小的子数组
      */

public class test4 {
    public static void main(String[] args) {
        int[] words = {2, 3, 1, 2, -1, 4, 3, -1,7};
        System.out.println(getLength( 10, words));
//        System.out.println(minSubArrayLen( 10, words));
    }

    // 连续数组
    // 写法错误!!!!!!!!!!!!!!!!!
    public static int getLength(int target, int[] nums) {
        // 如果目标值和某个元素相同时，没有进行判断  例如  {1，4，4} target=4
        if (nums == null || nums.length ==0) {
            return 0;
        }
        // 双指针？
        int left = 0;
        // 当前最小长度，使用一个不可能的数值
        int len = nums.length + 1;
        while (left <  nums.length ) {
            int right = left;
            int temp = 0;
            while (right < nums.length) {
                temp += nums[right];
                if (temp >= target) {
                    len = len < (right - left+1) ? len : (right - left+1);
                    break;
                }
                right++;
            }
            left++;
        }
        // return len;
        // 不存在可以返回0
        return len == (nums.length + 1) ? 0 : len;
    }

    // 使用滑动窗口+双指针
    // left在right指针基础上移动，所以O(n)

    // 在给定数组中使用滑动窗口的双指针方法，时间复杂度并不是O(n*n)，而是O(n)。这是因为双指针方法只遍历了数组一次，没有嵌套循环。
    //
    // 在该算法中，左指针和右指针都只向前移动，没有后退的操作。左指针从数组的开头开始，右指针随着条件的满足逐步向右移动。整个过程中，左指针和右指针都只移动了n次，其中n是数组的长度。
    // 可以看作一个窗口在移动，移动距离长 n
    public static int getLength2(int target, int[] nums) {
        // 如果目标值和某个元素相同时，没有进行判断  例如  {1，4，4} target=4
        if (nums == null || nums.length ==0) {
            return 0;
        }
        // 双指针？
        int left = 0;
        int temp = 0;
        int right = 0;
        // 当前最小长度，使用一个不可能的数值
        int len = nums.length + 1;
        while (right <  nums.length ) {
            // right = left;  // right不需要更新，始终记录窗口右边界的位置
            // 先计算当前位置的数值
            temp += nums[right];
            // 判断，如果满足，则收缩左指针
            while (left < nums.length && temp >= target) {
                len = len < (right - left+1) ? len : (right - left+1);
                temp -= nums[left];
                left++;
            }
            right++;
        }
        // return len;
        // 不存在可以返回0
        return len == (nums.length + 1) ? 0 : len;
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
