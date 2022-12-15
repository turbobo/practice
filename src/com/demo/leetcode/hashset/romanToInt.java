package com.demo.leetcode.hashset;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangbo82
 * @Date: 2022年12月14日 16:58
 */
public class romanToInt {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int res = 0;



        int[] arr = new int[26];
        arr['I' - 'A'] = 1;
        arr['V' - 'A'] = 5;
        arr['X' - 'A'] = 10;
        arr['L' - 'A'] = 50;
        arr['C' - 'A'] = 100;
        arr['D' - 'A'] = 500;
        arr['M' - 'A'] = 1000;
        int pre = 0;
        for (int i=0;i<s.length();i++) {
//            if (i > 0 && (s.charAt(i) > s.charAt(i-1))) {   //不是判断字母的顺序，而是判断当前元素对应的数值大小和前一位！！！！！！！！！！！！！！！

            if (i > 0 && arr[s.charAt(i) - 'A'] > pre) {
                res += arr[s.charAt(i) - 'A'];
                res -= pre;
                res -= pre;
            } else {
                res += arr[s.charAt(i) - 'A'];
            }
            pre = arr[s.charAt(i) - 'A'];
        }




        //使用加减法操作所有数据
        Map<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // String[] arr = s.split("");
        for (int i=0;i<s.length();i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i))) {
                res += map.get(s.charAt(i));
                res -= map.get(s.charAt(i-1));
                res -= map.get(s.charAt(i-1));
            } else {
                res += map.get(s.charAt(i));
            }
        }

        return res;
    }
}
