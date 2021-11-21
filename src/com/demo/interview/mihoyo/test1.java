package com.demo.interview.mihoyo;

/**
 * @Author Jusven
 * @Date 2021/11/21 19:47
 */
public class test1 {
    public static void main(String[] args) {
        int[] a = new int[]{1,23,3,4};
        System.out.println(findKthLargest(a, 2));
    }

    public static int findKthLargest (int[] nums, int k) {
        // write code here
//        Arrays.sort(nums);
//        return nums[nums.length-k];

        //使用快速排序
        return sort(nums,k);

    }
    public static int sort(int[] nums, int k){
        return sort(nums,k,0,nums.length-1);
    }

    public static int sort(int[] nums, int k, int low, int high){

        int pivot = partition(nums,low,high);
        if(k-1==pivot){
            return nums[pivot];
        }else if(k-1>pivot){
            return sort(nums,k,pivot+1,high);
        }else{
            return sort(nums,k,low,pivot-1);
        }
    }

    public static int partition(int[] nums,int low, int high){
        int left = low;  //left第一个数不用比较
        int right = high + 1;
        int key = nums[low];
        while(true){
            while(true){
                right--;
                if (right == low || nums[right] < key){
                    break;
                }
            }
            //左边找大于key的数
            while(true){
                left++;
                if (left == high || nums[left] > key){
                    break;
                }
            }
            if(left<right){
                swap(nums,left,right);
            }else{
                break;
            }
        }
        swap(nums,low,right);
        return right;
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
