package com.demo.interview.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/23 17:07
 *
 * X�Ǵ�ѧ��У�����ڽ�������  ��У��һ����N����ѧ¥�Ͱ칫¥��������Ҫ�ù��˰���N��������������֤��������¥֮�䶼��һ����������ͨѶ��·��
 * ��֪��������¥֮���ֱ�߾��루��λ��ǧ�ף���Ϊ�˽��ͳɱ���Ҫ������¥֮�䶼��ֱ�߹������ӡ�
 * ���˵ĵ�λ�ɱ�C��֪����λ��X�Ǳ�/ǧ�ף�������������Ҫ����X�ǱҲ��ܱ�֤��������¥֮�䶼�й���ֱ�ӻ��߼��������
 * ע�⣺���1��¥��2��¥������2��¥��3��¥��������1��¥��3��¥�������
 *
 * 3 10
 * 1 2 5
 * 1 3 6
 * 2 3 7
 */
public class test12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        in.nextLine();
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        int[] result = new int[n];
//        //������򳤶�
//        //dp[i][j] ��ʾarr��iλ�õ�jλ�õ�����������
////        for (int i = 0; i < n; i++) {
////            int temp = arr[i];
////            for (int j = i + 1; j < n; j++) {
////                if (arr[j] < temp) {
////                    result[i] += 1;
////                    temp = arr[j];
////                }
////            }
////        }
        int n = in.nextInt();
        int c = in.nextInt();
        int row = n*(n-1)/2;
        int[][] arr = new int[row][3];
        in.nextLine();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
        }
//        Arrays.sort(result);
//        System.out.println(result[result.length - 1] + 1);
    }
}
