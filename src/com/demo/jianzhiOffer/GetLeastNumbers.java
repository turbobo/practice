package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/4/11 12:12
 * ����һ�����飬�ҳ�������С��K��������������Ԫ����4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4��
 * ���K>����ĳ��ȣ���ô����һ���յ�����
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67,348,22,31,16,2,2,34};
        //����ת����
        List l = Arrays.asList(a);
        ArrayList list = new ArrayList();
        Collections. addAll(list,a);
//        List<int[]> list = Arrays.asList(a);

        System.out.println("����ת���� "+list);

        //����ת����
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(14);
        arrayList.add(435);
//        System.out.println(arrayList);
        Integer[] b = new Integer[arrayList.size()];
        arrayList.toArray(b);
        System.out.println("����ת���� "+Arrays.toString(b));
//        Arrays.();
//        QuickSort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(GetLeastNumbers_Solution(a,4));


    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //��Ч��У��
        if(k==0 || k>input.length) {
            return new ArrayList<Integer>();
        }
//        QuickSort(input);
//        int[] arr = Arrays.copyOf(input,k);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for(int i: arr){
//            list.add(i);
//        }
//        return list;
        return SelectionSort(input,4);
    }

    public static ArrayList<Integer> SelectionSort(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int low = 0;
        int min = 0;
        for(int i=0;i<k;i++){
            min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
            list.add(arr[i]);
        }
        return list;
    }

    public static void QuickSort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    //1.��low��high����
    public static void sort(int[] arr, int low, int high){
        //ָ��У��
        if(low>=high) {
            return ;
        }
        //�ҵ��ֽ�ֵpivot
        int pivot = partition(arr,low,high);
        //�������������
        sort(arr,low,pivot-1);  //pivot��ȷ��λ�ã�ֻ��Ҫ�����ҽ�������
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
/*            //1.���������ƶ���ָ�룬ֱ���ȷֽ�ֵС
            while(less(key,arr[--right])){
                if(right==low)  //��ָ���Ѿ�������
                    break;
            }
            //2.���������ƶ���ָ�룬ֱ���ȷֽ�ֵ��
            while(less(arr[++left],key)){
                if(left==high)  //��ָ���Ѿ�������
                    break;
            }*/

            while (right>low){
                right--;
                if(arr[right]<key)
                    break;
            }
            while (left<high){
                left++;
                if(arr[left]>key)
                    break;
            }



            //����ָ��������û���ҵ�����λ��----���˱��� �����Ѿ��ֺ���
            if(left>=right){   // *************************************һ��Ҫ���ڵ��ڣ���������  ��ָ����ܻᵽͷhigh
                break;
            }else {  //ǰ���������ҽ���λ���Ѿ��ҵ�
                swap(arr,left,right);
            }//����������ƶ�����ָ��
        }
        //�ѷֽ�ֵarr[low] �Ƶ�rightλ�ã�righ=left������righ<left����ѭ����,����rightԪ�طŵ���С��key��Ԫ�أ�����lowӦ��ȡright��λ�ã�
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
