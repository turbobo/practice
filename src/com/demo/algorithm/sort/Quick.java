package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/20 17:22
 * 快速排序
 */
public class Quick {
    public static void main(String[] args) {

    }

    //两者更小
    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;   //直接返回比较结果
    }

    //数组元素i 和j 交换
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //对数组a进行排序
    public static void sort(Comparable[] a) {
        //定义数组的最小位置low 最大位置high
        int low = 0;
        int high = a.length - 1;
        //调用方法对a数组从low到high元素排序
        sort(a, low, high);
    }

    //对数组a中从low到high之间进行排序
    private static void sort(Comparable[] a, int low, int high) {  //实际排序操作在partition方法中
        //安全检查
        if (low >= high) {
            return;
        }
        //获得分界点索引
        int pivot = partition(a, low, high);

        //左子组排序  调用partition
        sort(a, low, pivot - 1);
        //右子组排序
        sort(a, pivot + 1, high);

    }

    //对数组进行切分
    private static int partition(Comparable[] a, int low, int high) {
        //确定分界值----数组第一个元素
        Comparable key = a[low];

        //定义两个指针，指向最小  最大处
        int left = low;
        int right = high + 1;

        while (true) {
            //right从右往左扫描，找到一个比分界值小的值，停止
            while (less(key, a[--right])) {   //找right位置比分界值pivot小的  放分界值左边
                if (right == low) {  //扫描到low位置 退出
                    break;
                }
            }
            //left从左往右，找到一个比分界值大的值
            while (less(a[++left], key)) {   //找right位置比分界值pivot大的  放分界值右边
                if (left == high) {  //扫描到high位置 退出
                    break;
                }
            }
            //left>=right 扫描结束，退出循环；否则交换位置
            if (left >= right) {
                break;
            } else {
                swap(a, right, left);
            }
        }
        //左右指针重合时，交换任一指针和pivot位置
        swap(a, right, low);
        return right;
    }

}
