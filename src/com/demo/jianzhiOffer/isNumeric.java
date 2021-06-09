package com.demo.jianzhiOffer;

import java.math.BigDecimal;

/**
 * @Author Jusven
 * @Date 2021/5/25 15:05
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。  -1E-16 = -1乘10的-16次方
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class isNumeric {
    public static void main(String[] args) {
        String str = "-1e16";
        Double ans = Double.parseDouble(str);

        BigDecimal bigDecimal = new BigDecimal((float)1 / 5 );
        BigDecimal bigDecimal2 = new BigDecimal((float)1 / Math.pow(10,6) );
        System.out.println("ans = " + ans);
        System.out.println("bigDecimal = " + bigDecimal);
        System.out.println("bigDecimal2 = " + bigDecimal2);

        Integer in1 = new Integer(2);
        Integer in2 = new Integer(2);
        System.out.println(in1==in2);
        System.out.println(in1.equals(in2));

        String str1 = new String("ui");
        String str2 = new String("ui");
        System.out.println("str1==str2 = " + (str1 == str2));
        System.out.println("str1.equals(str2) = " + str1.equals(str2));

        Float f1 = new Float(1.2);
        Float f2 = new Float(1.2);
        System.out.println("f1 == f2"+ (f1 == f2));
        System.out.println("f1.equals(f2) " + f1.equals(f2));

    }
}
