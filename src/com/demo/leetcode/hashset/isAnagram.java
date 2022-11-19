//package com.demo.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: wangbo82
// * @Date: 2022年11月18日 10:31
// */
//public class isAnagram {
//
//    public static void main(String[] args) {
//        String s = "";
//        String t = "";
//        //判断字母异位词
//        //使用哈希表判断两个字符串的所以字母以及出现次数
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
//        //遍历t  去除s中已存在的字符
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
