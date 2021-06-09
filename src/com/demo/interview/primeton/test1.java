package com.demo.interview.primeton;

/**
 * @Author Jusven
 * @Date 2021/5/23 16:13
 */
public class test1 {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 1; i <=9;  i++) {
            for (int j = i; j <= 9; j++) {  //每次从i 开始
                result = i*j;
                System.out.print(i+"*"+j+"="+result+" ");
            }
            System.out.println();
        }
    }
}
