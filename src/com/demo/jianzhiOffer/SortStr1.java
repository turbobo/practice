package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 17:16
 * ���������У���һ��n
 *
 * �ڶ�����n���ո�������ַ���
 *
 * ��������1:
 * 5
 * c d a bb e
 *
 * �������1:
 * a bb c d e
 */
public class SortStr1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[n];  //����
//        while(sc.hasNextLine()){   //����Ҫһֱ����
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
