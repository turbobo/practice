package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/5/11 19:24
 *
 * �����������һ����λָ�����ѭ�����ƣ�ROL����
 * �����и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 */
public class LeftRotateString {
    public static void main(String[] args) {
        LeftRotateString_("abcXYZdef",3);
    }

    public static String LeftRotateString_(String str,int n) {
        int length = str.length();
        int k = n%length;
        String right = str.substring(0,k);
        String left = str.substring(k,str.length());
        return left+right;
    }
}
