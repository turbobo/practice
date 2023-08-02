package com.demo.interview.interview2023.kuaishou0801;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2023/8/1 18:59
 * 最长没有重复的子串
 * leetcode 3
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(getMaxSubString("ABDFAKED"));
        System.out.println(getMaxSubString2("ABDFAKED"));
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


    // 借助set  当右指针遇到重复字符，则依次将左边的字符删除，直到把当前右指针位置的相同元素删除
    public static String getMaxSubString2(String str) {
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        while (slow<str.length() && fast<str.length()) {
            // 右指针始终往后移动
            while (fast<str.length()) {
                if (set.contains(str.charAt(fast))) {
                    // 包含右指针元素
                    set.remove(str.charAt(slow));
                    slow++;
                    break;
                } else {
                    // 无重复，则把右指针位置元素加入
                    set.add(str.charAt(fast));
                    fast++;
                    // 直接比较set大小即可
//                    max = Math.max(max, set.size());  //此写法没有错误，但是位置错误，后面max还需要和set大小比较，此处不能先比较！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
                    if (max < set.size()) {
                        left = slow;
                        //
                        max =set.size();
//                        max = Math.max(max, set.size());  //这里比较
                    }
                }
            }

        }

        if (max == 0) {
            return "";
        } else {
            return str.substring(left, left + max);
        }
    }
}
