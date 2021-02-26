package com.demo.algorithm.MySort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/25 20:06
 */
public class MyMerge {
    public static int[] assist;   //*******************************

    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        //数组大小
        assist = new int[a.length];
        sort(a,0,a.length-1);
    }

    //分开
    public static void sort(int[] a, int low, int high){
        //递归结束条件-----数组只有一个数无须比较  *********************************
        if(low>=high)
            return;

        //将数组分为两部分
//        int mid = high/2;  //仅仅 low=0时可以这样算
        int mid = low+(high-low)/2;   //********************************每次的mid位置重新计算
        //两边分别排序
        sort(a,low,mid);
        sort(a,mid+1,high);

        //将排序后的两边归并
        merge(a,low,mid,high);
    }

    //归并
//    public static void merge(int[] a, int low, int high){   **********
    public static void merge(int[] a, int low, int mid, int high){
//        int[] assist = new int[a.length];     程序开始前定义数组，不是合并时*********************************
        //左右两个指针  都往右移
        int left = low;
//        int right = high;
        int right = mid+1;  //*********************************
        //辅助数组的指针，每次
        int i = low;
        while(left<=mid&&right<=high){  //左子组没遍历完
            if(less(a[left],a[right]))    //递归后，左右两个子组已经有序，只需比较大小子组当前的第一个位置即可判断本次low到high的总体大小
                assist[i++] = a[left++];
            else
                assist[i++] = a[right++];
        }
        //左子组遍历完,直接放入整个右子组
        /*if(left>mid&&high>=right){
            assist[i++] = a[right++];
        }*/
        //直接判断左指针位置
//        if(left<=mid)
         while (left<=mid) {
             assist[i++] = a[left++];
         }

        //右子组没遍历完
        /*if(right>high&&left<=mid){
            assist[i++] = a[left++];
        }*/


//        if(right<=high)
        while(right<=high) {  //*********************继续循环
            assist[i++] = a[right++];
        }

        //拷贝数组，
//        for(int index=low;index<high;index++){
        for(int index=low;index<=high;index++){  //********************index< = high;  high位置是最后的元素，也要复制过去
            a[index] = assist[index];
        }
    }

    public static boolean less(int a,int b){
        if(a<b)
            return true;
        else
            return  false;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
