package com.demo.algorithm.MySort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/9/6 20:49
 */
public class MergeSort0906 {
    public static int[] assist;

    public static void main(String[] args) {
        int[] arr = {23, 48, 2, 439, 949};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        assist = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        //有效校验
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    //将两个子数组合并,此时两个数组已经分别有序,分别从两个数组初始位置
    public static void merge(int[] arr, int low, int mid, int high) {
        //有效校验
        if (low >= high)
            return;
        int left = low;
        int right = mid + 1;
        int i = low;
        //比较两个子数组
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                assist[i++] = arr[left++];
            } else {
                assist[i++] = arr[right++];
            }
        }
        //左右指针未遍历完
        while (left <= mid) {
            assist[i++] = arr[left++];
        }
        while (right <= high) {
            assist[i++] = arr[right++];
        }
        //复制到原数组
        for (int j = low; j <= high; j++) {
            arr[j] = assist[j];
        }
    }

}
