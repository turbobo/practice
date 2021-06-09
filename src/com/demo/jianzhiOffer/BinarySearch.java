package com.demo.jianzhiOffer;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/22 18:44
 * ���ֲ���
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,56,65,78};
        int[] a =Arrays.copyOfRange(arr,1,1);
        System.out.println(binarySearch(arr,78,0,arr.length-1));
    }

    public static int binarySearch(int[] arr, int key, int low, int high){
        //��ȫ��У��
        if(key<arr[low]||key>arr[high]||low>high)
            return -1;
        else if(low==high){
            if(arr[low]==key){
                return low;
            }
            else
                return -1;
        }
//         int low = 0;
//         int high = arr.length-1;
//        int mid = low+(high-low)/2;
        int mid = (low+high)/2;


        if(key<arr[mid])
            return binarySearch(arr,key,low,mid-1);
        else if(key==arr[mid])
            return mid;
        else
            return binarySearch(arr,key,mid+1,high);
//        return -1;
    }

    //�ǵݹ�
    public static int binarySearch2(int[] arr, int key, int low, int high){
//        int low = 0;
//        int high = arr.length - 1;
        int middle = 0;			//����middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //�ȹؼ��ִ���ؼ�����������
                high = middle - 1;
            }else if(arr[middle] < key){
                //�ȹؼ���С��ؼ�����������
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return -1;		//�����Ȼû���ҵ����򷵻�-1
    }
}
