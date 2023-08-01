package com.demo.interview.interview2023.kuaishou0801;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2023/8/1 18:59
 * �û���ظ����Ӵ�
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(getMaxSubString("ABDFAKED"));
    }
    public static String getMaxSubString(String str) {
        if (str.length() == 0) {
            return "";
        }
        int left  = 0;
        int right  = 0;
        int l  = 0;
        int max = 0;
        Set set = new HashSet<Character>();
        while (left < str.length()) {
            // ÿ���Ȱ�leftλ���ַ��ȷ���set
            set.add(str.charAt(left));
            right = left+1;
            while (right < str.length()) {
                Character c = str.charAt(right);
                if(!set.contains(c)) {
                    set.add(c);
                    // left = 0  right=1   ����Ϊ2����1 ��������������������������������������������������������
                    if (max < (right-left+1)) {
                        l = left;
                    }
                    max = Math.max(max, right-left+1);
                    right++;
                } else {
                    break;
                }

            }
            set.clear();
            left++;
        }
        if (max == 0) {
            return "";
        } else {
            // ���������󳤶ȼ��ɣ������ټ�1����Ϊlλ���Ѿ�����һ�����ȣ�substring�ұ��ǿ����䣬����Ǳ����� [)
            return str.substring(l, l+max);
        }
    }
}
