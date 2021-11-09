package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/11/4 21:51
 */
public class mySqrt {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abcd");
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
        System.out.println(Math.exp(1));
        int x = 8;
        System.out.println("Math.log(8) = " + Math.log(8));
        System.out.println(Math.pow(Math.exp(1), 2.0794415416798357));
        System.out.println(Math.exp(0.5 * Math.log(x)));
        System.out.println(Math.sqrt(x));
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        //特殊情况
        if(x==1){
            return x;
        }
        //找到最后一个 平方小于8 的数
        //从x的一半开始，往小数找
        long half = x/2;
        long left = 1;
        long right = x;
        while(left < right){
            long mid = (left + right)/2;
            if (mid*mid > x){
                right = mid;
            }else if(mid*mid == x){
                return (int)mid;
            }else {
                if((mid+1)*(mid+1)>x){
                    return (int)mid;
                }else{
                    left = mid;
                }
            }
        }
        return 0;
    }
}
