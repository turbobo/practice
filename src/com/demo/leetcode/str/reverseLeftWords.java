package com.demo.leetcode.str;

/**
 * @Author Jusven
 * @Date 2023/2/27 9:52
 */
public class reverseLeftWords {
    public static void main(String[] args) {
        reverseLeftWords("abcdefg", 2);
    }

    public static String reverseLeftWords(String s, int n) {
        if (s.length() <= 1 || s.length() <= n) {
            return s;
        }

        String head = s.substring(0, n);
        String tail = s.substring(s.length()-n, s.length());
        String res = tail + s.substring(n, s.length());
        return res;
    }
}
