package com.demo.leetcode.str;

/**
 * @Author Jusven
 * @Date 2023/3/18 20:42
 */
public class strStr {
    public static void main(String[] args) {
        System.out.println(strStr("aabaabaafc", "aabaaf"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }

        // 二、或者两个指针分别从0和当前最后一个位置往中间遍历，判断两个位置是否相同
        // issip 不是 00020  方向不可相反： issi  如果是 isis，则为0012
//         for(int i=1;i<s.length();i++) {
//             j = 0; // j每次从模式串的第一个位置开始匹配
//             int max = 0;
//             int left = j;
//             int right = i; // i为模式串当前的末尾位置
//             while (left < right) {
//                 if (s.charAt(left) == s.charAt(right)) {
//                     max++;
//                     left++;
//                     right--;
//                 }
//                  else { // 错误！！！ 相同时，两个指针也要移动
//                     // 只要 字符串中有一个字符不同  就要结束
//                     break;
//                  }
//             }
//             next[i] = max;
//         }
    }
}
