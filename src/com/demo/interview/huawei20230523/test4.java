package com.demo.interview.huawei20230523;

/**
 * @Author Jusven
 * @Date 2023/6/4 20:39
 *
 *  һ��
 *
 * /** * ����һ�����������һ������n,�ҵ���������̵�һ������������ * ʹ����������������ֺ� sum >= n��
 * ���������̵�����������ĳ���ֵ * *
 * ���磺����[2,3,1,2,4,3,7],n = 10 * ��̵�����������Ϊ[3,7] ������ֵӦ�÷���2
  leetcode 209. ������С��������
      */

public class test4 {
    public static void main(String[] args) {
        int[] words = {2, 3, 1, 2, -1, 4, 3, -1,7};
        System.out.println(getLength( 10, words));
//        System.out.println(minSubArrayLen( 10, words));
    }

    // ��������
    // д������!!!!!!!!!!!!!!!!!
    public static int getLength(int target, int[] nums) {
        // ���Ŀ��ֵ��ĳ��Ԫ����ͬʱ��û�н����ж�  ����  {1��4��4} target=4
        if (nums == null || nums.length ==0) {
            return 0;
        }
        // ˫ָ�룿
        int left = 0;
        // ��ǰ��С���ȣ�ʹ��һ�������ܵ���ֵ
        int len = nums.length + 1;
        while (left <  nums.length ) {
            int right = left;
            int temp = 0;
            while (right < nums.length) {
                temp += nums[right];
                if (temp >= target) {
                    len = len < (right - left+1) ? len : (right - left+1);
                    break;
                }
                right++;
            }
            left++;
        }
        // return len;
        // �����ڿ��Է���0
        return len == (nums.length + 1) ? 0 : len;
    }

    // ʹ�û�������+˫ָ��
    // left��rightָ��������ƶ�������O(n)

    // �ڸ���������ʹ�û������ڵ�˫ָ�뷽����ʱ�临�ӶȲ�����O(n*n)������O(n)��������Ϊ˫ָ�뷽��ֻ����������һ�Σ�û��Ƕ��ѭ����
    //
    // �ڸ��㷨�У���ָ�����ָ�붼ֻ��ǰ�ƶ���û�к��˵Ĳ�������ָ�������Ŀ�ͷ��ʼ����ָ�����������������������ƶ������������У���ָ�����ָ�붼ֻ�ƶ���n�Σ�����n������ĳ��ȡ�
    // ���Կ���һ���������ƶ����ƶ����볤 n
    public static int getLength2(int target, int[] nums) {
        // ���Ŀ��ֵ��ĳ��Ԫ����ͬʱ��û�н����ж�  ����  {1��4��4} target=4
        if (nums == null || nums.length ==0) {
            return 0;
        }
        // ˫ָ�룿
        int left = 0;
        int temp = 0;
        int right = 0;
        // ��ǰ��С���ȣ�ʹ��һ�������ܵ���ֵ
        int len = nums.length + 1;
        while (right <  nums.length ) {
            // right = left;  // right����Ҫ���£�ʼ�ռ�¼�����ұ߽��λ��
            // �ȼ��㵱ǰλ�õ���ֵ
            temp += nums[right];
            // �жϣ�������㣬��������ָ��
            while (left < nums.length && temp >= target) {
                len = len < (right - left+1) ? len : (right - left+1);
                temp -= nums[left];
                left++;
            }
            right++;
        }
        // return len;
        // �����ڿ��Է���0
        return len == (nums.length + 1) ? 0 : len;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
