package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/10/23 15:02
 * 给你一个由 n 个整数组成的数组?nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组?[nums[a], nums[b], nums[c], nums[d]]
 */
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //先排序
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 【i位置数值】正确去重方法：和前一个数比较
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 错误去重方法，将会漏掉-1,-1,2 这种情况
                /*
                if (nums[i] == nums[i + 1]) {
                    continue;
                }
                */

               /* if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }*/
                // 【j位置数值】正确去重方法：和前一个数比较
                if (j > i +1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //左右指针
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {  //总和过大
                        right--;
                    } else if (sum < target) {  //总和过小
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);

                        // 【左右指针位置数值】去重逻辑应该放在找到一个三元组之后 ---- 跳过重复的数值
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        // 找到答案时，双指针同时收缩
                        right--;
                        left++;
                    }
                }
            }

        }
        return result;
    }
}
