package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/3/31 18:58
 *
 * next()�����ڶ�ȡ����ʱ������˵���Ч�ַ�ǰ�����Ч�ַ�����������Ч�ַ�֮ǰ�����Ŀո����Tab����Enter���Ƚ�������
 *  * next()�������Զ�������˵���ֻ���ڶ�ȡ����Ч�ַ�֮��next()�����Ž����Ŀո����Tab����Enter������Ϊ��������
 *  * ����next()�������ܵõ����ո���ַ�����
 *
 *  * hasNext()�����ո����
 *  * hasNextLine()������������ɨ��һ���е���˼�����Ľ�����ֻ����Enter������nextLine()�������ص���Enter��֮ǰû�б���ȡ�������ַ���
 *  * ���ǿ��Եõ����ո���ַ����ġ�
 */
public class A_plus_B_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int sum = 0;
            String[] a = in.nextLine().split(" ");
            for (String s : a) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
