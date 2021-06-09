package com.demo.algorithm.test;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/4/21 15:47
 */
public class binarySearch {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {81,51,88,15,59,20,1,50,66,77,4};
        int[][] arr2 = {{81,51,88},{15,59,20}};
        System.out.println(arr2.length+"-----"+arr2[0].length);
//        对数组进行升序排序
        Arrays.sort(arr);
        //打印数组
        System.out.println(Arrays.toString(arr));
        //打印查找结果
        System.out.println(binarySearch_Solution(arr,59));

    }
    public static int binarySearch_Solution(int[]arr,int value){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            //取中间点
            int mid = (low+high)/2;
            if(value==arr[mid]){
                return mid;
            }else if(value<arr[mid]){
                high = mid-1;
            }else if(value>arr[mid]){
                low = mid+1;
            }
        }
        return -1;
    }
}
