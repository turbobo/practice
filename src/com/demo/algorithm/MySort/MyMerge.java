package com.demo.algorithm.MySort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/25 20:06
 */
public class MyMerge {
    public static int[] assist;   //*******************************

    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        //�����С
        assist = new int[a.length];
        sort(a,0,a.length-1);
    }

    //�ֿ�
    public static void sort(int[] a, int low, int high){
        //�ݹ��������-----����ֻ��һ��������Ƚ�  *********************************
        if(low>=high)
            return;

        //�������Ϊ������
//        int mid = high/2;  //���� low=0ʱ����������
        int mid = low+(high-low)/2;   //********************************ÿ�ε�midλ�����¼���
        //���߷ֱ�����
        sort(a,low,mid);
        sort(a,mid+1,high);

        //�����������߹鲢
        merge(a,low,mid,high);
    }

    //�鲢
//    public static void merge(int[] a, int low, int high){   **********
    public static void merge(int[] a, int low, int mid, int high){
//        int[] assist = new int[a.length];     ����ʼǰ�������飬���Ǻϲ�ʱ*********************************
        //��������ָ��  ��������
        int left = low;
//        int right = high;
        int right = mid+1;  //*********************************
        //���������ָ�룬ÿ��
        int i = low;
        while(left<=mid&&right<=high){  //������û������
            if(less(a[left],a[right]))    //�ݹ���������������Ѿ�����ֻ��Ƚϴ�С���鵱ǰ�ĵ�һ��λ�ü����жϱ���low��high�������С
                assist[i++] = a[left++];
            else
                assist[i++] = a[right++];
        }
        //�����������,ֱ�ӷ�������������
        /*if(left>mid&&high>=right){
            assist[i++] = a[right++];
        }*/
        //ֱ���ж���ָ��λ��
//        if(left<=mid)
         while (left<=mid) {
             assist[i++] = a[left++];
         }

        //������û������
        /*if(right>high&&left<=mid){
            assist[i++] = a[left++];
        }*/


//        if(right<=high)
        while(right<=high) {  //*********************����ѭ��
            assist[i++] = a[right++];
        }

        //�������飬
//        for(int index=low;index<high;index++){
        for(int index=low;index<=high;index++){  //********************index< = high;  highλ��������Ԫ�أ�ҲҪ���ƹ�ȥ
            a[index] = assist[index];
        }
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
