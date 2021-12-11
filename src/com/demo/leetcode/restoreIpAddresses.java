package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/28 16:59
 * ��ԭ IP ��ַ
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
        //��������
        if (count == 3) {
            if (startIndex == s.length() - 1) {
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            //�������
            /*if (isLegal(s, startIndex, i)) {
                if (path.length() == 0) {
                    path.append(s.substring(startIndex, i + 1));
                } else {
                    path.append("." + s.substring(startIndex, i + 1));
                }
            } else {
                continue;
            }
            //�ݹ�
            count++;
            backTrace(s, res, path, startIndex + 1, count);
            //����
            count--;
            if (path.length() > 1) {
                path.deleteCharAt(path.length() - 1);
                path.deleteCharAt(path.length() - 1);
            } else {
                path.deleteCharAt(path.length() - 1);
            }*/

            //ֱ����ԭ�ַ�������ӷָ��
            if (isLegal(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //��str�ĺ�?��??������
                count++;
                backTrack(s, res,i + 2, count);// ��?����֮����?��?������ʼλ��Ϊi+2
                count--;// ����
                s = s.substring(0, i + 1) + s.substring(i + 2);// ����ɾ������
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
