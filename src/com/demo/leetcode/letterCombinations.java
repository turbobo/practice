package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/25 12:24
 * �绰�������ĸ���
 */
public class letterCombinations {
    public static void main(String[] args) {
        String digits = "234";
//        int digit = digits[0] - '0';
        int i = digits.charAt(0) - '0';
        System.out.println(i);
        System.out.println(letterCombinations("1*3"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if (digits.length() == 0){
            return res;
        }
        String[] letterMap = {
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };
        //ȥ��ת��
        // String[] input = digits.split("");
        backTrack(res,path,digits,0,letterMap);
        return res;
    }

    private static void backTrack(List<String> res, StringBuilder path, String digits, int index, String[] letterMap) {
        //����������digits������--ÿ������ѡһ����ĸ��������digits.length()����ĸ
        if (index == digits.length()){
            res.add(path.toString());
            return;
        }
        //��ǰ��������ֺͶ�Ӧ����ĸ
        // int digit = Integer.parseInt(input[index]);
        // String[] letters = letterMap[digit].split("");
        //�����ϲ�Ϊһ�� --- �ַ��� '0'ȡ��ֵ���ɵõ�����
        String letters = letterMap[digits.charAt(index)-'0'];

        //ÿ�εݹ鶼�ǴӲ�ͬ�ļ��Ͽ�ʼȡ���֣�����i��0��ʼ
        //����forѭ����digits��indexλ�����ֶ�Ӧ��
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if(c == '*' || c == '#' || c == '0'){
                continue;
            }
            //����ǰ���
            path.append(letters.charAt(i));
            //�ݹ�
            backTrack(res,path,digits,index+1,letterMap);
            //����
            path.deleteCharAt(path.length()-1);
        }
    }


    //�� �� �˴� ��ʦ��  ����  ����  �й�ũҵ  ��������
    //����  ������  ������ѧ   ������
    //�Ͽ�  ���
    //ɽ����ѧ
    //�ϴ�  ����
    //����  ����  ͬ��  ��ʦ
    //�ƴ�
    // ���
    // ���  ����
    //����  ������  ����ũ��
    //����  ���
    //�ش�
    //����  ����   �����ƴ�
    //����
    //��ɽ��ѧ  ������


    //���ݴ�ѧ
    //�й������ѧ


}
