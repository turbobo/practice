package com.demo.interview.mihoyo;

import java.util.ArrayList;

/**
 * @Author Jusven
 * @Date 2021/11/21 19:40
 */
public class test2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        System.out.println(permute(a));
    }


    public static ArrayList<ArrayList<Integer>> permute (int[] nums) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length==0) {
            return result;
        }
        //借助辅助数组
        ArrayList<Boolean> assist = new ArrayList<Boolean>();
        for (int i = 0; i < length; i++) {
            assist.add(false);
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(nums,0,length,assist,temp,result);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> dfs(int[] nums, int dep, int length, ArrayList<Boolean> assist, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
        //结果result需要作为全局变量存储所有数组
        if(dep == length){
//            result.add(temp);
            temp = new ArrayList<Integer>();
            result.add(new ArrayList<Integer>(temp));
            return result;
        }
        for (int i = 0; i < length; i++) {
            //遍历辅助数组
            if(!assist.get(i)){  //当前数字没有加到排列中
                temp.add(nums[i]);
                //当前数字加入过
                assist.set(i,true);
                //深度加1
                dfs(nums,dep+1,length,assist,temp,result);

            }
        }
        return result;
    }


}
