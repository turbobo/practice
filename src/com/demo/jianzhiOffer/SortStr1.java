package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 17:16
 * 输入有两行，第一行n
 *
 * 第二行是n个空格隔开的字符串
 *
 * 输入例子1:
 * 5
 * c d a bb e
 *
 * 输出例子1:
 * a bb c d e
 */
public class SortStr1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[n];  //整行
//        while(sc.hasNextLine()){   //不需要一直输入
            str = sc.nextLine().split(" ");
//        }
        Arrays.sort(str);
        for(int i=0;i<n;i++){
            if(i==n-1)
                System.out.print(str[i]);
            else
                System.out.print(str[i]+" ");
        }

/*        Scanner in = new Scanner(System.in);
        String n=in.nextLine();
        String[] str=in.nextLine().split(" ");
        Arrays.sort(str);
        for(int i=0;i<str.length;i++){
            if(i==str.length-1)
                System.out.print(str[i]);
            else
                System.out.print(str[i]+" ");
        }*/


    }
}
