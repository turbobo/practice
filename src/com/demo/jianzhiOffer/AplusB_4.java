package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/4/13 16:39
 * �������ݰ������顣
 * ÿ������һ��,ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100), nΪ0��ʱ��������롣
 * ������n��������,����Ҫ��͵�ÿ����������
 */
public class AplusB_4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            int sum = 0;
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                sum += a;
            }
            System.out.println(sum);
        }

    }
}
