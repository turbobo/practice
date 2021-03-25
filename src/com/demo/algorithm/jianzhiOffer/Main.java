package com.demo.algorithm.jianzhiOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
//         SimilarValue(5.5);
//        Scanner in = new Scanner(System.in);
////        double d = in.nextDouble();
////        System.out.println(SimilarValue(d));
//
//        //将输入的视为字符串
//        String s = in.nextLine();
        System.out.println(SimilarValue2("5.5"));
    }
     public static int SimilarValue(double val){
         double sum = val + 0.5;
         double val_int = (double)((int)val+1);
         if(sum<val_int)
             return (int) val;
         else
             return (int) val_int;
     }

    public static int SimilarValue2(String val) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] a = s.split(".");

//        String[] a = val.split(".");
        int first = Integer.parseInt(a[0]);
        int second =  Integer.parseInt(a[1]);
        if(second>=5)
            return first+1;
        else
            return first;
    }
}