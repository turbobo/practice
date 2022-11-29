package com.demo.leetcode.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangbo82
 * @Date: 2022��11��19�� 13:55
 * <p>
 * ���������ַ���?s?�� p���ҵ�?s?������?p?��?��λ��?���Ӵ���������Щ�Ӵ�����ʼ�����������Ǵ������˳��
 * <p>
 * ��λ�� ָ����ͬ��ĸ�������γɵ��ַ�����������ͬ���ַ�������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class findAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "bac"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }


        //һ������hashset˼·
        // int[] recordS = new int[26];
        // int[] recordP = new int[26];

        // for (int i = 0; i < p.length(); i++) {
        //     recordP[p.charAt(i) - 'a']++;
        // }
        // //����¼����תΪ�ַ���
        // String recordP_str = Arrays.toString(recordP);

        // //������Сд��ĸ
        // int lengthP = p.length();
        // //�ִ���ʼָ��
        // int j = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     recordS[s.charAt(i) - 'a']++;
        //     if (i >= lengthP - 1) {
        //         String recordS_str = Arrays.toString(recordS);
        //         if (recordS_str.equals(recordP_str)) {
        //             res.add(i - lengthP + 1);
        //         }
        //         //���������Ƿ���ȣ���Ҫȥ����ǰ��һ��λ�õ�Ԫ��,��Ϊp���ȹ̶���s�������������������
        //         recordS[s.charAt(i - lengthP + 1) - 'a']--;

        //     }
        // }


        //��������Сд��ĸ ���ַ���תΪ������תΪ�ַ�������  ---  ����ʱ������
        // char[] arrayP = p.toCharArray();
        // Arrays.sort(arrayP);
        // String strP = Arrays.toString(arrayP);
        // int lengthP = p.length();
        // for (int i = 0; i < s.length(); i++) {
        //     if (i >= lengthP - 1) {
        //         String substring = s.substring(i - lengthP + 1, i + 1);
        //         char[] arrS = substring.toCharArray();
        //         Arrays.sort(arrS);
        //         String strS = Arrays.toString(arrS);
        //         if (strP.equals(strS)) {
        //             res.add(i - lengthP + 1);
        //         }
        //     }
        // }


        //������������

        int[] recordS = new int[26];
        int[] recordP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            recordP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            recordS[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                if (Arrays.equals(recordS, recordP)) {
                    res.add(p.length() - 1);
                }
                recordS[s.charAt(i - p.length() + 1) - 'a']--;
            }
        }

//        if (Arrays.equals(recordS, recordP)) {
//            res.add(0);
//        }


        //����Ҫ��s ͳ�Ƶ�ͬʱ�ſ����жϣ������ȡ���Ǹ��ַ����ܸ���
//        for (int i = 0; i < s.length() - p.length() + 1; i++) {
//            int[] temp = Arrays.copyOfRange(recordS,i,i+p.length());
//            if (Arrays.equals(temp, recordP)) {
//                res.add(i);
//            }
//
//        }


        return res;
    }
}
