package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 16:01
 * 选择排序API
 */
public class Selection {
    //对数组元素排序
    public static void sort(Comparable[] a){
        //先定义最小索引位置
        int minIndex;
        for(int i=0;i<a.length-1;i++){   //剩下最后一个数不用比较
            minIndex = i; //当前默认最小元素位置 i赋给 minIndex
            for(int j=i+1;j<a.length;j++){  //每趟排序一直比较到最后一个元素
                if(greater(a[minIndex],a[j])){  //当前位置j的元素比最小索引出元素值小，则交换索引位置
                    minIndex = j;
                }
            }

            //把最小元素minIndex放到当前第一个位置i
            swap(a,i,minIndex);
        }
    }

    //比较大小
    private static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2)>0;   //直接返回比较结果
    }

    //数组元素i 和j 交换
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
