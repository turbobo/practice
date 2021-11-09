package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/10/23 14:28
 * �����ĸ��������� nums1��nums2��nums3 �� nums4 �����鳤�ȶ��� n ����������ж��ٸ�Ԫ�� (i, j, k, l) �����㣺
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        //ͳ�����������е�Ԫ��֮�ͣ�ͬʱͳ�Ƴ��ֵĴ���������map
        //��ͳ��ǰ��������
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        //ͳ��ʣ�������Ԫ�صĺͣ���map�����Ƿ�������Ϊ0�������ͬʱ��¼����
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)) {
                    result += map.get(0 - temp);
                }
            }
        }
        return result;
    }
}
