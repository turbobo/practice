package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/20 17:22
 * 快速排序
 */
public class Quick {
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
        //获得分界点索引
        int pivot = partition(a, low, high);

        //左子组排序
        sort(a,low,pivot-1);
        //右子组排序
        sort(a,pivot+1,high);

    }


    private static int partition(Comparable[] a, int low, int high) {
       return 1;
    }

}
