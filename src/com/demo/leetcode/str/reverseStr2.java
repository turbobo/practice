package com.demo.leetcode.str;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2023/2/19 16:57
 */
public class reverseStr2 {
    public static void main(String[] args) {
//        String abcdefg = reverseStr("abcdefg", 2);
//        String abcdefg = reverseStr("ba", 1);
//        String abcdefg = reverseStr("abcd", 4);
//        System.out.println("abcdefg = " + abcdefg);

//        char[] c = "hello".toCharArray();
//        swap(c, 1, 2);


        //交换字符串
        char a = 'a';
        char b = 'b';

        a ^=  b;
        b ^=  a;
        a ^=  b;
        System.out.println();

    }

    public static String reverseStr(String s, int k) {
        int i = 0;
        int oneK = 0;
        int twoK = 0;
        while (i <= s.length() - 1) {
            oneK = i + k - 1;
            twoK = i + 2 * k - 1;
            if (twoK <= s.length() && twoK >= oneK) {
                //反转前k个
                s = swap(s, i, oneK);
            } else if (twoK > s.length() && oneK <= s.length()) {
                //反转前k个
                s = swap(s, i, oneK);
            } else if (oneK > s.length()) {
                //反转剩下所有
                s = swap(s, i, s.length() - 1);
            }
//            i = i + 2 * k - 1;
            i = i + 2 * k;  // i是起始点,该点包含在内,不是上次操作字符串的结尾
        }
        return s;
    }

    //left right均包含当前元素
    public static StringBuilder reverseString(StringBuilder s, int left, int right) {
        if (s.length() <= 1) {
            return s;
        }
        //先将s 区间转为数组
        String[] arr = s.substring(left, right + 1).split("");
        //双指针，从两边分别往中间移动
        // int left = 0;
        // int right = s.length() - 1;
        while (left < right) {  //此处不用考虑left right是否相交，或者s长度为奇数/偶数
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        //重新拼接s
        StringBuilder sb = new StringBuilder("");
        sb.append(s.substring(0, left - 1));
        sb.append(Arrays.toString(arr));
        sb.append(s.substring(right + 1, s.length()));
        System.out.println(sb.toString());
        return sb;
    }


    public static String swap(String s, int l, int r) {
//        c[l] ^= c[r];  //构造 a ^ b 的结果，并放在 a 中
//        c[r] ^= c[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b  ======> 一个数异或同一个数两次，结果还是那个数，而且不会超出int范围
//        c[l] ^= c[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换

//        x = x^y;
//        y = x^y;  //y=(x^y)^y
//        x = x^y;  //x=(x^y)^x

        char[] c = s.toCharArray();
        if (l < r) {

            c[l] ^= c[r];
            c[r] ^= c[l];
            c[l] ^= c[r];
        }


        System.out.println("new String(c) = " + new String(c));
        return new String(c);
    }


}
