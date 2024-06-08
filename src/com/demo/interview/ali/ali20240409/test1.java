package com.demo.interview.ali.ali20240409;

import com.demo.algorithm.test.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2024/4/9 17:54
 * һ���ַ���str��һ���ַ�������arr���ж�arr�е��ַ��Ƿ����ƴ�ӳ�str��arr���ַ������ظ�ʹ��
 */
public class test1 {
    public static boolean canConstruct(String target, String[] arr) {
        return backtrack(target, arr, 0, new boolean[arr.length]);
    }

    private static boolean backtrack(String target, String[] arr, int start, boolean[] visited) {
        if (start >= target.length()) {
            return true; // �ɹ�ƥ�����
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && target.startsWith(arr[i], start)) {
                visited[i] = true;
                if (backtrack(target, arr, start + arr[i].length(), visited)) {
                    return true; // �ɹ�ƥ��
                }
                visited[i] = false; // ����
            }
        }

        return false; // �޷�ƥ��
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
                // ���� �����ж�
                // ƥ�䵽����Ҫ��������ַ�
                if (backTrace_concat(str, arr, right, set)) {
                    return true;
                }
            } else {

            }
        }
        return false;
    }

}
