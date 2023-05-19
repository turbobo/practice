package com.demo.interview.feizhu_20230418;

import java.util.*;

/**
 * 第二题
 * 给定一个字符串，计算字符串中每个单词出现的数量，并排序输出。
 * a. 单词一个大写字母开始，接着跟随0个或任意个小写字母；
 * b. 如果单词数量大于 1，单词后会跟着数字表示单词的数量。如果数量等于 1 则不会跟数字。例如，Hello2World 和 是合法，但 Hello1World2 这个表达是不合法的；
 * c. Hello2表示HelloHello；
 * d. (Hello2World2)3 可以等于Hello2World2Hello2World2Hello2World2；
 * 输出格式为：第一个（按字典序）单词，跟着它的数量（如果单词数量为1，则不输出），然后是第二个单词的名字（按字典序），跟着它的数量（如果单词数量为1，则不输出），以此类推。
 * 示例1：
 * 输入：字符串 = "World3Hello"
 * 输出: "HelloWorld3"
 * 解释: 单词数量是 {'Hello': 1, 'World': 3}。
 * 示例 2:
 * 输入: 字符串 = "Welcome4(ToAlibaba(To3)2)2"
 * 输出: "Alibaba2To14Welcome4"
 * 解释: 单词数量是 {'Alibaba': 2,  'To': 14', Welcome': 4,}。
 * 注意:
 * 字符串的长度在[1, 100000]之间。
 * 字符串只包含字母、数字和圆括号，并且题目中给定的都是合法的字符串。
 */

public class WordCount {

    public static void main(String[] args) {
        String input = "(Hello2World2)3";
        Map<String, Integer> wordCount = getWordCount(input);
        List<Map.Entry<String, Integer>> sortedList = sortByWord(wordCount);
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.print(entry.getKey());
            if (entry.getValue() > 1) {
                System.out.print(entry.getValue());
            }
            System.out.print(" ");
        }
    }

    public static Map<String, Integer> getWordCount(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                while (i < input.length() && Character.isLowerCase(input.charAt(i))) {
                    sb.append(input.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
                if (i < input.length() && Character.isDigit(input.charAt(i))) {
                    int count = input.charAt(i) - '0';
                    i++;
                    while (i < input.length() && Character.isDigit(input.charAt(i))) {
                        count = count * 10 + (input.charAt(i) - '0');
                        i++;
                    }
                    countStack.push(count);
                } else {
                    countStack.push(1);
                }
            } else if (c == ')') {
                i++;
                int repeat = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    repeat = repeat * 10 + (input.charAt(i) - '0');
                    i++;
                }
                String word = "";
                int count = 0;
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    word = stack.pop() + word;
                    count += countStack.pop();
                }
                stack.pop();
                count *= repeat;
                stack.push(word);
                countStack.push(count);
            } else {
                i++;
            }
        }
        while (!stack.isEmpty()) {
            String word = stack.pop();
            int count = countStack.pop();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + count);
        }
        return wordCount;
    }

    public static List<Map.Entry<String, Integer>> sortByWord(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return sortedList;
    }
}
