package com.demo.interview.CTrip;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/9 18:59
 * ● cd s: s为一个目录名，表示从当前工作目录的路径进入名为s的目录。
 * 特别地，"cd .."(即s=="..")表示返回上一级目录，若当前已为根目录，则无视该次操作。
 * 数据保证若s不为".."，则一定为小写字母组成的长度不超过10的字符串。
 * <p>
 * ● pwd: 表示查看当前工作目录的路径，你需要输出这个路径。
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = "\\";
        System.out.println(str.length());
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            if ("pwd".equals(temp)) {
                System.out.println(str);
            } else {
                String[] arr = temp.split(" ");
                if ("..".equals(arr[1])) {
                    if (str.length() == 0 || str.length() == 1) {
                        continue;
                    }
                    else if (str.length() == 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    else {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    if (str.length() == 1) {
                        str += arr[1];
                    } else {
                        str += "\\" + arr[1];
                    }
                }
            }
        }
//        String s = "abcde";
//        System.out.println(s.substring(0, s.length() - 1));
    }
}
