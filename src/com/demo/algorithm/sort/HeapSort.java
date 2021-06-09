package com.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/29 17:51
 *
 * ������
 * �ȹ������ѵĽṹ��Ȼ���ٵ����Ϳ��Եõ���������
 * �ȹ���С���ѵĽṹ��Ȼ���ٵ����Ϳ��Եõ���������
 *
 * ��ʱ���Ǵ����һ����Ҷ�ӽ�㿪ʼ��Ҷ�����Ȼ���õ�����
 * ��һ����Ҷ�ӽ�� arr.length/2-1=5/2-1=1��Ҳ���������6��㣩��
 * �������ң�  �� �� �� ��   ���е���
 */
public class HeapSort {
    public static void main(String[] args) {
        int a = 3;
        int b = 45;
        System.out.println("\"����ǰ\" = " + "����ǰ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("\"������\" = " + "������");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int[] arr = {4,6,8,5,9};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        Integer[] arr2 = {4,6,8,5,9};
        List<Integer> resultList = new ArrayList<>(arr2.length);
        Collections.addAll(resultList,arr2);
        System.out.println("resultList = " + resultList);
    }

    public static void sort(int[] arr){
        //1.�����󶥶�
        for(int i=arr.length/2-1;i>=0;i--){
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr,i,arr.length);
        }
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ����   ��ǰ   ĩβԪ�ؽ��н���
            adjustHeap(arr,0,j);//���¶Զѽ��е���
        }

    }


    /**
     * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//��ȡ����ǰԪ��i
        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if(k+1<length && arr[k]<arr[k+1]){  //������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;   //k�Ǵ���Ǹ����λ��
            }
            if(arr[k] >temp){  //����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//��tempֵ�ŵ����յ�λ��
    }

    /**
     * ����Ԫ��
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
