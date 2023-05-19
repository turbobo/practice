package com.demo.leetcode.hashset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangbo82
 * @Date: 2022��12��16�� 9:51
 */
public class isIsomorphic {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println("isIsomorphic(s,t) = " + isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //�ù�ϣ���¼
        //�����漰�������ַ������������Ҳ��ü�¼�±꣬����������
        //�����ַ���128��
        int[] arr = new int[128];
        Arrays.fill(arr,-1);
        //ͬʱ���������ַ�����ƥ��ÿһ��λ��
        for (int i=0;i<s.length();i++) {
            //ͬʱ�ж� s t��ǰλ�õ��ַ��Ƿ���������
            if (arr[s.charAt(i)] == -1 && arr[t.charAt(i)] == -1) {
                //ͬʱ�����ߵ�ӳ���������
                arr[s.charAt(i)] = t.charAt(i);
                arr[t.charAt(i)] = s.charAt(i);
            } else {
                if (arr[s.charAt(i)] != t.charAt(i) || arr[t.charAt(i)] != s.charAt(i)) {
                    return false;
                }
            }
        }


       /* for (int i=0;i<s.length();i++) {
            if (arr[s.charAt(i)] == -1) {
                if (arr[t.charAt(i)] == -1) {
                    arr[s.charAt(i)] = t.charAt(i);
                    arr[t.charAt(i)] = s.charAt(i);
                } else {
                    if (arr[t.charAt(i)] != s.charAt(i)) {
                        return false;
                    }
                }

            } else {
                if (arr[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }*/



            //����ӳ��
//            Map<Character,Character> map = new HashMap();
//            for (int i=0;i<s.length();i++) {
//                //s��ǰλ����map��û��ӳ��
//                if (map.get(s.charAt(i)) == null) {
//                    if (map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
//                        return false;
//                    }
//                    map.put(s.charAt(i),t.charAt(i));
//                    //��ͬ�ַ�����ӳ��ͬһ�ַ�
////                    if (map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
////                        return false;
////                    }
//                } else {
//                    //��ǰ��Ϊ�գ��ж�ӳ���Ƿ��֮ǰһ��,��ͬһ���ַ�ֻ��ӳ��һ���ַ�
//                    if (map.get(s.charAt(i)) != t.charAt(i)) {
//                        return false;
//                    }
//
//
//
//                }
//            }



        return true;
    }
}
