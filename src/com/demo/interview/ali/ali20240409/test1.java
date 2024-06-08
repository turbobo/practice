package com.demo.interview.ali.ali20240409;

import com.demo.algorithm.test.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2024/4/9 17:54
 * 一个字符串str和一个字符串数组arr，判断arr中的字符是否可以拼接成str，arr中字符可以重复使用
 */
public class test1 {
    public static boolean canConstruct(String target, String[] arr) {
        return backtrack(target, arr, 0, new boolean[arr.length]);
    }

    private static boolean backtrack(String target, String[] arr, int start, boolean[] visited) {
        if (start >= target.length()) {
            return true; // 成功匹配完成
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && target.startsWith(arr[i], start)) {
                visited[i] = true;
                if (backtrack(target, arr, start + arr[i].length(), visited)) {
                    return true; // 成功匹配
                }
                visited[i] = false; // 回溯
            }
        }

        return false; // 无法匹配
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String str = "abc";
//        String[] arr = {"ab", "abc"};
//        String str = "abcd";
//        String[] arr = {"ab", "cd", "ef"};

//        String str = "";
//        String[] arr = {"ab", "cd", "ef"};

//        String str = "abc";
//        String[] arr = {};


        String str = "abcabc";
        String[] arr = {"ab", "c"};



        System.out.println(canConstruct(str, arr)); // true


//        System.out.println(my_concat(str, arr)); //
    }


    public static boolean my_concat(String str, String[] arr) {
        if (null == str || str.length() == 0 || null == arr || arr.length == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }

        return backTrace_concat(str, arr, 0, set);

    }

    public static boolean backTrace_concat(String str, String[] arr, int start, Set<String> set) {
        if (start >= str.length()) {
            return true;
        }
        int left = start;
        int right = left + 1;
        for (; right <= str.length(); right++) {
            String substring = str.substring(left, right);
            if (set.contains(substring)) {
                // 回溯 继续判断
                // 匹配到，需要跳过这个字符
                if (backTrace_concat(str, arr, right, set)) {
                    return true;
                }
            } else {

            }
        }
        return false;
    }

}
