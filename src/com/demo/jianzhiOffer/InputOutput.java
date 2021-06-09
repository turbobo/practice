package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/3/29 21:41
 *
 * next()方法在读取内容时，会过滤掉有效字符前面的无效字符，对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，
 * next()方法会自动将其过滤掉；只有在读取到有效字符之后，next()方法才将其后的空格键、Tab键或Enter键等视为结束符；
 * 所以next()方法不能得到带空格的字符串。
 *
 * nextLine()方法字面上有扫描一整行的意思，它的结束符只能是Enter键，即nextLine()方法返回的是Enter键之前没有被读取的所有字符，
 * 它是可以得到带空格的字符串的。
 */
public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int a1 = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a1+b);
        }


//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            String [] ch=s.split(" ");
//            int sum=0;
//            for(int i=0;i<ch.length;i++){
//                sum+=Integer.parseInt(ch[i]);
//            }
//            System.out.println(sum);
//        }
//
//        String s=sc.nextLine();
//        String[] ss=s.split(" ");
//        Arrays.sort(ss);
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<ss.length-1;i++){
//            sb.append(ss[i]);
//            sb.append(" ");
//        }
//        sb.append(ss[ss.length-1]);
//        System.out.println(sb);

        int n = sc.nextInt();
        String[] a = new String[n];
        for(int j=0;j<n;j++){
            a[j] = sc.next();
        }

        Arrays.sort(a);
        StringBuilder sbu = new StringBuilder();
        for(int i=0;i<a.length-1;i++){
            sbu.append(a[i]);
            sbu.append(" ");
        }
        sbu.append(a[a.length-1]);
        System.out.println(sbu);



        //用集合存储字符串，然后输出
//        ArrayList<String> list = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=0; i<n; i++){
//            list.add(sc.next());
//        }
//        Collections.sort(list);
//        for(int i=0; i<n; i++){
//            if(i == n-1){
//                System.out.print(list.get(i));
//            }else{
//                System.out.print(list.get(i) + " ");
//            }
//        }


    }
}
