package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022年12月13日 17:17
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0,0,0,0};
        System.out.println(threeSum(nums1));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // [0,0,0,0]错误，输出[[0,0,0],[0,0,0]]  对left和right也要去重！！！！


        List<List<Integer>> res = new ArrayList();
        if (nums.length < 3) {
            return res;
        }

        //双指针法首先需要排序
        Arrays.sort(nums);
        //遍历数组的指针
        int i = 0;


        for (;i<=nums.length-3;i++) {
            //双指针寻找剩下两个数的位置
            int left = i + 1;
            int right = nums.length - 1;

            //去重，但是要考虑到起始位置
            //只判断i位置重复即可，left right位置不再判断，left或者right和i位置元素相同无所谓
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //判断三个位置的总和
            //数组升序排序，判断指针移动方向
            //但是总体方向是两个指针往中间移动

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                    res.add(temp);

                    // 对left和right也要去重！！！！
                    // 去重逻辑应该放在找到一个三元组之后，对left 和 left去重
                    while (right > left && nums[right] == nums[right - 1]) left--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    //继续 移动一个指针即可，实际上两个指针都要移动，才能结果变化，继续判断，可能还存在其他位置
                    left++;
                    right--;
                }
            }

            // if (nums[i] + nums[left] + nums[right] < 0) {
            //     //总和小于0 需要增大值
            //     left++;
            //     //从当前位置开始继续判断
            //     while (left < right) {
            //         if (nums[i] + nums[left] + nums[right] < 0) {
            //             left++;
            //         } else if (nums[i] + nums[left] + nums[right] > 0) {
            //             right--;
            //         } else {
            //             List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
            //             res.add(temp);
            //             //继续 移动一个指针即可，继续判断，可能还存在其他位置
            //             left++;
            //         }
            //     }
            // } else if (nums[i] + nums[left] + nums[right] > 0) {
            //     right--;
            //     while (left < right) {
            //         if (nums[i] + nums[left] + nums[right] < 0) {
            //             left++;
            //         } else if (nums[i] + nums[left] + nums[right] > 0) {
            //             right--;
            //         } else {
            //             List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
            //             res.add(temp);
            //             left++;
            //         }
            //     }
            // } else {
            //         List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
            //         res.add(temp);
            //         left++;
            // }

        }
        return res;
    }
}
