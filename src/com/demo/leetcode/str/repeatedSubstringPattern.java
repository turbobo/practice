package com.demo.leetcode.str;

/**
 * @Author Jusven
 * @Date 2023/3/13 21:33
 */
public class repeatedSubstringPattern {
    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("aba"));

    }
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return true;
        }
        // 子串肯定从第一位开始，因为要重复构成
        int end = 1;
        // 最少重复两次，所以子串长度不能超过一半
        /**
         * 存在才返回true,不存在则要一直遍历寻找下一个位置
         */
        while (end <= s.length() / 2 ) {
            String sub = s.substring(0, end);
            // 根据当前字串进行分割，然后判断分割的数组的元素是否相同
            String[] arr = s.split(sub);
            int i = 0;
            while (i<arr.length -1) {
                // 去除空字符串
                if (!"".equals(arr[i]) && ! arr[i] .equals(arr[i+1])) {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }
}
