package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangbo82
 * @Date: 2022年06月29日 19:16
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
        //先统计t的字符次数
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 哈希表 字符串 滑动窗口
        int slow = 0;
        int fast = 0;
        int minLen = s.length()+1;   //直接初始化为最大值
        //遍历s
        while (fast < s.length()){
            //该字符在t中出现才加入sMap
            if (tMap.containsKey(s.charAt(fast))){
                sMap.put(s.charAt(fast), sMap.getOrDefault(s.charAt(fast), 0) + 1);
            }

            //判断s是否完全包含t
            while (slow <= fast && sContaint(sMap, tMap)) {  //找到当前符合条件，并且长度最小
                if (fast-slow+1 < minLen){  //符合条件，并且长度最小，记录下来
                    left = slow;
                    right = fast;
                    minLen = right - left + 1;
                }
                //符合条件，但是长度不是最小，left继续后移
//                if (null == sMap.get(s.charAt(slow))) {
//                    sMap.remove(s.charAt(slow));
//                }else{
                    sMap.put(s.charAt(slow), sMap.getOrDefault(s.charAt(slow), 0)  - 1);
//                }

                slow++;

            }
            //fast后移
            fast++;
        }
        /*for (; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            //判断s是否包含t
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
        //遍历t即可
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
