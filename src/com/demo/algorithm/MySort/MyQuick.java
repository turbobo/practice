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
        // PriorityQueueĬ�ϻᰴ�����ȼ��������Ԫ��ʵ����Comparable�ӿڣ���������
        // ���ж���������СԪ��
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // �������򣬶Ӷ������Ԫ��---С���ѣ����������С�ļ���Ԫ��
                return o2 - o1;
            }
        });
        for (int i = 0; i < 4; i++) {
            queue.offer(a[i]);
        }
        for (int i = 4; i < a.length; i++) {
            if(queue.peek() > a[i]){  //��ǰԪ�ر� С���ѵ����Ԫ��С������ӣ���Ӻ󣬶����ֻ���������
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
        //��ЧУ��
        if(low >= high) {
            return;
        }

        int pivot = partition(arr,low,high);
        //pivotλ��Ԫ���Ѿ��̶�
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
    }

    public static int partition(int[] arr, int low, int high){
        int key = arr[low];
        int left = low;   //��һ��Ԫ��Ĭ��Ϊ�ֽ�ֵ������Ҫ�Ƚ�
        int right = high+1;
        while(true){
            while (arr[++left] < key){  //����Ҵ��ڷֽ�ֵkey����
                if(left == high){
                    break;
                }
            }
            while (arr[--right] > key){  //�ұ���С�ڷֽ�ֵkey����
                if(right == low){
                    break;
                }
            }
          /*  while (left < high){
                left++;
                if(arr[left] > key){  //����Ҵ��ڷֽ�ֵkey����
                    break;
                }
            }
            while (right > low){
                right--;
                if(arr[right] < key){  //�ұ���С�ڷֽ�ֵkey����
                    break;
                }
            }*/
            if(left < right){  //�����ҵ���������λ��
                swap(arr,left,right);
            }else{
                break;
            }

        }
        //rightλ��Ԫ�ؽ�С
        swap(arr,low,right);
        return right;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
