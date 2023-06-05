package com.demo.interview.huawei20230523;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2023/5/23 21:33
 *
 * 翻转字符串
 *
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(reverseWords(s, start, end));
    }

    public static String reverseWords(String word, int start, int end) {
        // 分割字符
        String[] split = word.split(" ");
        // 特殊情况
        if (start == end) {
            return word;
        }
        if (start < 0) {
            start = 0;
        }
        if (end >= split.length) {
            end = split.length-1;
        }


        while (start < end) {
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();

        for(String str : split) {
            sb.append(str + " ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }


    //不需要将字符串拆分为数组进行操作。可以使用双指针在原字符串上进行操作，避免额外的内存空间开销。
    //
    //可以去除特殊情况的判断。由于指定区间是有效的，不需要对 start 和 end 进行特殊处理。
    //
    //可以直接使用 StringBuilder 的 reverse 方法来反转指定区间的字符。
    public static String reverseWords_gpt(String word, int start, int end) {
        if (start >= end) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word);
        int left = start;
        int right = end;

        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }

        return sb.toString();
    }

}
