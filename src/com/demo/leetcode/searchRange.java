package com.demo.leetcode;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/10/31 18:07
 * 34.
 */
public class searchRange {
    public static void main(String[] args) {
//        int n = (8 + 10) >>> 1;

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
//        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int leftIndex = findFirstLocation(nums, target);
        if (leftIndex == -1) {
            return new int[]{-1, -1};
        }
        int rightIndex = findLastLocation(nums, target) - 1;
        return new int[]{leftIndex, rightIndex};
    }

    //目标值最后出现位置
    private static int findLastLocation(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //(left + right + 1) / 2：向上取整,防止死循环:
            // 当int[] nums = {5, 7, 7, 8, 8, 10}; int target = 8;
            // left = 4,mid = 4,right = 5, 此时 (left + right) / 2 = 4,一直执行left = mid,死循环
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //目标值在mid右边，下一轮搜索区间 [mid + 1, right]
                //因为是小于target，所以是闭区间 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //继续向右找 [mid,right]
                //当前位置也可能是最后位置  所以是闭区间 left = mid
                left = mid;
            } else {
                //nums[mid] > target,目标值在mid左边
                //大于taatrget, 所以是闭区间，下一轮搜索区间 [left, mid -1]
                right = mid - 1;
            }
        }
        return left;
    }

    //目标值第一次出现的位置
    public static int findFirstLocation(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //目标值在mid右边，下一轮搜索区间 [mid + 1, right]
                //因为是小于target，所以是闭区间 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //第一次出现位置不可能在mid右边
                //继续向左找，[left mid]
                right = mid;
            } else {
                //nums[mid] > target,目标值在mid左边
                //大于taatrget, 所以是闭区间，下一轮搜索区间 [left, mid -1]
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
