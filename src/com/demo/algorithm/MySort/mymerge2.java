package com.demo.algorithm.MySort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/6/9 17:30
 */
public class mymerge2 {
    private static int[] assist;

    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] arr){
        //初始化辅助数组
        assist = new int[arr.length];

        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        //有效校验
        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        //分别排序
        sort(arr,low,mid);   //mid位置
        sort(arr,mid+1,high);
        //合并---两边分别有序
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int index = low;

        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){   //比较当前，左右指针不用 ++
                assist[index++] = arr[left++];
            }else{
                assist[index++] = arr[right++];
            }
        }
        while(left <= mid){
            assist[index++] = arr[left++];
        }
        while(right <= high) {
            assist[index++] = arr[right++];
        }

        //辅助数组复制到原数组对应位置
        for (int i = low; i <= high; i++) {
            arr[i] = assist[i];
        }
    }
}

