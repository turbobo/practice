package com.demo.interview.interview2023.kuaishou0801;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2023/8/1 18:59
 * 最长没有重复的子串
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(getMaxSubString("ABDFAKED"));
    }
    public static String getMaxSubString(String str) {
        if (str.length() == 0) {
            return "";
        }
        int left  = 0;
        int right  = 0;
        int l  = 0;
        int max = 0;
        Set set = new HashSet<Character>();
        while (left < str.length()) {
            // 每次先把left位置字符先放入set
            set.add(str.charAt(left));
            right = left+1;
            while (right < str.length()) {
                Character c = str.charAt(right);
                if(!set.contains(c)) {
                    set.add(c);
                    // left = 0  right=1   长度为2不是1 ！！！！！！！！！！！！！！！！！！！！！！！！！！！！
                    if (max < (right-left+1)) {
                        l = left;
                    }
                    max = Math.max(max, right-left+1);
                    right++;
                } else {
                    break;
                }

            }
            set.clear();
            left++;
        }
        if (max == 0) {
            return "";
        } else {
            // 这里加上最大长度即可，不用再加1，因为l位置已经是算一个长度，substring右边是开区间，左边是闭区间 [)
            return str.substring(l, l+max);
        }
    }
}
