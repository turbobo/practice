package com.demo.algorithm.MySort;


import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/2/25 16:30
 */
public class MyQuick {
    public static void main(String[] args) {
        int[] a = {231,43,54,2,7,67,231,348,22,31,16,2,2,34};
//        sort(a);
        System.out.println(Arrays.toString(a));
        // PriorityQueue默认会按照优先级排序，如果元素实现了Comparable接口，就能排序
        // 队列顶部就是最小元素
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 降序排序，队顶是最大元素---小根堆，保存的是最小的几个元素
                return o2 - o1;
            }
        });
        for (int i = 0; i < 4; i++) {
            queue.offer(a[i]);
        }
        for (int i = 4; i < a.length; i++) {
            if(queue.peek() > a[i]){  //当前元素比 小根堆的最大元素小，则入队，入队后，队列又会重新排序
                queue.poll();
                queue.offer(a[i]);
            }
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high){
        //有效校验
        if(low >= high) {
            return;
        }

        int pivot = partition(arr,low,high);
        //pivot位置元素已经固定
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
    }

    public static int partition(int[] arr, int low, int high){
        int key = arr[low];
        int left = low;   //第一个元素默认为分界值，不需要比较
        int right = high+1;
        while(true){
            while (arr[++left] < key){  //左边找大于分界值key的数
                if(left == high){
                    break;
                }
            }
            while (arr[--right] > key){  //右边找小于分界值key的数
                if(right == low){
                    break;
                }
            }
          /*  while (left < high){
                left++;
                if(arr[left] > key){  //左边找大于分界值key的数
                    break;
                }
            }
            while (right > low){
                right--;
                if(arr[right] < key){  //右边找小于分界值key的数
                    break;
                }
            }*/
            if(left < right){  //本趟找到左右两个位置
                swap(arr,left,right);
            }else{
                break;
            }

        }
        //right位置元素较小
        swap(arr,low,right);
        return right;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
