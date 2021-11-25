package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/25 17:23
 * �ָ���Ĵ�
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
        //�и��ߵ����ַ���ĩβʱ����
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //������㣺�и�ж��Ƿ�Ϊ���Ĵ�
            if (isPalindrome(s, startIndex, i)) {
                //iÿ�δ�startIndexλ�ÿ�ʼ�����Ƚ�ȡ��ǰλ��
                //��һ��forѭ���ĺ�������У�startIndex���䣬ȷ�������и��ͬ���ȵ��Ӵ�
                //��������ⲻͬ��ʱ���и��ǽ�ȡ��ǰλ�õ�һ���ַ���
                String subStr = s.substring(startIndex, i+1);
                path.add(subStr);
            }else {                // ���������ֱ������
                continue;
            }
            //�ݹ�  i+1�������иʼ��λ�ã��ӵ�ǰ�и�ʣ�µ��ַ����м����и�
            backTrace(res, path, s, i + 1);
            //����
            path.removeLast();
        }
    }

    //˫ָ���ж��Ƿ�Ϊ���Ĵ�
    public static boolean isPalindrome(String s, int start, int end) {
        //������ż����i��j�������˳�
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
