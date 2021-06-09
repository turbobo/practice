package com.demo.interview.EA;

import com.demo.jianzhiOffer.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/5/23 21:07
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int j1 = sc.nextInt();
            int j2 = sc.nextInt();
            map.put(j1,j2);
        }

        int m = sc.nextInt();
        boolean[] result = new boolean[m];
        for(int i = 0; i < m; i++) {
            int j1 = sc.nextInt();
            int j2 = sc.nextInt();
            if(map.containsKey(j1)){
                if(map.get(j1) == j2)
                    result[i] = true;
                else
                    result[i] = false;
            }else {
                result[i] = false;
            }
        }

        System.out.print("[");
        for (int i = 0; i < m; i++) {
            if(i!=m-1)
                System.out.print(result[i]+",");
            else
                System.out.print(result[i]);

        }
        System.out.print("]");
    }


}
