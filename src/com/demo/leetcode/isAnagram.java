//package com.demo.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: wangbo82
// * @Date: 2022��11��18�� 10:31
// */
//public class isAnagram {
//
//    public static void main(String[] args) {
//        String s = "";
//        String t = "";
//        //�ж���ĸ��λ��
//        //ʹ�ù�ϣ���ж������ַ�����������ĸ�Լ����ִ���
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character,Integer> map = new HashMap();
//        for (int i=0;i<s.length();i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) + 1 );
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//        //����t  ȥ��s���Ѵ��ڵ��ַ�
//        for (int i=0;i<t.length();i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) - 1 );
//                if (map.get(s.charAt(i)) <= 0) {
//                    map.remove(s.charAt(i));
//                }
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//
//        if (map.size() == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
