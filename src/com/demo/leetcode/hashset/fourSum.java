package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022年12月13日 20:14
 */
public class fourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0,0,0,0};
        System.out.println(fourSum(nums1,0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //此题求和不是0  需要判断和target的关系
        List<List<Integer>> res = new ArrayList();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        int i = 0;
        for(;i <= nums.length-4;i++) {
            //去重，但是要考虑到起始位置
            //只判断i位置重复即可，left right位置不再判断，left或者right和i位置元素相同无所谓
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            //第二个指针
            for (int j=i+1;j<=nums.length-3;j++) {
                //去重，但是要考虑到起始位置
                //判断j位置重复即可，left right位置不再判断，left或者right和i位置元素相同无所谓
                //j从1开始
                if (j > 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                //双指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        res.add(temp);

                        // 对left和right也要去重！！！！
                        // 去重逻辑应该放在找到一个三元组之后！！！！！对left 和 left去重
                        // 注意 right和前一位判断，left和后一位判断
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        //继续 移动一个指针即可，实际上两个指针都要移动，才能结果变化，继续判断，可能还存在其他位置
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
