package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 17:57
 */
public class OutputLongSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){   //牛客不通过
            Long a = sc.nextLong();
            Long b = sc.nextLong();
            System.out.println(a+b);
        }

/*        String[] str = sc.nextLine().split(" ");
        Long sum = 0l;
        for(int i=0;i<str.length;i++){
            sum += Long.parseLong(str[i]);
        }
        System.out.println(sum);*/
    }
}
