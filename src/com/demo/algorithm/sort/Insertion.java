package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 17:19
 * 插入排序---类似于抓扑克牌
 */
public class Insertion {
    //对数组元素排序
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){  //默认有序序列就是第一个元素  无序序列就是第二个元素到末尾
            //无序第一个数和有序序列的数逐个比较
            for(int j=i;j>0;j--){    //无序序列第一个元素和有序序列最后一个元素对比，比它小就交换，一直往前比较; j不能越界
                if(greater(a[j-1],a[j])){
                    swap(a,j-1,j);
                }
            }
        }
    }

    //比较c1,c2元素大小
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //直接返回比较结果
    }

    //数组元素i 和j 交换
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
