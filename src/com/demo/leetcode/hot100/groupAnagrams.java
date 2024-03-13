package com.demo.leetcode.hot100;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2024/3/13 15:37
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 字母排序后，转为字符串来判断是否相同？
        //
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String s1 = new String(temp);
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
        res = new ArrayList<>(map.values());

        return res;
    }
}
