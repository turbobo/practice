package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2022/12/27 22:22
 */
public class wordBreak {

    public static void main(String[] args) {
//        String s = "applepenapple";
//        List<String> wordDict =  new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");

//        String s = "a";
//        List<String> wordDict =  new ArrayList<>();
//        wordDict.add("a");
//        System.out.println(wordBreak(s, wordDict));


        String s = "aebbbbs";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aeb");
        wordDict.add("ebbbb");
        wordDict.add("s");
        wordDict.add("eb");

        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        //使用set保存字典
        Set<String> set = new HashSet();
        for (String word : wordDict) {
            set.add(word);
        }
        //直接判断s是否存在
        if (set.contains(s)) {
            return true;
        }
        //特殊情况
        if (s.length() == 1) {
            if (set.contains(s)) {
                return true;
            } else {
                return false;
            }
        }


        for (int i = 1; i < s.length(); i++) {
            //首次分割
            String temp = s.substring(0, i);
            //存在则继续
            if (set.contains(temp)) {
                int start = i;
                int end = i + 1;
                int start2 = i;
                int end2 = i + 1;
                while (end <= s.length()) {

                    if (end2 == s.length()) {
                        end++;
                    }

                    String temp2 = s.substring(start, end2);
                    //start end  会有多层嵌套，每次返回时 end要逐层往后移动，而不是直接返回i
                    if (set.contains(temp2)) {
                        if (end == s.length()) {
                            return true;
                        }
                        //存在则继续
                        start = end2;
                        end2++;
                    } else {
                        //不存在，则end后移
                        end2++;
                    }
                }
            }
        }


        return false;
    }
}
