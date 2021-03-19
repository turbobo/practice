package com.demo.algorithm.jianzhiOffer;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/17 20:19
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public static void main(String[] args) {  //************************不可以有空格
        String str = "-12 3 4";
        System.out.println(StrToInt(str));
    }



    public static int StrToInt(String str) {
        if(str.length()==0)
            return 0;

        int num;
        int sum = 0;

        //第一位是符号位
        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            for(int i=1;i<str.length();i++){      //有符号位,从第二位开始
                //1.该位数字
                num = str.charAt(i)-'0';
                //不是数字字符
                if(num>9)
                    return 0;
                //2.该位数值
                sum += num*Math.pow(10,str.length()-i-1);     //根据i计算
            }
            if(str.charAt(0)=='-')
                sum *=-1;
        }else{
            for(int i=0;i<str.length();i++){
                //1.该位数字
                num = str.charAt(i)-'0';
                //不是数字字符
                if(num>9)
                    return 0;
                //2.该位数值
                sum += num*Math.pow(10,str.length()-i-1);
            }
        }
        return sum;

    }
}
