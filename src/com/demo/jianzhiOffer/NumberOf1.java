package com.demo.jianzhiOffer;

/**
 * @Author Jusven
 * @Date 2021/4/15 12:02
 */
public class NumberOf1 {
    public static void main(String[] args) {
        int n = 13;
        NumberOf1(n);

    }

    public static int NumberOf1(int n) {
        //�������
//         if(n==0)
//             return 0;
//         //һ����1֮���ٺ�ԭֵ������
//         int count = 0;
//         do{
//             count++;
//             //��1֮���� ��ԭֵ������
//             n = n & (n-1);
//         }while(n!=0);
//         return count;

        //ֱ��תΪ������
        String s=Integer.toBinaryString(n);
        String[] split=s.split("");
        int a=0;
        for(int i = 0; i < split.length; i++) {
            if (split[i].equals("1"))
            {
                a++;
            }
        }
        return a;
    }
}
