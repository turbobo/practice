package com.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Author Jusven
 * @Date 2021/5/14 16:08
 * ����ظ��Ӵ�
 *
 * �Ӵ��������в�ͬ���ִ������ַ����������
 *
����һ���ַ����������ҳ����в������ظ��ַ���  �ĳ��ȡ�
ʾ�� 1:

����: s = "abcabcbb"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        int d = 'D';
        char g = 122;
        Stack<Integer> stack1 = new Stack<>();


        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
    }

    //�� map����
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length()==0)
            return 0;
        //����ַ���λ��
        HashMap<Character, Integer> map = new HashMap<>();

        int index = s.charAt(1);
        int i = 0;
        int length = 0;
        while(i<s.length()){
            for(;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    //���ظ����ַ��ĺ�һ��λ�����¿�ʼ
                    i = map.get(s.charAt(i))+1;
                    break;
                }else{
                    map.put(s.charAt(i),i);
                }
            }
//            if(length<map.size())
//                length = map.size();
            length = Math.max(length,map.size());

            //���֮ǰ������
            map.clear();
        }
        return length;
    }

    //��������
    public static int lengthOfLongestSubstring3(String s) {
        if(s.length()==0)
            return 0;
        //��¼����߽�
        int left = 0;
        //��¼�����
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);  //�ַ��ϴγ���λ�õĺ�һ��λ��
            }
            //����λ��Ҳ��Ҫ��¼
            map.put(s.charAt(i),i);
            //��ǰ������¼��㣬���ظ��ַ���������Ҫ�ų������ַ��ϴγ���λ�õĺ�һ��λ��left��ʼ
            length = Math.max(length,i-left+1);
        }
        return length;
    }

}
