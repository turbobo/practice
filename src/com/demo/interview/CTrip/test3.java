package com.demo.interview.CTrip;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/9/9 20:05
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] weight = new int[m];
        int[] value = new int[m];
        int ks = 0;
        for (int i = 0; i < m; i++) {
            String temp = sc.nextLine();
            String[] arr = temp.split(" ");
            map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            weight[i] = Integer.parseInt(arr[0]);
            value[i] = Integer.parseInt(arr[1]);
            result += Integer.parseInt(arr[0]);
        }
        //��̬�滮����
        int[][] arr = new int[m+1][m+1];
//        for (int i = 0; i < ; i++) {
//
//        }
        //�ϴ�1��λ��
        int last = 0;
        //��ǰ1�ĸ���
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 0) {
                d = i - last;
                last = i + 1;
                maxScore(d, map, ks);
            }
        }
    }

    //���鱳������
    public static int maxScore(int d, HashMap map, int ks) {
        //�������ֵ

        Integer min = (Integer) Collections.min(map.keySet());
        Integer max = (Integer) Collections.min(map.keySet());
        if (d < ks) {
            int a = d / min;

        }
        return 0;
    }
}
