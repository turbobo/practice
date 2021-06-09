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
        //特殊情况
//         if(n==0)
//             return 0;
//         //一、减1之后再和原值与运算
//         int count = 0;
//         do{
//             count++;
//             //减1之后再 和原值与运算
//             n = n & (n-1);
//         }while(n!=0);
//         return count;

        //直接转为二进制
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
