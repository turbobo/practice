package com.demo.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/5/11 21:37
 */
class findSubstring_30 {

    public static void main(String[] args) {
//        "bcabbcaabbccacacbabccacaababcbb"
//                ["c","b","a","c","a","a","a","b","c"]

//        "ababaab"
//                ["ab","ba","ba"]

        String[] words = new String[]{"ab","ba","ba"};
        findSubstring("ababaab", words);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();

        // 判断words长度
        int len1 = words.length;
        int len2 = words[0].length();
        int len_word = len1 * len2;

        // 字符串长度不够
        if (s.length() < len_word) {
            return res;
        }

        // 双指针----》滑动窗口
        int left = 0;
        while (left <= s.length() - len_word) {
//            if (left + len_word > s.length()) {
//                break;
//            }
            String str = s.substring(left, left + len_word);
            // 同时包含字符串数组的所有字符串
            if (isInclude(str, words)) {
                res.add(left);
            }
            left++;
        }
        return res;
    }
    // 字符串数组 可能会出现重复的字符串
    // 每次找到第一个匹配的位置 把字符串删除？？？---不可行
    public static boolean isInclude(String str, String[] words) {
        // 使用map记录该字符是否出现过，以及当前出现的位置
        Map<String, Integer> map = new HashMap();

        for (String s : words) {
            if (!str.contains(s)) {
                return false;
            } else {
                // 找到则移除
                if (map.containsKey(s)) {
                    int i = map.get(s);
                    // 去除之前找到的位置，重新匹配
                    int index = str.indexOf(s, i + 1);
                    if(-1 == index) {
                        return false;
                    }
                    // 存在则更新位置
                    map.put(s, index);
                    str = str.substring(0, index) + str.substring(index);
                } else {
                    map.put(s, str.indexOf(s));
                    str = str.substring(0, str.indexOf(s)) + str.substring(str.indexOf(s));
                }
            }
        }
        return true;
    }
}