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

    //Ŀ��ֵ������λ��
    private static int findLastLocation(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //(left + right + 1) / 2������ȡ��,��ֹ��ѭ��:
            // ��int[] nums = {5, 7, 7, 8, 8, 10}; int target = 8;
            // left = 4,mid = 4,right = 5, ��ʱ (left + right) / 2 = 4,һֱִ��left = mid,��ѭ��
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //Ŀ��ֵ��mid�ұߣ���һ���������� [mid + 1, right]
                //��Ϊ��С��target�������Ǳ����� [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //���������� [mid,right]
                //��ǰλ��Ҳ���������λ��  �����Ǳ����� left = mid
                left = mid;
            } else {
                //nums[mid] > target,Ŀ��ֵ��mid���
                //����taatrget, �����Ǳ����䣬��һ���������� [left, mid -1]
                right = mid - 1;
            }
        }
        return left;
    }

    //Ŀ��ֵ��һ�γ��ֵ�λ��
    public static int findFirstLocation(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //Ŀ��ֵ��mid�ұߣ���һ���������� [mid + 1, right]
                //��Ϊ��С��target�������Ǳ����� [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //��һ�γ���λ�ò�������mid�ұ�
                //���������ң�[left mid]
                right = mid;
            } else {
                //nums[mid] > target,Ŀ��ֵ��mid���
                //����taatrget, �����Ǳ����䣬��һ���������� [left, mid -1]
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
