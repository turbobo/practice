package com.demo.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2024/3/22 15:21
 */
public class SubString {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODECBANC", "ABC"));

    }
    public static String minWindow(String s, String t) {
        // �Ӵ� ����ȫ��������Ҫ��¼
        // ����ʱ�����Ƚ�
        // ʹ������ͳ��t����ĸ����
        char[] t_arr = t.toCharArray();
        int[] t_arr_int = new int[t_arr.length];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t_arr) {
            t_arr_int[c - 'A']++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] s_arr = s.toCharArray();
        int l = 0;
        int r = 0;
        int left = 0;
        int right = 0;
        int min = s_arr.length;
        // ˫ָ��
        while (left < s_arr.length) {
            right = left;
//            int[] temp = t_arr_int; //t_arr_int��temp�޸���
            // ʹ�� clone() ������������
            int[] temp = t_arr_int.clone();

            while (right < s_arr.length) {
                int i = s_arr[right] - 'A';
                if (map.containsKey(s_arr[right])) {
                    
                }
                if (i>=0 && i < t_arr_int.length) {
                    temp[i]--;
                    if (right - left + 1 >= t_arr_int.length) {
                        //���ȴ��� t  �ж��Ƿ�ȫ��ȡ��
                        if (equal_t_arr(temp)) {
                            if ((right - left + 1) < min) {
                                l = left;
                                r = right;
                                min = right - left + 1;
                                break;
                            }
                        }
                    }
                }

                right++;
            }

            left++;
        }
        return s.substring(l, r+1);
    }

    public static boolean equal_t_arr (int[] t_arr_int) {
        for  (int i : t_arr_int) {
            if (i>0) {
                return false;
            }
        }
        return true;
    }
}
