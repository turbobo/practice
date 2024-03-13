package com.demo.leetcode.hot100;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2024/3/13 15:37
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 字符串排序后，转为字符串来判断是否相同
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 字符串转为数组
            char[] temp = s.toCharArray();
            // 数组排序--排序消耗性能
            Arrays.sort(temp);
            // 排序后的数组再构建字符串，方便作为map的key进行比较
            String s1 = new String(temp); // 创建对象消耗性能
            if (!map.containsKey(s1)) {
                List<String> list = new ArrayList<>(1);
                list.add(s);
                map.put(s1, list);
            } else {
                List<String> list = map.get(s1);
                list.add(s);
                map.put(s1, list);
            }
        }
//        Collection<List<String>> values = map.values();
        // map值 直接转为list
        res = new ArrayList<>(map.values());

        return res;
    }
}
