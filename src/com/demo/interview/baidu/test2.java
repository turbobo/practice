package com.demo.interview.baidu;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/7 20:03
 */
public class test2 {
    public static void main(String[] args) {
//        String sss = "asdf";
//        System.out.println(sss.substring(1, sss.length()));
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = in.nextLine();
        }
        List<int[]> res = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            String s = arr[index];
            int num = Integer.parseInt(arr[index]);
            String[] a = s.split("");
            int[] int_arr = new int[a.length];
            int sub = 0;
            int plus = 0;
            String temp = "";
            for (int i = 0; i < a.length; i++) {
                plus = Integer.parseInt(a[i]);
//                if (-1 == plus) {
//                    plus = 9;
//                }
                if (isPerfectNum(plus)) {
//                    plus = Integer.parseInt(s.valueOf(i)) + sub;
//                    sub = 0;
                } else if (plus > 3) {
                    int_arr[i] = 3;
//                    sub = 0;
                } else {  //为0的情况
                    temp = temp.substring(i,temp.length());
                    int_arr[i+1] = Integer.parseInt(a[i+1])-1;
//                    sub = -1;
//                    temp = 9+temp;
                }
            }
            res.add(int_arr);
        }
        for (int[] intt: res) {
            for (int i = 0; i < intt.length; i++) {
                System.out.print(intt[i]);
            }
            System.out.println();
        }
    }

    public static boolean isPerfectNum(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        return false;
    }
}
