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
        // 子串 不能全局排序，需要记录
        // 遍历时排序后比较
        // 使用数组统计t的字母个数
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
        // 双指针
        while (left < s_arr.length) {
            right = left;
//            int[] temp = t_arr_int; //t_arr_int被temp修改了
            // 使用 clone() 方法复制数组
            int[] temp = t_arr_int.clone();

            while (right < s_arr.length) {
                int i = s_arr[right] - 'A';
                if (map.containsKey(s_arr[right])) {
                    
                }
                if (i>=0 && i < t_arr_int.length) {
                    temp[i]--;
                    if (right - left + 1 >= t_arr_int.length) {
                        //长度大于 t  判断是否全部取完
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
