package com.demo.algorithm.MySort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/9/6 20:18
 */
public class QuickSort0906 {
    public static void main(String[] args) {
        int[] arr = {23, 48, 2, 439, 949};
        sort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        //递归排序左右子树  pivot已经在合适位置
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    //获取分界点
    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        int left = low;
        int right = high + 1;
        while (true) {

            while (arr[++left] < key) {  //第一个low位置是初始默认分界点
                if (left == high)
                    break;
            }
            //右边找小于分界点的值，大于就一直找
            while (arr[--right] > key) {  //第一个low位置是初始默认分界点
                if (right == low)
                    break;
            }
            if (left >= right) {  //左右指针相遇，则未找到
                break;
            }else{  //本轮找到左右位置，需要交换
                swap(arr,left,right);
            }
        }
        swap(arr, low, right);
        return right;
    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
