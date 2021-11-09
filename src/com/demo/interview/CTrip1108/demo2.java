package com.demo.interview.CTrip1108;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/11/8 19:57
 * 关系对  --  并差集
 * 在团建的时候，小美作为组长需要将组员分成几个小组。
 * 有些组员之间关系不太好，为了不让他们闹矛盾小美必须将他们分到不同的组中。
 * 为了方便管理，小美希望分出来的组尽可能少。小美想知道为了不产生矛盾，至少需要分出多少个组？
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

    //找出冲突
    public static int findConflix(ArrayList<Integer> list, int x) {
        if (x != list.get(x)) {
            list.set(x, findConflix(list, list.get(x)));
        }
        return list.get(x);
    }
}
