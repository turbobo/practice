package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/10/23 15:02
 * ����һ���� n ��������ɵ�����?nums ����һ��Ŀ��ֵ target ��
 * �����ҳ���������������ȫ�������Ҳ��ظ�����Ԫ��?[nums[a], nums[b], nums[c], nums[d]]
 */
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //������
        Arrays.sort(nums);
        // �ҳ�a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // ��iλ����ֵ����ȷȥ�ط�������ǰһ�����Ƚ�
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // ����ȥ�ط���������©��-1,-1,2 �������
                /*
                if (nums[i] == nums[i + 1]) {
                    continue;
                }
                */

               /* if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }*/
                // ��jλ����ֵ����ȷȥ�ط�������ǰһ�����Ƚ�
                if (j > i +1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //����ָ��
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // ȥ�ظ��߼�����������0��0��0 �����������ֱ�ӵ��� right<=left �ˣ��Ӷ�©���� 0,0,0 ������Ԫ��
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {  //�ܺ͹���
                        right--;
                    } else if (sum < target) {  //�ܺ͹�С
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
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

        }
        return result;
    }
}
