package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/3/29 22:16
 */
public class sortStr {
    public static void main(String[] args){
        print2();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] a = str.split(" ");
            pri(a);
        }
    }

    public static void pri(String[] a){
        Arrays.sort(a);
        StringBuilder sbu = new StringBuilder();
        for(int i=0;i<a.length-1;i++){
            sbu.append(a[i]);
            sbu.append(" ");
        }
        sbu.append(a[a.length-1]);
        System.out.println(sbu);
    }
    public static void print2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for(int i=0; i<temp.length; i++){
                list.add(temp[i]);
            }
            Collections.sort(list);
            for(int i=0; i<list.size(); i++){
                if(i == list.size() - 1){
                    System.out.println(list.get(i));
                }else{
                    System.out.print(list.get(i) + " ");
                }
            }
        }
    }
}
