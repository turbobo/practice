package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangbo82
 * @Date: 2022��06��29�� 19:16
 */
public class minWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right = 0;
        //��ͳ��t���ַ�����
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // ��ϣ�� �ַ��� ��������
        int slow = 0;
        int fast = 0;
        int minLen = s.length()+1;   //ֱ�ӳ�ʼ��Ϊ���ֵ
        //����s
        while (fast < s.length()){
            //���ַ���t�г��ֲż���sMap
            if (tMap.containsKey(s.charAt(fast))){
                sMap.put(s.charAt(fast), sMap.getOrDefault(s.charAt(fast), 0) + 1);
            }

            //�ж�s�Ƿ���ȫ����t
            while (slow <= fast && sContaint(sMap, tMap)) {  //�ҵ���ǰ�������������ҳ�����С
                if (fast-slow+1 < minLen){  //�������������ҳ�����С����¼����
                    left = slow;
                    right = fast;
                    minLen = right - left + 1;
                }
                //�������������ǳ��Ȳ�����С��left��������
//                if (null == sMap.get(s.charAt(slow))) {
//                    sMap.remove(s.charAt(slow));
//                }else{
                    sMap.put(s.charAt(slow), sMap.getOrDefault(s.charAt(slow), 0)  - 1);
//                }

                slow++;

            }
            //fast����
            fast++;
        }
        /*for (; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            //�ж�s�Ƿ����t
            while (sContaint(sMap, tMap) && left <= i) {
//                if (minLen == -1) {
//                    minLen = i - left + 1;
//                } else {
//                    minLen = Math.min(minLen, i - left + 1);
//                }
                if (i - left +1 < minLen){
                    minLen=i-left+1;

                }
                sMap.put(s.charAt(left),sMap.get(s.charAt(left))-1);
                left++;
            }

        }*/

        return minLen == (s.length()+1) ? "" : s.substring(left, right + 1);
    }

    public static boolean sContaint(Map<Character, Integer> s, Map<Character, Integer> t) {
        //����t����
        for (Map.Entry<Character, Integer> m : t.entrySet()) {
            Character key = m.getKey();
            if (null == s.get(key)) {
                return false;
            } else {
                if (s.get(key) < m.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
