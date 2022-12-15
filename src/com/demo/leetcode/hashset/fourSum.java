package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022��12��13�� 20:14
 */
public class fourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0,0,0,0};
        System.out.println(fourSum(nums1,0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //������Ͳ���0  ��Ҫ�жϺ�target�Ĺ�ϵ
        List<List<Integer>> res = new ArrayList();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        int i = 0;
        for(;i <= nums.length-4;i++) {
            //ȥ�أ�����Ҫ���ǵ���ʼλ��
            //ֻ�ж�iλ���ظ����ɣ�left rightλ�ò����жϣ�left����right��iλ��Ԫ����ͬ����ν
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            //�ڶ���ָ��
            for (int j=i+1;j<=nums.length-3;j++) {
                //ȥ�أ�����Ҫ���ǵ���ʼλ��
                //�ж�jλ���ظ����ɣ�left rightλ�ò����жϣ�left����right��iλ��Ԫ����ͬ����ν
                //j��1��ʼ
                if (j > 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                //˫ָ��
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

                        // ��left��rightҲҪȥ�أ�������
                        // ȥ���߼�Ӧ�÷����ҵ�һ����Ԫ��֮�󣡣���������left �� leftȥ��
                        // ע�� right��ǰһλ�жϣ�left�ͺ�һλ�ж�
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        //���� �ƶ�һ��ָ�뼴�ɣ�ʵ��������ָ�붼Ҫ�ƶ������ܽ���仯�������жϣ����ܻ���������λ��
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
