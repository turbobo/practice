package com.demo.leetcode.hashset;

/**
 * @Author Jusven
 * @Date 2023/2/23 9:31
 */
public class reverseWords {
    public static void main(String[] args) {
        System.out.println("reverseWords(\"the sky is blue\") = " + reverseWords("the sky  is  blue"));
    }

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public static String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        sb = reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 去除整个字符串两端的空格，有可能中间存在多个空格
     * @param s
     * @return
     */
    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 此处当start位置为空格时，当前新构建的字符串末尾处不是空格，也会添加；
            // 如果当前新构建的字符串sb的末尾已经添加了一个空格，则不需要再添加空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static StringBuilder reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

//            String s = sb.toString();
//            String swap = swap(s, start, end);
//            sb = new StringBuilder(swap);
//
            start++;
            end--;
        }

//        String s = sb.toString();
//        String swap = swap(s, start, end);
//        sb = new StringBuilder(swap);
        return sb;
//        System.out.println();

        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
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

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
