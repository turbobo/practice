package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/4/11 12:12
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67,348,22,31,16,2,2,34};
        //数组转集合
        List l = Arrays.asList(a);
        ArrayList list = new ArrayList();
        Collections. addAll(list,a);
//        List<int[]> list = Arrays.asList(a);

        System.out.println("数组转集合 "+list);

        //集合转数组
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(14);
        arrayList.add(435);
//        System.out.println(arrayList);
        Integer[] b = new Integer[arrayList.size()];
        arrayList.toArray(b);
        System.out.println("集合转数组 "+Arrays.toString(b));
//        Arrays.();
//        QuickSort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(GetLeastNumbers_Solution(a,4));


    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //有效性校验
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

    //1.从low到high排序
    public static void sort(int[] arr, int low, int high){
        //指针校验
        if(low>=high) {
            return ;
        }
        //找到分界值pivot
        int pivot = partition(arr,low,high);
        //左子组继续排序
        sort(arr,low,pivot-1);  //pivot以确定位置，只需要对左右进行排序
        sort(arr,pivot+1,high);
        //右子组继续排序
    }

    //2.对数组进行拆分（目的是返回pivot位置，过程中也将pivot左右元素分好位置），交换左右元素，最后将pivot放到合适位置
    public static int partition(int[] arr, int low, int high){
        //初始化左右指针
        int left=low;
        int right=high+1;  //right每次都要先减一再开始移动
        int key=arr[low];
        while(true){
/*            //1.从右往左移动右指针，直到比分界值小
            while(less(key,arr[--right])){
                if(right==low)  //右指针已经到最左
                    break;
            }
            //2.从左往右移动左指针，直到比分界值大
            while(less(arr[++left],key)){
                if(left==high)  //右指针已经到最左
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



            //左右指针相遇都没有找到合适位置----本趟遍历 两边已经分好了
            if(left>=right){   // *************************************一定要大于等于！！！！！  左指针可能会到头high
                break;
            }else {  //前面两个左右交换位置已经找到
                swap(arr,left,right);
            }//交换后继续移动左右指针
        }
        //把分界值arr[low] 移到right位置（righ=left，或者righ<left跳出循环的,而且right元素放的是小于key的元素，所以low应该取right的位置）
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
