package com.demo.leetcode.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:
 * @Date: 2022��12��17�� 14:46
 */
public class longestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        int[] nums = new int[]{1,0,1,2};
        System.out.println("longestConsecutiveMine(nums) = " + longestConsecutiveMine(nums));
        System.out.println("longestConsecutive(nums) = " + longestConsecutive(nums));
    }

    public static int longestConsecutiveMine(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        if (nums.length == 1) {
            return res;
        }
        //�������ڣ�
        //�Ƚ���������
        Arrays.sort(nums);
        int temp = 1;


        //�������� �ж�ÿ��λ���Ƿ��ǰһ��λ�ô�1, �������ƶ���ͬʱ��¼��ǰ�����������
        for (int i = 1; i < nums.length; i++) {
            //�ظ�ֵ�������Ӵ��м���Լ��㣬�ڿ�ʼ���߽����������룿
            if (nums[i] - nums[i - 1] == 1) {
                // set.add(nums[i-1]);
                // set.add(nums[i]);

                temp++;
            } else if (nums[i] == nums[i - 1]) {
                //ʲô����ִ��

                // if (temp == 1) {
                //     continue;
                // } else {
                //     temp++;
                // }

            } else {
                //���ܵ�ǰֵ ������ ��ǰ�������Ӵ���
                // if (!set.contains(nums[i]))
                // if (i<nums.length -1 &&  nums[i] == nums[i+1]) {
                //     i++;
                // }
                //����
                temp = 1;
            }

            if (temp > res) {
                //��¼���
                res = temp;
            }
        }


        //��ǰԪ��ǰһ����ֵ������ʱ����Ϊ��㣬������ʱ����
        //��ǰԪ�غ����Ԫ�ش���ʱ����ʱ���ȼ�1����������
        //ʹ�ù�ϣ����


        return res;
    }

    public static int longestConsecutive(int[] nums) {
        // ����һ���洢�������Ĺ�ϣ��ͬʱ��ȥ�ع���
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // ����ȥ�غ����������
        for (int num : set) {
            int cur = num;
            // ֻ�е�num-1������ʱ���ſ�ʼ������num+1��num+2��num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]֮���������ģ�������cur - num + 1��
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}


