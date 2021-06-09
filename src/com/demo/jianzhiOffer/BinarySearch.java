package com.demo.jianzhiOffer;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/22 18:44
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,56,65,78};
        int[] a =Arrays.copyOfRange(arr,1,1);
        System.out.println(binarySearch(arr,78,0,arr.length-1));
    }

    public static int binarySearch(int[] arr, int key, int low, int high){
        //安全性校验
        if(key<arr[low]||key>arr[high]||low>high)
            return -1;
        else if(low==high){
            if(arr[low]==key){
                return low;
            }
            else
                return -1;
        }
//         int low = 0;
//         int high = arr.length-1;
//        int mid = low+(high-low)/2;
        int mid = (low+high)/2;


        if(key<arr[mid])
            return binarySearch(arr,key,low,mid-1);
        else if(key==arr[mid])
            return mid;
        else
            return binarySearch(arr,key,mid+1,high);
//        return -1;
    }

    //非递归
    public static int binarySearch2(int[] arr, int key, int low, int high){
//        int low = 0;
//        int high = arr.length - 1;
        int middle = 0;			//定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }
}
