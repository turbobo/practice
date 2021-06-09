package com.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Author Jusven
 * @Date 2021/5/14 16:08
 * 最长不重复子串
 *
 * 子串和子序列不同，字串必须字符间必须相连
 *
给定一个字符串，请你找出其中不含有重复字符的  的长度。
示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        int d = 'D';
        char g = 122;
        Stack<Integer> stack1 = new Stack<>();


        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
    }

    //用 map集合
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length()==0)
            return 0;
        //存放字符和位置
        HashMap<Character, Integer> map = new HashMap<>();

        int index = s.charAt(1);
        int i = 0;
        int length = 0;
        while(i<s.length()){
            for(;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    //从重复的字符的后一个位置重新开始
                    i = map.get(s.charAt(i))+1;
                    break;
                }else{
                    map.put(s.charAt(i),i);
                }
            }
//            if(length<map.size())
//                length = map.size();
            length = Math.max(length,map.size());

            //清空之前的数据
            map.clear();
        }
        return length;
    }

    //滑动窗口
    public static int lengthOfLongestSubstring3(String s) {
        if(s.length()==0)
            return 0;
        //记录最左边界
        int left = 0;
        //记录最大间隔
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);  //字符上次出现位置的后一个位置
            }
            //本次位置也需要记录
            map.put(s.charAt(i),i);
            //当前间隔重新计算，有重复字符存在则需要排除，从字符上次出现位置的后一个位置left开始
            length = Math.max(length,i-left+1);
        }
        return length;
    }

}
