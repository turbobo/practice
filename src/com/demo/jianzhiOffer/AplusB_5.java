package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 16:48
 * 输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
 * 接下来t行, 每行一组数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 *
 * 输入例子1:
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 *
 * 输出例子1:
 * 10
 * 15
 */
public class AplusB_5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int j=0;j<m;j++){
//            while(sc.hasNext()){    //有键盘输入就不会结束
                int n = sc.nextInt();
                int sum = 0;
                for(int i=0;i<n;i++){
                    int a = sc.nextInt();
                    sum += a;
                }
                System.out.println(sum);
//            }
        }

       /* Scanner scanner =new Scanner(System.in);
        int time=scanner.nextInt();
        for(int i=0;i<time;i++){
            int num =scanner.nextInt();
            int total=0;
            for(int j=0;j<num;j++){
                total+=scanner.nextInt();
            }
            System.out.println(total);
        }*/

    }
}
