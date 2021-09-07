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
        //�ݹ�������������  pivot�Ѿ��ں���λ��
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    //��ȡ�ֽ��
    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        int left = low;
        int right = high + 1;
        while (true) {

            while (arr[++left] < key) {  //��һ��lowλ���ǳ�ʼĬ�Ϸֽ��
                if (left == high)
                    break;
            }
            //�ұ���С�ڷֽ���ֵ�����ھ�һֱ��
            while (arr[--right] > key) {  //��һ��lowλ���ǳ�ʼĬ�Ϸֽ��
                if (right == low)
                    break;
            }
            if (left >= right) {  //����ָ����������δ�ҵ�
                break;
            }else{  //�����ҵ�����λ�ã���Ҫ����
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
