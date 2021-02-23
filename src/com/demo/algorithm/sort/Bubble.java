package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 13:43
 * 冒泡排序API
 *
 * Comparable此接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
 */
public class Bubble {

    //对数组元素排序
    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){  //比较的回合数  剩下最后一个数自动放到首位，不需要比较
            for(int j=0;j<i;j++){      //每回合从第一个数开始往后比较,每次选出最大值放到当前最后的位置
                if(greater(a[j],a[j+1])){  //前者大于后者    *****稳定，等于时不会交换顺序
                    swap(a,j,j+1);
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
