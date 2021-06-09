package com.demo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Jusven
 * @Date 2021/5/28 17:52
 *
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class getLeastNumbers {
    public static void main(String[] args) {
//        int[] arr = new int[128];
//        Arrays.fill(arr,-1);
        int d = 5&6;
        System.out.println("d = " + d);
//        int[] arr = {32, 385, 23, 4, 6, 1, 50, 11, 33, 406};
//        int[] arr = {4,5,1,6,2,7,3,8};
        int[] arr = {4,5,1,6,2,7,3,8};
//        sort(arr,7);
////        System.out.println("sort(arr,0) = " + Arrays.toString(sort(arr, 0)));
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        smallestK(arr,4);

    }
    public int[] getLeastNumbers_Solution(int[] arr, int k) {
        if(k<1 || k>arr.length){
            return new int[0];
        }
        sort(arr,k);
        return Arrays.copyOf(arr,k);

        /*ArrayList<Integer> list = new ArrayList<Integer>();
//        Integer[] result = (Integer[])Arrays.copyOf(arr,k);
        int[] result = Arrays.copyOf(arr,k);
        list = (ArrayList<Integer>)Arrays.stream(result).boxed().collect(Collectors.toList());
        return list;*/
    }

    //从小到大排列
    public static void sort(int[] arr, int k){
        sort(arr,0,arr.length-1,k);
    }

    public static void sort(int[] arr, int low, int high, int k){
//         if(low >= high){  //不需要结束递归的标志
//             return -1;
//         }
        int pivot = partition(arr,low,high);
        if (k-1 == pivot){
            return;
        }else if(k-1 < pivot){
            sort(arr,low,pivot-1,k);
        }else {
            sort(arr,pivot+1,high,k);
        }
//         sort(arr,low,pivot-1,k);
//         sort(arr,pivot+1,high,k);
    }

    public static int partition(int[] arr, int low, int high){
        //默认第一为分界值
        int init = arr[low];
        int left = low;
        int right = high + 1;
        while(true){
            while(true){
                right--;
                if(right <= low || arr[right] < init){
                    break;
                }
            }
            while(true){
                left++;
                if(left >= high || arr[left] > init){
                    break;
                }
            }
            if(left < right){
                swap(arr,left,right);
            }else {
                break;
            }
        }
        swap(arr,low,right);
        return right;
    }

    public static void swap ( int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /*
    * add(E e)和  offer(E e)的语义相同，都是向优先队列中插入元素，
    * 只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false。
    * 对于PriorityQueue这两个方法其实没什么差别。
    *
    * element()和  peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，
    * 二者唯一的区别是当方法失败时前者抛出异常，后者返回null。根据小顶堆的性质，堆顶那个元素就是全局最小的那个；
    * 由于堆用数组表示，根据下标关系，0下标处的那个元素既是堆顶元素。所以直接返回数组0下标处的那个元素即可。
    *
    * remove()和  poll()方法的语义也完全相同，都是获取并删除队首元素，
    * 区别是当方法失败时前者抛出异常，后者返回null。由于删除操作会改变队列的结构，为维护小顶堆的性质，需要进行必要的调整。
     * */

        public static int[] smallestK(int[] arr, int k) {
            LinkedList<Integer> link = new LinkedList<Integer>();

            PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                //队列中元素降序排序，保证了队首元素最小
                // 进--> 654321-->出
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;   //升序排序
                }
            });
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer num1, Integer num2) {
                    return num2 - num1;   //队列输出元素时为降序，队列内的元素是升序的，则  进--> 队尾123456队首 -->出
                }
            });
            for (int i = 0; i < k; ++i) {  //保留容量为k的队列
                queue.offer(arr[i]);
            }
            while(queue.size()!=0){
                System.out.println("queue.poll() = " + queue.poll());
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {  //队列最大值比数组当前值大
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                vec[i] = queue.poll();
            }
            return vec;
        }
    }
