package com.demo.interview.NetCase;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/18 19:14
 * 14%
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        String s = arr[0];
        int m = Integer.parseInt(arr[1]);
        //���C
        int[] d = new int[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            d[i] = Math.abs(c1 - c2);
        }
        //���� m�����ֵ
        //��¼���
        int start = 0;
        //��¼��ǰ���������
        int sum = 0;
        int temp = 0;
        for (int i = 0; i <= d.length - m; i++) {
            temp = d[i] + d[i + 1] + d[i = 2];
            if (temp > sum) {
                sum = temp;
                start = i;
            }
        }
        //����
        int result = 0;
        if (start > 0) {
            for (int i = 0; i < start + 1; i++) {
                result += 1;     //����
                result += d[i];  //�ƶ�����һ��
            }
        }
        result += 2 * m;
        for (int i = start + m + 1; i < d.length; i++) {
            result += 1;     //����
            result += d[i];
        }
        result += 1;

        System.out.println(result);
    }
}
