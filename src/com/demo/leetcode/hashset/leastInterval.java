package com.demo.leetcode.hashset;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2023/2/5 22:10
 */
public class leastInterval {
    public static void main(String[] args) {
        char[] str = new char[]{ 'B', 'B', 'B', 'C', 'A', 'A', 'A'};
        leastInterval(str, 2);
    }

    public static int leastInterval(char[] tasks, int n) {
//        Map<Character, Integer> map = new HashMap<>();
//        Comparator comparator = new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return o1.getValue() - o2.getValue();
//            }
//        };
//        //统计每个元素出现次数
//        for (char c : tasks) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        ArrayList list = new ArrayList(map.entrySet());
//        Collections.sort(list, comparator);
//
//        // 遍历list
//        for (Object m : list) {
//            Map.Entry<Character, Integer> e =  (Map.Entry<Character, Integer>) m;
//
//        }
//        return 0;


        if(n == 0) {
            return tasks.length;
        }
        int[] taskCount = new int[26];
        for(char c : tasks) {
            taskCount[c - 'A']++;
        }
        int max = 0;//同一个任务执行次数的最大值
        int maxCount = 0;//执行了max次的任务有多少个
        for(int i = 0; i < 26; i++) {
            if(taskCount[i] > max) {
                max = taskCount[i];  //大于当前最大出现次数，重新记录最次数，个数初始化为1
                maxCount = 1;  //
            } else if(max == taskCount[i]) {  //等于当前最大出现次数，记录个数即可
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);

    }
}
