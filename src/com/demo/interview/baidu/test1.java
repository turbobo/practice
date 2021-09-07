package com.demo.interview.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/7 18:32
 * ÏñËØ·Å´ó
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
//        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> l1 = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                l1.add(in.nextInt());
            }
            arrayLists.add(l1);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arrayLists.size(); i++) {
            ArrayList<Integer> l2 = new ArrayList<Integer>();
            ArrayList<Integer> temp = arrayLists.get(i);
            for (Integer te : temp) {
                for (int j = 0; j < K; j++) {
                    l2.add(te);
                }
            }

            for (int j = 0; j < K; j++) {
                result.add(l2);
            }
        }
        int rows = result.size();
        int cols = result.get(0).size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
