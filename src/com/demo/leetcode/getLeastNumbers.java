package com.demo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Jusven
 * @Date 2021/5/28 17:52
 *
������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
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

    //��С��������
    public static void sort(int[] arr, int k){
        sort(arr,0,arr.length-1,k);
    }

    public static void sort(int[] arr, int low, int high, int k){
//         if(low >= high){  //����Ҫ�����ݹ�ı�־
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
        //Ĭ�ϵ�һΪ�ֽ�ֵ
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
    * add(E e)��  offer(E e)��������ͬ�����������ȶ����в���Ԫ�أ�
    * ֻ��Queue�ӿڹ涨���߶Բ���ʧ��ʱ�Ĵ���ͬ��ǰ���ڲ���ʧ��ʱ�׳��쳣��������᷵��false��
    * ����PriorityQueue������������ʵûʲô���
    *
    * element()��  peek()��������ȫ��ͬ�����ǻ�ȡ����ɾ������Ԫ�أ�Ҳ���Ƕ�����Ȩֵ��С���Ǹ�Ԫ�أ�
    * ����Ψһ�������ǵ�����ʧ��ʱǰ���׳��쳣�����߷���null������С���ѵ����ʣ��Ѷ��Ǹ�Ԫ�ؾ���ȫ����С���Ǹ���
    * ���ڶ��������ʾ�������±��ϵ��0�±괦���Ǹ�Ԫ�ؼ��ǶѶ�Ԫ�ء�����ֱ�ӷ�������0�±괦���Ǹ�Ԫ�ؼ��ɡ�
    *
    * remove()��  poll()����������Ҳ��ȫ��ͬ�����ǻ�ȡ��ɾ������Ԫ�أ�
    * �����ǵ�����ʧ��ʱǰ���׳��쳣�����߷���null������ɾ��������ı���еĽṹ��Ϊά��С���ѵ����ʣ���Ҫ���б�Ҫ�ĵ�����
     * */

        public static int[] smallestK(int[] arr, int k) {
            LinkedList<Integer> link = new LinkedList<Integer>();

            PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                //������Ԫ�ؽ������򣬱�֤�˶���Ԫ����С
                // ��--> 654321-->��
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;   //��������
                }
            });
            int[] vec = new int[k];
            if (k == 0) { // �ų� 0 �����
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer num1, Integer num2) {
                    return num2 - num1;   //�������Ԫ��ʱΪ���򣬶����ڵ�Ԫ��������ģ���  ��--> ��β123456���� -->��
                }
            });
            for (int i = 0; i < k; ++i) {  //��������Ϊk�Ķ���
                queue.offer(arr[i]);
            }
            while(queue.size()!=0){
                System.out.println("queue.poll() = " + queue.poll());
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {  //�������ֵ�����鵱ǰֵ��
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
