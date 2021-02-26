package com.demo.algorithm.MySort;


import java.util.Arrays;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/2/25 16:30
 */
public class MyQuick {
    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67};
        QuickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void QuickSort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    //1.从low到high排序
    public static void sort(int[] arr, int low, int high){
        //指针校验
        if(low>=high)
            return ;
        //找到分界值pivot
        int pivot = partition(arr,low,high);
        //左子组继续排序
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
        //右子组继续排序
    }

    //2.对数组进行拆分（目的是返回pivot位置，过程中也将pivot左右元素分好位置），交换左右元素，最后将pivot放到合适位置
    public static int partition(int[] arr, int low, int high){
        //初始化左右指针
        int left=low;
        int right=high+1;  //right每次都要先减一再开始移动
        int key=arr[low];
        while(true){
            //1.从右往左移动右指针，直到比分界值小
            while(less(key,arr[--right])){
                if(right==low)  //右指针已经到最左
                    break;
            }
            //2.从左往右移动左指针，直到比分界值大
            while(less(arr[++left],key)){
                if(left==high)  //右指针已经到最左
                    break;
            }
            //左右指针相遇都没有找到合适位置----两边已经分好了
            if(left>=right){   // *************************************一定要大于等于！！！！！  左指针可能会到头high
                break;
            }else {  //前面两个左右交换位置已经找到
                swap(arr,left,right);
            }
        }
        //把key移到分界值right位置
        swap(arr,low,right);
        return right;
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
