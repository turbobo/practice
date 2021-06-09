package com.demo.algorithm.test;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/4/21 15:47
 */
public class binarySearch {
    public static void main(String[] args) {
        //��������
        int[] arr = {81,51,88,15,59,20,1,50,66,77,4};
        int[][] arr2 = {{81,51,88},{15,59,20}};
        System.out.println(arr2.length+"-----"+arr2[0].length);
//        �����������������
        Arrays.sort(arr);
        //��ӡ����
        System.out.println(Arrays.toString(arr));
        //��ӡ���ҽ��
        System.out.println(binarySearch_Solution(arr,59));

    }
    public static int binarySearch_Solution(int[]arr,int value){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            //ȡ�м��
            int mid = (low+high)/2;
            if(value==arr[mid]){
                return mid;
            }else if(value<arr[mid]){
                high = mid-1;
            }else if(value>arr[mid]){
                low = mid+1;
            }
        }
        return -1;
    }
}
