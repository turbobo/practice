package com.demo.interview.bytedance;

import com.demo.algorithm.sort.Quick;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/5/27 0:08
 *
 * 第k大的值
 * 快排--修改
 */
public class test1 {
    public static void main(String[] args) {
        int[] arr = {32, 385, 23, 4, 6, 1, 50, 11, 33, 406};
//        int[] arr = {32, 385, 23, 4, 6};
        System.out.println("原数组 = " + Arrays.toString(arr));

//        System.out.println("sort(arr, 4) = " + sort(arr, 4));
        /*System.out.println("sort(arr, 4)排序后     " + Arrays.toString(arr));

//        sort(arr);
        Arrays.sort(arr);
        System.out.println("Arrays.sort(arr)排序后 " + Arrays.toString(arr));*/
        Arrays.copyOf(arr,4);
        sort(arr);
        System.out.println("从大到小排列后 = " + Arrays.toString(arr));

    }

    //从大到小排列
    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int pivot = partition(arr,low,high);
        sort(arr,low,pivot-1);

        sort(arr,pivot+1,high);
    }

    public static int partition(int[] arr, int low, int high){
        //默认第一为分界值
        int init = arr[low];
        int left =low;
        int right = high + 1;
        while(true){
            while(arr[--right] < init){
                if(right == low){
                    break;
                }
            }
            while(arr[++left] > init){
                if(left == high){
                    break;
                }
            }
            if(left < right){
                swap(arr,left,right);
            }else {
                break;
            }
        }
        swap(arr,low,right);
        return right;
    }

    public static void swap ( int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /*public static int sort(int[] arr, int k){
        //有效校验
        if (k == 0 || arr.length == 0) {
            return -1;
        }
        // k-1 下标
        sort(arr,0,arr.length-1,k-1);
        return arr[k-1];
    }

    public static int sort(int[] arr, int low, int high, int k){
        if(low >= high){
            return -1;
        }
        int pivot = partition(arr,low,high);
        if (k == pivot){
            return arr[pivot];
        }else if(k < pivot){
            sort(arr,low,pivot-1,k);
        }else {
            sort(arr,pivot+1,high,k);
        }
        return -1;
    }

    public static int partition(int[] arr, int low, int high){
        //默认第一为分界值
        int init = arr[low];
        int left =low;
        int right = high + 1;
        while(true){
            while(arr[--right] > init){
                if(right == low){
                    break;
                }
            }
            while(arr[++left] < init){
                if(low == high){
                    break;
                }
            }
            if(left < right){
                swap(arr,left,right);
            }else {
                break;
            }
        }
        swap(arr,low,right);
        return right;
    }

    public static void swap ( int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }*/
}
