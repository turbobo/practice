package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/13 17:48
 *
 * 输入例子1:  一直输入
 * a c bb
 * f dddd
 * nowcoder
 *
 * 输出例子1:
 * a bb c
 * dddd f
 * nowcoder
 */
public class SortStr2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
//        while(sc.hasNextLine()){   //不需要一直输入
            String[] str = sc.nextLine().split(" ");
//        }
            Arrays.sort(str);
            for(int i=0;i<str.length;i++){
                if(i==str.length-1)
                    System.out.print(str[i]+"\n");
                else
                    System.out.print(str[i]+" ");
            }
        }
    }
}
