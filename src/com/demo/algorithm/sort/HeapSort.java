package com.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/5/29 17:51
 *
 * 堆排序
 * 先构造大根堆的结构，然后再调整就可以得到升序序列
 * 先构造小根堆的结构，然后再调整就可以得到降序序列
 *
 * 此时我们从最后一个非叶子结点开始（叶结点自然不用调整，
 * 第一个非叶子结点 arr.length/2-1=5/2-1=1，也就是下面的6结点），
 * 从左至右，  从 下 至 上   进行调整
 */
public class HeapSort {
    public static void main(String[] args) {
        int a = 3;
        int b = 45;
        System.out.println("\"交换前\" = " + "交换前");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("\"交换后\" = " + "交换后");
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
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与   当前   末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }


    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){  //如果左子结点小于右子结点，k指向右子结点
                k++;   //k是大的那个结点位置
            }
            if(arr[k] >temp){  //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
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
