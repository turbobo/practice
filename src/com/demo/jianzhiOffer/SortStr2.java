package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/13 17:48
 * <p>
 * ��������1:  һֱ����
 * a c bb
 * f dddd
 * nowcoder
 * <p>
 * �������1:
 * a bb c
 * dddd f
 * nowcoder
 */
public class SortStr2 {
    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
////        while(sc.hasNextLine()){   //����Ҫһֱ����
//            String[] str = sc.nextLine().split(" ");
////        }
//            Arrays.sort(str);
//            for(int i=0;i<str.length;i++){
//                if(i==str.length-1)
//                    System.out.print(str[i]+"\n");
//                else
//                    System.out.print(str[i]+" ");
//            }
//        }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {    //�м�������Ͳ������
            String[] arr = sc.nextLine().split(" ");
            Arrays.sort(arr);
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}
