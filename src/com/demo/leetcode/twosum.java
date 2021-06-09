package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Jusven
 * @Date 2021/5/11 17:48
 */
public class twosum {
    public static int[] twoSum2(int[] nums, int target) {
        //不能排序，排序后下标改变了
//        Arrays.sort(nums);
        int[] array=new int[2];
        //滑动窗口
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int temp = nums[left]+nums[right];
            if(temp==target){
                array[0]=left;
                array[1]=right;
                //等于后也需要继续移动!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//                left++;
                break;
            }else if(temp>target){
                //右指针左移
                right--;
            }else if(temp<target){
                //右指针左移
                left++;
            }
        }
        return array;
    }

    public static int[] twoSum3(int[] nums, int target) {
        //不能排序，排序后下标改变了
//        Arrays.sort(nums);
        int[] array=new int[2];
        //使用map
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){   //这个数存在value中，说明和数组某个数和为target
                array[0] = i;
                array[1] = hash.get(nums[i]);  //快速找到数值的下标
                return array;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);  //存放  当前数值和target的差值 --- 当前数值下标
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4};
        System.out.println(twoSum3(a, 6));

    }
}
