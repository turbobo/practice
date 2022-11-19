package com.demo.leetcode.hashset;

import java.util.*;

/**
 * @author: wangbo82
 * @Date: 2022年11月19日 10:28
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class groupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<String,List<String>> map = new HashMap<>();
        //统计每个字符串的字符出现个数
        for (int i = 0; i < strs.length; i++) {
            int[] ints = statisticCharacter(strs[i]);
            //int数组无法比较完全相同，使用字符串代替
//            if (map.containsKey(ints)) {
            //将int数组依次转为字符串

            String s = Arrays.toString(ints);
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(strs[i]);
                map.put(s,strings);
            } else {
                map.put(s,new ArrayList<String>(Collections.singleton(strs[i])));
            }
        }

//        res = Collections.list(Collections.enumeration(map.values()));
        res = new ArrayList<List<String>>(map.values());

//        for(Map.Entry<int[],List<String>> m : map.entrySet()) {
//
//        }

        return res;
    }

    //统计字符串字符出现个数
    public static int[] statisticCharacter(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }
}
