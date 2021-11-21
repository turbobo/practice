package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/11/21 14:19
 */
public class minCoverSubString {
    public static void main(String[] args) {

        String s = "ajdis";
        System.out.println((int)s.charAt(2));
        System.out.println(Integer.MAX_VALUE);

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        //ascii����128���ַ�
        int[] need = new int[128];
        //��¼��Ҫ���ַ��ĸ���
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l�ǵ�ǰ��߽磬r�ǵ�ǰ�ұ߽磬size��¼���ڴ�С��count��������ַ�������start����С���Ǵ���ʼ��index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //���������ַ�
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//��Ҫ�ַ�c
                count--;
            }
            need[c]--;//���ұߵ��ַ����봰��
            if (count == 0) {//�������Ѿ����������ַ�
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//�ͷ��ұ��ƶ������ڵ��ַ�
                    l++;//ָ������
                }
                if (r - l + 1 < size) {//��������ʱ����ս��С���ڴ�С��������С���ڿ�ʼ��start
                    size = r - l + 1;
                    start = l;//��¼����Сֵʱ��Ŀ�ʼλ�ã���󷵻ظ��Ǵ�ʱ����õ�
                }
                //l�����ƶ��󴰿ڿ϶����������� ���¿�ʼѭ��
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
