package com.demo.jianzhiOffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author Jusven
 * @Date 2021/6/21 19:00
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 对于50\%50%的数据,size\leq 10^4size≤10
 * 4
 *
 * 对于100\%100%的数据,size\leq 10^5size≤10
 * 5
 *
 *
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入：
 * [1,2,3,4,5,6,7,0]
 * 返回值：7
 */
public class InversePairs {
    private static int[] assist;
    private static long l = 0;
    public static void main(String[] args) {
//        int[] a = {392,49,3924958,4,48};
//        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] a = {7,21,33,5,6,44};
        //        Arrays.sort(a,0,2);
//        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        System.out.println("solution(a) = " + solution(a));
        sort(a);
        System.out.println("(int) (l%1000000007) = " + (int) (l%1000000007));

    }

    public static void sort(int[] arr){
        assist = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        //有效校验
        if(low>=high){
            return;
        }
        int mid = (low + high)/2;
        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    /**
     * 归并排序，(21,7) (18,9)，两个子序列的逆序为2，当两个子序列有序时，逆序还是2
     * 归并的时候，判断左序列大于右序列的个数即可
     */
    public static void merge(int[] arr, int low,  int mid, int high){
        //先对左右子序列排序
        int index=low;    //辅助数组指针
        int p1=low;   //左子组指针
        int p2=mid+1;   //右子组指针
        //两个子组进行比较，小的放到辅助数组
        while(p1<=mid && p2<=high){   //两个条件   只要一个子组遍历完就结束
            if(arr[p1] < arr[p2]){
                assist[index++] = arr[p1++];
            }else{
                assist[index++] = arr[p2++];
            }
        }

        //如果左子组没有遍历完，就顺序遍历左子组(已经有序)的元素直接放入辅助数组
        while(p1<=mid){
            assist[index++] = arr[p1++];
        }
        //如果右子组没有遍历完，就顺序遍历右子组(已经有序)的元素直接放入辅助数组
        while(p2<=high){
            assist[index++] = arr[p2++];
        }

        //拷贝辅助数组到原数组对应位置   本次是从low到high位置的元素
        for(int i=low;index<=high;index++){
            arr[i] = assist[i];
        }

        //下次起始坐标
        int start = mid + 1;
        //右子序列中已经确定小于左子序列的个数
        int count = 0;
        //此时mid左右子序列才分别有序
        for (int i = low; i <= mid; i++) {
            int j = start;
//            for (int j = start; j <= high; j++) {
//                if(arr[i] > arr[j]){
//                    l++;
//                }
                while(j<=high && arr[i] > arr[j]){
                    j++;
                }
                if(j<=high){
                    l = l+j-start+count;
                    count = j-start;
                    start = j;
                }
//                break;
//            }
            l = l % 1000000007;
        }

    }


    public static int solution(int[] array){
        long l = 0;
        for (int i = 1; i < array.length; i++) {
            //统计每个数的逆序
            for (int j = 0; j < i; j++) {
                if(array[i] < array[j]){
                    l++;
                }
                if(j+1 < i && array[i] >= array[j+1]){
                    break;
                }
            }
            //该数及之前的数据排序
            Arrays.sort(array,0,i+1);
        }
        return (int) (l%1000000007);
    }

//    public long findIndex(int[] array,int k, int kIndex){
//        long left = 0;
//        long right = kIndex;
//        long mid = 0;
//        while(){
//
//        }
//    }
}
