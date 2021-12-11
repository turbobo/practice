package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/12/10 22:01
 */
public class findSubsequences {
    static List<List<Integer>> res = new ArrayList();
    //当前路径结果
    static LinkedList<Integer> path = new LinkedList<Integer>();

    public static void main(String[] args) {
        findSubsequences(new int[]{4,4,3,2});
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        // Arrays.sort(nums);
        // boolean[] used = new boolean[10];
        backTrack(nums,0);
        return res;
    }

    public static void backTrack(int[] nums, int startIndex){
        if(path.size()>=2){
            res.add(new ArrayList(path));
        }
        if(startIndex >= nums.length){
            return;
        }
        //只记录本层结点(记录结点值)
        int[] used = new int[201];  // -100 <= nums[i] <= 100  -100到100共201个数
        for(int i = startIndex;i<nums.length;i++){
            //处理本结点
            //used[i+100] 区分负数和正数
            if ((path.size()>0 && path.getLast() > nums[i]) || used[nums[i]+100] == 1){
                continue;
            }
            else{
                path.add(nums[i]);
                used[nums[i]+100] = 1;
                //递归  更深层从下个位置开始
                backTrack(nums,i+1);
                //回溯
                path.removeLast();
                // used[i] = false;


            }

        }

    }
}
