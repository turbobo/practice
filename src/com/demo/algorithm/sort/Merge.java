package com.demo.algorithm.sort;


import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Jusven
 * @Date 2021/2/20 10:58
 * 归并排序
 */
public class Merge {
    private static Comparable[] assist;  //归并辅助数组

    //两者更小
    private static boolean less(Comparable c1, Comparable c2){
        return c1.compareTo(c2)<0;   //直接返回比较结果
    }
    //数组元素i 和j 交换
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //对数组a进行排序
    public static void sort(Comparable[] a) {
        //初始化辅助数组
        assist = new Comparable[a.length];
        //定义数组的最小位置low 最大位置high
        int low = 0;
        int high = a.length-1;
        //调用方法对a数组从low到high元素排序
        sort(a,low,high);
    }

    //对数组a中从low到high之间进行排序
    private static void sort(Comparable[] a, int low, int high) {
        //安全检查
        if(low>=high){
            return ;
        }

        //数组分为两部分
        int mid = low+(high-low)/2;   // (low+high)/2
        //分别对两个分组排序
        sort(a,low,mid);   //左子组
        sort(a,mid+1,high);   //右子组
        //两个子组分别排序后再进行归并
        merge(a,low,mid,high);
    }

    //每次归并左右两个组：从两个组首位开始，小的放到辅助数组，该分组指针后移，
    // 下一次继续和大的分组进行比较，大的分组指针不动，辅助数组指针后移；
    private static void merge(Comparable[] a, int low, int mid, int high) {
        //定义3个指针
        int i=low;    //辅助数组指针
        int p1=low;   //左子组指针
        int p2=mid+1;   //右子组指针
        //两个子组进行比较，小的放到辅助数组
        while(p1<=mid && p2<=high){   //两个条件   只要一个子组遍历完就结束
            if(less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }

        //如果左子组没有遍历完，就顺序遍历左子组(已经有序)的元素直接放入辅助数组
        while(p1<=mid){
            assist[i++] = a[p1++];
        }
        //如果右子组没有遍历完，就顺序遍历右子组(已经有序)的元素直接放入辅助数组
        while(p2<=high){
            assist[i++] = a[p2++];
        }
        //拷贝辅助数组到原数组对应位置   本次是从low到high位置的元素
        for(int index=low;index<=high;index++){
            a[index] = assist[index];
        }
    }


}
