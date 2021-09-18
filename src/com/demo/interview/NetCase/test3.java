package com.demo.interview.NetCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/9/18 20:18
 * 18%
 */
public class test3 {
    public static void main(String[] args) {
        System.out.println("ef---"+Integer.toBinaryString(46));
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        String s1 = Integer.toBinaryString(s);
        int res = -1;

        if (s==1){
            res = 1;
        }else{
            for(int j=0 ; j< s1.length(); j++) {
                if ("1".equals(s1.indexOf(j))){
                    res++;
                }
            }
        }


//        System.out.println(res);
//
//        List<Integer> l = new ArrayList<Integer>();
//        while (Math.pow(2, i) < s) {
//            l.add((int) Math.pow(2, i));
//            i++;
//        }
//        int index = 0;
//        int result = -1;
//        if (i == 0) {
//            result = 1;
//        } else {
//            int pre = s - (int) Math.pow(2,i-1);
//            int post = (int) Math.pow(2,i) - s;
//            if (pre < post){
//                index = pre;
//            }else{
//                index = post;
//            }
//            result = 0;
//            if (Math.pow(2,index)<s){
//                int d = (int) (s - Math.pow(2,index));
//                if (d%2==0){
////                    Integer.toBinaryString()
//                }
//            }else{
//
//            }
//
//
//        }
//
//        System.out.println();
    }

    public void help(ArrayList<Integer> l, int n){
        if (n == 0){
            return;
        }
    }
}
