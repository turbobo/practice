package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/3/29 21:41
 *
 * next()�����ڶ�ȡ����ʱ������˵���Ч�ַ�ǰ�����Ч�ַ�����������Ч�ַ�֮ǰ�����Ŀո����Tab����Enter���Ƚ�������
 * next()�������Զ�������˵���ֻ���ڶ�ȡ����Ч�ַ�֮��next()�����Ž����Ŀո����Tab����Enter������Ϊ��������
 * ����next()�������ܵõ����ո���ַ�����
 *
 * nextLine()������������ɨ��һ���е���˼�����Ľ�����ֻ����Enter������nextLine()�������ص���Enter��֮ǰû�б���ȡ�������ַ���
 * ���ǿ��Եõ����ո���ַ����ġ�
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



        //�ü��ϴ洢�ַ�����Ȼ�����
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
