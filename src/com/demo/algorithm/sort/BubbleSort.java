package com.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/2/19 10:34
 * 冒泡排序
 * 每次冒泡过程都是从数列的第一个元素开始，然后依次和剩余的元素进行比较, 跟列队一样,
 * 从左到右两两相邻的元素比大小, 高的就和低的换一下位置. 最后最高(值最大)的肯定就排到后面了
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,73,32,6,3,34};
//        bubbleSort1(arr);
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort1(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){       //比较的回合数
            for(int j=0;j<a.length-i-1;j++){   //每回合选出最大值放在当前最后的位置
                if(a[j]>a[j+1]){   //前面大于后面  交换
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    private static void bubbleSort2(int[] a){
        int temp;
        for(int i=a.length-1;i>0;i--){       //比较的回合数
            for(int j=0;j<i;j++){   //每回合选出最大值放在当前最后的位置
                if(a[j]>a[j+1]){   //前面大于后面  交换
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
