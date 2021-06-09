package com.demo.jianzhiOffer;

import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/3/31 18:58
 *
 * next()方法在读取内容时，会过滤掉有效字符前面的无效字符，对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，
 *  * next()方法会自动将其过滤掉；只有在读取到有效字符之后，next()方法才将其后的空格键、Tab键或Enter键等视为结束符；
 *  * 所以next()方法不能得到带空格的字符串。
 *
 *  * hasNext()遇到空格结束
 *  * hasNextLine()方法字面上有扫描一整行的意思，它的结束符只能是Enter键，即nextLine()方法返回的是Enter键之前没有被读取的所有字符，
 *  * 它是可以得到带空格的字符串的。
 */
public class A_plus_B_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int sum = 0;
            String[] a = in.nextLine().split(" ");
            for (String s : a) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
