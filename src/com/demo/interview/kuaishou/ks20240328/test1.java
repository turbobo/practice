package com.demo.interview.kuaishou.ks20240328;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 全排列
public class test1 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static LinkedList<Integer> path = new LinkedList();

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};
        int[] used = new int[arr.length];
        backTrace(res, path, used, arr);
        System.out.println("Hello World!");
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void backTrace(List<List<Integer>> res, LinkedList<Integer> path, int[] used, int[] arr) {
        // 返回
        if (path.size() == arr.length) {
            res.add(new ArrayList(path));
            return;
        }

        // 横向遍历
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            used[i] = 1;
            path.add(arr[i]);
            // 继续下一层
            backTrace(res, path, used, arr);
            // 
            path.removeLast();
            used[i] = 0;
        }
    }

}