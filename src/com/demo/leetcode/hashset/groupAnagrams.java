package com.demo.leetcode.hashset;

import java.util.*;

/**
 * @author: wangbo82
 * @Date: 2022��11��19�� 10:28
 * <p>
 * ����һ���ַ������飬���㽫 ��ĸ��λ�� �����һ�𡣿��԰�����˳�򷵻ؽ���б�
 * <p>
 * ��ĸ��λ�� ������������Դ���ʵ���ĸ�õ���һ���µ��ʣ�����Դ�����е���ĸͨ��ǡ��ֻ��һ�Ρ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/group-anagrams
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
        //ͳ��ÿ���ַ������ַ����ָ���
        for (int i = 0; i < strs.length; i++) {
            int[] ints = statisticCharacter(strs[i]);
            //int�����޷��Ƚ���ȫ��ͬ��ʹ���ַ�������
//            if (map.containsKey(ints)) {
            //��int��������תΪ�ַ���

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

    //ͳ���ַ����ַ����ָ���
    public static int[] statisticCharacter(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }
}
