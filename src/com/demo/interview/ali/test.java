package com.demo.interview.ali;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/5/14 19:41
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
