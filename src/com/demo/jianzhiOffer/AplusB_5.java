package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 16:48
 * ����ĵ�һ�а���һ��������t(1 <= t <= 100), ��ʾ����������
 * ������t��, ÿ��һ�����ݡ�
 * ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100)��
 * ������n��������, ����Ҫ��͵�ÿ����������
 *
 * ��������1:
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 *
 * �������1:
 * 10
 * 15
 */
public class AplusB_5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int j=0;j<m;j++){
//            while(sc.hasNext()){    //�м�������Ͳ������
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
