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
        //��ЧУ��
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    //������������ϲ�,��ʱ���������Ѿ��ֱ�����,�ֱ�����������ʼλ��
    public static void merge(int[] arr, int low, int mid, int high) {
        //��ЧУ��
        if (low >= high)
            return;
        int left = low;
        int right = mid + 1;
        int i = low;
        //�Ƚ�����������
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                assist[i++] = arr[left++];
            } else {
                assist[i++] = arr[right++];
            }
        }
        //����ָ��δ������
        while (left <= mid) {
            assist[i++] = arr[left++];
        }
        while (right <= high) {
            assist[i++] = arr[right++];
        }
        //���Ƶ�ԭ����
        for (int j = low; j <= high; j++) {
            arr[j] = assist[j];
        }
    }

}
