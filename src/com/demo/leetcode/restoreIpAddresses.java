package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/28 16:59
 * 复原 IP 地址
 */
public class restoreIpAddresses {

    public static void main(String[] args) {
//        System.out.println("12345".substring(2));
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if (s == null || s.length() == 0) {
            return res;
        }
        backTrack(s, res, 0, 0);
        return res;
    }

    private static void backTrack(String s, List<String> res, int startIndex, int count) {
        //结束条件
        if (count == 3) {
            if (startIndex == s.length() - 1) {
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            //处理本结点
            /*if (isLegal(s, startIndex, i)) {
                if (path.length() == 0) {
                    path.append(s.substring(startIndex, i + 1));
                } else {
                    path.append("." + s.substring(startIndex, i + 1));
                }
            } else {
                continue;
            }
            //递归
            count++;
            backTrace(s, res, path, startIndex + 1, count);
            //回溯
            count--;
            if (path.length() > 1) {
                path.deleteCharAt(path.length() - 1);
                path.deleteCharAt(path.length() - 1);
            } else {
                path.deleteCharAt(path.length() - 1);
            }*/

            //直接在原字符串上添加分割点
            if (isLegal(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后?插??个逗点
                count++;
                backTrack(s, res,i + 2, count);// 插?逗点之后下?个?串的起始位置为i+2
                count--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }

        }
    }

    private static boolean isLegal(String s, int startIndex, int i) {
        String substring = s.substring(startIndex, i + 1);
        if(substring.length()==0){
            return false;
        }
        int num = Integer.parseInt(substring);
        if (substring.startsWith("0") && substring.length()!=1) {
            return false;
        }
        if(substring.length() > 3 || num > 255){
            return false;
        }
        return true;
    }


}
