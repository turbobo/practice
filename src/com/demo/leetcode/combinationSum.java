package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/25 15:23
 */
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        backTrace(res, path, candidates, target, 0, 0);
        return res;
    }

    private void backTrace(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int startIndex, int tempSum) {
        //结束条件
        if (tempSum == target) {
            res.add(path);
            return;
        }
        //每次纵向遍历，都从数组第一个元素开始，因为元素可以重复选
        //注意判断：已选元素、已选元素总和 如果已经大于n（题中要求的和）了，那么往后遍历就没有意义了，直接剪掉。
        for (int i = startIndex; i < candidates.length && tempSum <= target && candidates[i] <= target; i++) {
            //处理本结点
            path.add(candidates[i]);
            tempSum += candidates[i];
            //递归
            backTrace(res, path, candidates, target, i, tempSum);
            //回溯
            path.removeLast();
            tempSum -= candidates[i];
        }
    }


}
