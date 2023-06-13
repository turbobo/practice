package com.demo.interview.ali.ali1008;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/10/8 20:45
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int T = in.nextInt();
        in.nextLine();
        char[][] temp = new char[H][W];
        String[] arr = new String[H];
        for (int i = 0; i < H; i++) {
            arr[i] = in.nextLine();
        }
        System.out.println(Arrays.toString(arr));
    }
}
