package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/25 17:23
 * 分割回文串
 */
public class isPalindrome {
    public static void main(String[] args) {
//        System.out.println("ada".substring(0, 2));
//        System.out.println(isPalindrome("ada",0,2));
        partition("aab");
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        backTrace(res, path, s, 0);
        return res;
    }


    private static void backTrace(List<List<String>> res, LinkedList<String> path, String s, int startIndex) {
        //切割线到达字符串末尾时结束
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //处理本结点：切割并判断是否为回文串
            if (isPalindrome(s, startIndex, i)) {
                //i每次从startIndex位置开始，首先截取当前位置
                //在一次for循环的横向遍历中，startIndex不变，确保可以切割到不同长度的子串
                //跟组合问题不同的时，切割是截取当前位置的一段字符串
                String subStr = s.substring(startIndex, i+1);
                path.add(subStr);
            }else {                // 如果不是则直接跳过
                continue;
            }
            //递归  i+1：后面切割开始的位置，从当前切割剩下的字符串中继续切割
            backTrace(res, path, s, i + 1);
            //回溯
            path.removeLast();
        }
    }

    //双指针判断是否为回文串
    public static boolean isPalindrome(String s, int start, int end) {
        //不管奇偶数，i和j相遇就退出
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
