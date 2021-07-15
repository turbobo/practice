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
        //��ʼ����������
        assist = new int[arr.length];

        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        //��ЧУ��
        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        //�ֱ�����
        sort(arr,low,mid);   //midλ��
        sort(arr,mid+1,high);
        //�ϲ�---���߷ֱ�����
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int index = low;

        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){   //�Ƚϵ�ǰ������ָ�벻�� ++
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

        //�������鸴�Ƶ�ԭ�����Ӧλ��
        for (int i = low; i <= high; i++) {
            arr[i] = assist[i];
        }
    }
}

