package com.demo.leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/15 14:53
 *
 * �����������
 *
 * ���������ַ���?text1 ��?text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
 *
 * һ���ַ�����?������?��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 *
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 *
 * ʾ�� 1��
 *
 * ���룺text1 = "abcde", text2 = "ace"
 * �����3
 * ���ͣ�������������� "ace" �����ĳ���Ϊ 3 ��
 *
 */
public class longestCommonSubsequence {
    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("fdsadf", "fslfdaja"));
//        longestCommonSubsequence("faghbc", "afbgch");

        /*
        * "abcbdab", "bdcaba"
        * bcba
        * bcab
        * bdab
        * */
        longestCommonSubsequence2("abcbdab", "bdcaba");

    }
    public static int longestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        //��̬�滮����
        //text1[0,i]��ʾtext1��ǰ i���ַ�
        //text2[0,j]��ʾtext2��ǰ j���ַ�
        //dp[i][j]��ʾ text1��ǰ i���ַ�  ��  text2��ǰ j���ַ�   ���ڹ��������еĸ���
        //i=0  ���� j=0 dp[i][j]=0
        //text1[i] == text2[j] ʱ��dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ��= text2[j] ʱ��һ���ַ�������һ���ַ�����ǰһλ�Ƚϣ�dp[i][j] = max(dp[i][j-1],dp[i-1][j])

        //��¼text1 ����󳤶�ʱ��λ��

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //��ǰ�ַ���ͬʱ��ֻ�迼��text1  text2 ����һλ�Ӵ�����������ϱ�λ��ͬ����
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //��λ�Ƚϣ����ַ���ͬ���ظ������м� 1
                } else {
                    //��ǰ�ַ���ͬʱ������text1ǰһλ�Ӵ���text2�����, text2ǰһλ�Ӵ���text1�������ȡ���ֵ����
                    //�ڶ�ά�����о������λ�ã��ϱ�λ��
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("��̬�滮����: ");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(text1+" �� "+text2+" ����󹫹�������: "+" ����: " + dp[m][n]);
        Long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        /*
        * ��¼��󳤶ȵ�����λ��---ѡ������һ���ַ�����¼����
        * */
        for (int i = m, j = n; i >= 1 && j >= 1; ) {//���Ŵ�ӡ
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //�ַ���������dp����
//                System.out.print(text1.charAt(i - 1) + " ");
                sb.append(text1.charAt(i - 1));
                //������һλ
                i--;
                j--;
            } else {
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        Long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println(sb.reverse().toString());
        System.out.println("*********************************");


       /* //����
        StringBuffer stringBuffer = new StringBuffer(text1);
        String two = stringBuffer.reverse().toString();
        System.out.println(two);*/
        return dp[m][n];

    }

    //��ӡ���������������
    public static int longestCommonSubsequence2(String text1, String text2){
        int m = text1.length(), n = text2.length();
        //��̬�滮����
        //text1[0,i]��ʾtext1��ǰ i���ַ�
        //text2[0,j]��ʾtext2��ǰ j���ַ�
        //dp[i][j]��ʾ text1��ǰ i���ַ�  ��  text2��ǰ j���ַ�   ���ڹ��������еĸ���
        //i=0  ���� j=0 dp[i][j]=0
        //text1[i] == text2[j] ʱ��dp[i][j] = dp[i-1][j-1] + 1
        //text1[i] ��= text2[j] ʱ��һ���ַ�������һ���ַ�����ǰһλ�Ƚϣ�dp[i][j] = max(dp[i][j-1],dp[i-1][j])

        //��¼text1 ����󳤶�ʱ��λ��

        int[][] dp = new int[m + 1][n + 1];
        //��������г���
        int length = 0;
        //���������λ��---text1�е�λ��
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    //��ǰ�ַ���ͬʱ��ֻ�迼��text1  text2 ����һλ�Ӵ�����������ϱ�λ��ͬ����
                    dp[i][j] = dp[i - 1][j - 1] + 1;   //��λ�Ƚϣ����ַ���ͬ���ظ������м� 1
                    //ÿ�μ�¼��ǰ������е�λ�á�����
                    if(length<dp[i][j]){
                        length = dp[i][j];
                        l.clear();   //�����֮ǰ����λ��
                        l.add(i);
                    }else if(length == dp[i][j]){
                        l.add(i);
                    }

                } else {
                    //��ǰ�ַ���ͬʱ������text1ǰһλ�Ӵ���text2�����, text2ǰһλ�Ӵ���text1�������ȡ���ֵ����
                    //�ڶ�ά�����о������λ�ã��ϱ�λ��
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("��̬�滮����: ");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(text1+" �� "+text2+" ����󹫹������г���Ϊ " + dp[m][n] +"����" + "��");

        Long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        /*
         * ��¼��󳤶ȵ�����λ��---ѡ������һ���ַ�����¼����
         * */
        for (int k = 0; k < l.size(); k++) {
            int index = l.get(k);
            for (int i = index, j = n; i >= 1 && j >= 1; ) { //���Ŵ�ӡ
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //�ַ���������dp����
//                System.out.print(text1.charAt(i - 1) + " ");
                    sb.append(text1.charAt(i - 1));
                    //������һλ
                    i--;
                    j--;
                } else {
                    if (dp[i][j - 1] >= dp[i - 1][j]) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            System.out.println(sb.reverse().toString());
            System.out.println();
        }
        /*for (int i = m, j = n; i >= 1 && j >= 1; ) {//���Ŵ�ӡ
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //�ַ���������dp����
//                System.out.print(text1.charAt(i - 1) + " ");
                sb.append(text1.charAt(i - 1));
                //������һλ
                i--;
                j--;
            } else {
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }*/

        Long end = System.nanoTime();
        System.out.println(end - start);

        System.out.println("*********************************");


       /* //����
        StringBuffer stringBuffer = new StringBuffer(text1);
        String two = stringBuffer.reverse().toString();
        System.out.println(two);*/
        return dp[m][n];

    }
}
