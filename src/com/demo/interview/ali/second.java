package com.demo.interview.ali;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author Jusven
 * @Date 2021/5/14 19:09
 *
 * 1. 零钱兑换 II
 *
 * 2.
 */
public class second {
    public static void main(String[] args) {
   /*     Scanner sc = new Scanner(System.in);
//        int n = 0;
////        int m = 0;
//        for(int i = 0; i < 1; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
//        }
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //指令
        int o1 = 0;
        int o2 = 0;
        for (int i = 0; i < m; i++) {
            o1 = sc.nextInt();
            o2 = sc.nextInt();
            sort(arr,o1,o2);
        }*/
//        System.out.println(arr);
        Integer[] dd = {3,2,1,5,4};
        sort(dd,1,2);
        for (int k:dd) {
            System.out.print(k+" ");
        }


    }
    public static void sort(Integer[] arr, int o1, int o2){
        Arrays.sort(arr, 0, o2);

//        Comparator<Integer> comp = Collections.reverseOrder();

        //arr是封装类数组时就可以指定范围进行逆序排序
        Arrays.sort(arr, 0, 2, Collections.reverseOrder());
        if(o1==-1){
            Integer[] temp = Arrays.copyOfRange(arr, 0,o2);
            int j = o2-1;
            for (int i = 0; i < o2; i++) {
                arr[i] = temp[j--];
            }
        }
    }
}
