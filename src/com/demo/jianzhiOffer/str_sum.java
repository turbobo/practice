package com.demo.jianzhiOffer;

import java.util.*;
public class str_sum{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            String[] a = str.split(" ");
//            print_sum(a);
//        }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

    public static void print_sum(String[] a){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += Integer.parseInt(a[i]);
        }
        System.out.println(sum);
    }
}