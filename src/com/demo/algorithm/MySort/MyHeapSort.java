package com.demo.algorithm.MySort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Jusven
 * @Date 2021/6/10 12:01
 */
public class MyHeapSort {
    public static void main(String[] args) {
        int[] arr = {392,383,84,9,482,23,12,5555,5556,5557,5558};
        heap(arr,4);
    }

    public static void heap(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;   //队列输出为升序，队列内为降序
            }
        });
        /*//实现堆排序
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }*/

        //前k大个数，维持长度为k的堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(queue.peek() < arr[i]){  //队列内最小值比当前元素小，放到队列中
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
