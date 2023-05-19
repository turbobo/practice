package com.demo.leetcode.hashset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangbo82
 * @Date: 2022年12月16日 9:51
 */
public class isIsomorphic {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println("isIsomorphic(s,t) = " + isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //用哈希表记录
        //本题涉及到所有字符，数量不大，且不用记录下标，可以用数组
        //所有字符共128个
        int[] arr = new int[128];
        Arrays.fill(arr,-1);
        //同时遍历两个字符串，匹配每一个位置
        for (int i=0;i<s.length();i++) {
            //同时判断 s t当前位置的字符是否在数组中
            if (arr[s.charAt(i)] == -1 && arr[t.charAt(i)] == -1) {
                //同时将两边的映射加入数组
                arr[s.charAt(i)] = t.charAt(i);
                arr[t.charAt(i)] = s.charAt(i);
            } else {
                if (arr[s.charAt(i)] != t.charAt(i) || arr[t.charAt(i)] != s.charAt(i)) {
                    return false;
                }
            }
        }


       /* for (int i=0;i<s.length();i++) {
            if (arr[s.charAt(i)] == -1) {
                if (arr[t.charAt(i)] == -1) {
                    arr[s.charAt(i)] = t.charAt(i);
                    arr[t.charAt(i)] = s.charAt(i);
                } else {
                    if (arr[t.charAt(i)] != s.charAt(i)) {
                        return false;
                    }
                }

            } else {
                if (arr[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }*/



            //单向映射
//            Map<Character,Character> map = new HashMap();
//            for (int i=0;i<s.length();i++) {
//                //s当前位置在map中没有映射
//                if (map.get(s.charAt(i)) == null) {
//                    if (map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
//                        return false;
//                    }
//                    map.put(s.charAt(i),t.charAt(i));
//                    //不同字符不可映射同一字符
////                    if (map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
////                        return false;
////                    }
//                } else {
//                    //当前不为空，判断映射是否和之前一致,即同一个字符只能映射一个字符
//                    if (map.get(s.charAt(i)) != t.charAt(i)) {
//                        return false;
//                    }
//
//
//
//                }
//            }



        return true;
    }
}
