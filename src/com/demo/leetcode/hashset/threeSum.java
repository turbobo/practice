package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022��12��13�� 17:17
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0,0,0,0};
        System.out.println(threeSum(nums1));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // [0,0,0,0]�������[[0,0,0],[0,0,0]]  ��left��rightҲҪȥ�أ�������


        List<List<Integer>> res = new ArrayList();
        if (nums.length < 3) {
            return res;
        }

        //˫ָ�뷨������Ҫ����
        Arrays.sort(nums);
        //���������ָ��
        int i = 0;


        for (;i<=nums.length-3;i++) {
            //˫ָ��Ѱ��ʣ����������λ��
            int left = i + 1;
            int right = nums.length - 1;

            //ȥ�أ�����Ҫ���ǵ���ʼλ��
            //ֻ�ж�iλ���ظ����ɣ�left rightλ�ò����жϣ�left����right��iλ��Ԫ����ͬ����ν
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //�ж�����λ�õ��ܺ�
            //�������������ж�ָ���ƶ�����
            //�������巽��������ָ�����м��ƶ�

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                    res.add(temp);

                    // ��left��rightҲҪȥ�أ�������
                    // ȥ���߼�Ӧ�÷����ҵ�һ����Ԫ��֮�󣬶�left �� leftȥ��
                    while (right > left && nums[right] == nums[right - 1]) left--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    //���� �ƶ�һ��ָ�뼴�ɣ�ʵ��������ָ�붼Ҫ�ƶ������ܽ���仯�������жϣ����ܻ���������λ��
                    left++;
                    right--;
                }
            }

            // if (nums[i] + nums[left] + nums[right] < 0) {
            //     //�ܺ�С��0 ��Ҫ����ֵ
            //     left++;
            //     //�ӵ�ǰλ�ÿ�ʼ�����ж�
            //     while (left < right) {
            //         if (nums[i] + nums[left] + nums[right] < 0) {
            //             left++;
            //         } else if (nums[i] + nums[left] + nums[right] > 0) {
            //             right--;
            //         } else {
            //             List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
            //             res.add(temp);
            //             //���� �ƶ�һ��ָ�뼴�ɣ������жϣ����ܻ���������λ��
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
