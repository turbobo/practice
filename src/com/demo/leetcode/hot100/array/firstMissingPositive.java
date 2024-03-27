package com.demo.leetcode.hot100.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2024/3/27 9:59
 */
public class firstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }
    public static int firstMissingPositive(int[] nums) {
        // // 先排序
        // int min = 0;
        // // List<Integer> list = new ArrayList(10000);
        // Set<Integer> set = new HashSet();

        // // 大于 0后，中间有缺少数字，取最小值----数字取值范围太大
        // // 使用数组下标统计 数字是否出现过
        // Arrays.sort(nums);
        // if (nums[0]>1) {
        //     return 1;
        // }

        // for (int i=0;i<nums.length;i++) {
        //     // if (nums[i] > 0) {
        //     //     list.set(i, 1);
        //     // } else {
        //     //     list.set(i ,0);
        //     // }
        //     set.add(nums[i]);
        // }
        // int length = 2^31-1;
        // // num排序后，取最大值
        // int index = nums[0];
        // for (;index<=nums[nums.length-1];index++) {
        //     if (index>0 && !set.contains(index)) {
        //         return index;
        //     }
        // }
        // if (index>nums[nums.length-1]) {
        //     if (nums[nums.length-1]<=-1) {
        //         return 1;
        //     } else {
        //     return nums[nums.length-1]+1;

        //     }
        // }
        // return 0;

        // 使用set统计
        Set<Integer> set = new HashSet();
        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int index=1;
        for (;index<=nums[nums.length-1];index++) {
            if (!set.contains(index)) {
                return index;
            }
        }
        if (index>nums[nums.length-1]) {
            if (nums[nums.length-1]<=-1) {
                return 1;
            } else {
                return nums[nums.length-1]+1;
            }
        }
        return 0;
    }
}
