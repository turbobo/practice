package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/5/15 11:11
 *
 * 最长公共子串---只有一个的情况
 *
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一
 *
 * */
public class LCS {
    public static void main(String[] args) {
        LCS("ABD", "BDE");
        LCS("1AB2345CD","12345EF");
    }

    //动态规划
    public static String LCS (String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //动态规划数组
        //text1[0,i]表示text1中前 i个字符
        //text2[0,j]表示text2中前 j个字符
        //dp[i][j]表示 text1中前 i个字符  和  text2中前 j个字符   存在公共子序列的个数
        //i=0  或者 j=0 dp[i][j]=0
        //text1[i] == text2[j] 时，dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ！= text2[j] 时，dp[i][j] = 0，该位不相同，重新计算

        int[][] dp = new int[m + 1][n + 1];
        //最大子串长度
        int length = 0;
        //最大子串位置
        int index = 0;
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //当前字符相同时，只需考虑text1  text2 各自一位子串的情况，再上本位相同即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //按位比较，该字符相同，重复子序列加 1

                    //每次记录当前最长子串的位置、长度
                    if(length<dp[i][j]){
                        length = dp[i][j];
                        index = i;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if(index!=0){
            System.out.println("动态规划矩阵: ");
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println(text1+" 和 "+text2+" 的最大公共子串: "+text1.substring(index-length,index)+" 长度: " + length);
            return text1.substring(index-length,index);   //返回子串
        }
        return "";

    }

    public String LCS2 (String str1, String str2) {
        String result = "";
        int start = 0;
        int end = 1;
        while(end<=str2.length()){
            String subStr = str2.substring(start,end);
            if(str1.contains(subStr)){   //字符串方法
                result = subStr;   //最长公共子串存在且唯一的情况
            }else{
                start++;
            }
            end++;
        }
        return result;
    }
}
