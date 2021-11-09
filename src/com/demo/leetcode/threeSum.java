package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/10/23 13:56
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //������
        Arrays.sort(nums);
        // �ҳ�a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // ����֮�������һ��Ԫ���Ѿ������㣬��ô���������϶������ܴճ���Ԫ�飬ֱ�ӷ��ؽ���Ϳ�����
            if (nums[i] > 0) {
                return result;
            }
            // ����ȥ�ط���������©��-1,-1,2 �������
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            // ��iλ����ֵ����ȷȥ�ط�������ǰһ�����Ƚ�
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //����ָ��
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                // ȥ�ظ��߼�����������0��0��0 �����������ֱ�ӵ��� right<=left �ˣ��Ӷ�©���� 0,0,0 ������Ԫ��
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */

                if (nums[i] + nums[left] + nums[right] > 0) {  //�ܺ͹���
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {  //�ܺ͹�С
                    left++;
                } else {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    // ������ָ��λ����ֵ��ȥ���߼�Ӧ�÷����ҵ�һ����Ԫ��֮�� ---- �����ظ�����ֵ
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    // �ҵ���ʱ��˫ָ��ͬʱ����
                    right--;
                    left++;
                }
            }

        }
        return result;
    }

}

