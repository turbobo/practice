package com.demo.leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/15 14:53
 *
 * 最长公共子序列
 *
 * 给定两个字符串?text1 和?text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的?子序列?是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 */
public class longestCommonSubsequence {
    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("fdsadf", "fslfdaja"));
//        longestCommonSubsequence("faghbc", "afbgch");

        /*
        * "abcbdab", "bdcaba"
        * bcba
        * bcab
        * bdab
        * */
        longestCommonSubsequence2("abcbdab", "bdcaba");

    }
    public static int longestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        //动态规划数组
        //text1[0,i]表示text1中前 i个字符
        //text2[0,j]表示text2中前 j个字符
        //dp[i][j]表示 text1中前 i个字符  和  text2中前 j个字符   存在公共子序列的个数
        //i=0  或者 j=0 dp[i][j]=0
        //text1[i] == text2[j] 时，dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ！= text2[j] 时，一个字符串和另一个字符串的前一位比较：dp[i][j] = max(dp[i][j-1],dp[i-1][j])

        //记录text1 有最大长度时的位置

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //当前字符相同时，只需考虑text1  text2 各自一位子串的情况，再上本位相同即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //按位比较，该字符相同，重复子序列加 1
                } else {
                    //当前字符相同时，考虑text1前一位子串和text2的情况, text2前一位子串和text1的情况，取最大值即可
                    //在二维数组中就是左边位置，上边位置
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("动态规划矩阵: ");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(text1+" 和 "+text2+" 的最大公共子序列: "+" 长度: " + dp[m][n]);
        Long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        /*
        * 记录最大长度的所有位置---选出其中一个字符串记录即可
        * */
        for (int i = m, j = n; i >= 1 && j >= 1; ) {//倒着打印
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //字符串，不是dp数组
//                System.out.print(text1.charAt(i - 1) + " ");
                sb.append(text1.charAt(i - 1));
                //都后退一位
                i--;
                j--;
            } else {
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        Long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println(sb.reverse().toString());
        System.out.println("*********************************");


       /* //逆序
        StringBuffer stringBuffer = new StringBuffer(text1);
        String two = stringBuffer.reverse().toString();
        System.out.println(two);*/
        return dp[m][n];

    }

    //打印所有最长公共子序列
    public static int longestCommonSubsequence2(String text1, String text2){
        int m = text1.length(), n = text2.length();
        //动态规划数组
        //text1[0,i]表示text1中前 i个字符
        //text2[0,j]表示text2中前 j个字符
        //dp[i][j]表示 text1中前 i个字符  和  text2中前 j个字符   存在公共子序列的个数
        //i=0  或者 j=0 dp[i][j]=0
        //text1[i] == text2[j] 时，dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ！= text2[j] 时，一个字符串和另一个字符串的前一位比较：dp[i][j] = max(dp[i][j-1],dp[i-1][j])

        //记录text1 有最大长度时的位置

        int[][] dp = new int[m + 1][n + 1];
        //最大子序列长度
        int length = 0;
        //最大子序列位置---text1中的位置
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //当前字符相同时，只需考虑text1  text2 各自一位子串的情况，再上本位相同即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //按位比较，该字符相同，重复子序列加 1
                    //每次记录当前最长子序列的位置、长度
                    if(length<dp[i][j]){
                        length = dp[i][j];
                        l.clear();   //先清空之前所有位置
                        l.add(i);
                    }else if(length == dp[i][j]){
                        l.add(i);
                    }

                } else {
                    //当前字符相同时，考虑text1前一位子串和text2的情况, text2前一位子串和text1的情况，取最大值即可
                    //在二维数组中就是左边位置，上边位置
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("动态规划矩阵: ");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(text1+" 和 "+text2+" 的最大公共子序列长度为 " + dp[m][n] +"，有" + "个");

        Long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        /*
         * 记录最大长度的所有位置---选出其中一个字符串记录即可
         * */
        for (int k = 0; k < l.size(); k++) {
            int index = l.get(k);
            for (int i = index, j = n; i >= 1 && j >= 1; ) { //倒着打印
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //字符串，不是dp数组
//                System.out.print(text1.charAt(i - 1) + " ");
                    sb.append(text1.charAt(i - 1));
                    //都后退一位
                    i--;
                    j--;
                } else {
                    if (dp[i][j - 1] >= dp[i - 1][j]) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            System.out.println(sb.reverse().toString());
            System.out.println();
        }
        /*for (int i = m, j = n; i >= 1 && j >= 1; ) {//倒着打印
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //字符串，不是dp数组
//                System.out.print(text1.charAt(i - 1) + " ");
                sb.append(text1.charAt(i - 1));
                //都后退一位
                i--;
                j--;
            } else {
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }*/

        Long end = System.nanoTime();
        System.out.println(end - start);

        System.out.println("*********************************");


       /* //逆序
        StringBuffer stringBuffer = new StringBuffer(text1);
        String two = stringBuffer.reverse().toString();
        System.out.println(two);*/
        return dp[m][n];

    }
}
