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

    //1.��low��high����
    public static void sort(int[] arr, int low, int high){
        //ָ��У��
        if(low>=high)
            return ;
        //�ҵ��ֽ�ֵpivot
        int pivot = partition(arr,low,high);
        //�������������
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
        //�������������
    }

    //2.��������в�֣�Ŀ���Ƿ���pivotλ�ã�������Ҳ��pivot����Ԫ�طֺ�λ�ã�����������Ԫ�أ����pivot�ŵ�����λ��
    public static int partition(int[] arr, int low, int high){
        //��ʼ������ָ��
        int left=low;
        int right=high+1;  //rightÿ�ζ�Ҫ�ȼ�һ�ٿ�ʼ�ƶ�
        int key=arr[low];
        while(true){
            //1.���������ƶ���ָ�룬ֱ���ȷֽ�ֵС
            while(less(key,arr[--right])){
                if(right==low)  //��ָ���Ѿ�������
                    break;
            }
            //2.���������ƶ���ָ�룬ֱ���ȷֽ�ֵ��
            while(less(arr[++left],key)){
                if(left==high)  //��ָ���Ѿ�������
                    break;
            }
            //����ָ��������û���ҵ�����λ��----�����Ѿ��ֺ���
            if(left>=right){   // *************************************һ��Ҫ���ڵ��ڣ���������  ��ָ����ܻᵽͷhigh
                break;
            }else {  //ǰ���������ҽ���λ���Ѿ��ҵ�
                swap(arr,left,right);
            }
        }
        //��key�Ƶ��ֽ�ֵrightλ��
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
