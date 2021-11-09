package com.demo.interview.CTrip1108;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/11/8 19:57
 * ��ϵ��  --  ���
 * ���Ž���ʱ��С����Ϊ�鳤��Ҫ����Ա�ֳɼ���С�顣
 * ��Щ��Ա֮���ϵ��̫�ã�Ϊ�˲���������ì��С�����뽫���Ƿֵ���ͬ�����С�
 * Ϊ�˷������С��ϣ���ֳ������龡�����١�С����֪��Ϊ�˲�����ì�ܣ�������Ҫ�ֳ����ٸ��飿
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[m][2];
        in.nextLine();
        for (int i = 0; i < m; i++) {
            int p = in.nextInt();
            int q = in.nextInt();
            matrix[p - 1][q - 1] = 1;
            in.nextLine();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(group(list, matrix));
    }

    public static int group(ArrayList<Integer> list, int[][] matrix) {
        int n = matrix.length;
        int res = n;
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] == 1) {
                    if (findConflix(list, i) != findConflix(list, j)) {
                        res--;
                        list.set(findConflix(list, i), findConflix(list, j));
                    }
                }
            }
        }
        return res;
    }

    //�ҳ���ͻ
    public static int findConflix(ArrayList<Integer> list, int x) {
        if (x != list.get(x)) {
            list.set(x, findConflix(list, list.get(x)));
        }
        return list.get(x);
    }
}
