package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author Jusven
 * @Date 2021/11/23 17:46
 * 给出一组候选数 c 和一个目标数 t ，找出候选数中起来和等于 t 的所有组合。
 *
 *  c 中的每个数字在一个组合中只能使用一次。
 */
public class combinationSum2 {
    public static void main(String[] args) {
        int[] arr = new int[]{22,49,5,24,26};
        System.out.println(combinationSum2(arr, 77));
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        //结果
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        //当前路径结果
        LinkedList<Integer> path = new LinkedList<Integer>();
        //当前总和
        int tempSum = 0;
        backTrack(num,target,0,path,res,tempSum);
        return res;
    }

    public static void backTrack(int[] num, int target, int start,
                          LinkedList<Integer> path, ArrayList<ArrayList<Integer>> res,
                          int tempSum){
        //结束条件,path存满了
        if(tempSum == target){
            ArrayList<Integer> list = new ArrayList<>(path);
            Collections.sort(list);
            res.add(list);
            return;
        }
        for(int i=start;i<num.length;i++){
            //处理当前结点
            path.add(num[i]);
            tempSum += num[i];
            //递归
            backTrack(num,target,i+1,path,res,tempSum);
            //回溯
            tempSum -= num[i];
            path.removeLast();
        }
    }

}
