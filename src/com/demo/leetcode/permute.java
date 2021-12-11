package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/28 18:30
 * 全排列
 */
public class permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] assist = new boolean[nums.length];
        backTrack(nums, assist, res, path, 0);
        return res;
    }

    private void backTrack(int[] nums, boolean[] assist, List<List<Integer>> res, LinkedList<Integer> path, int startIndex) {
        //结束条件
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
        }
        //横向遍历数组，每次取不同位置的数
        for (int i = 0; i < nums.length; i++) {
            //处理本结点
            if(!assist[i]){
                path.add(nums[i]);
                assist[i] = true;
            }
            //纵向递归，下一个待取的元素可能在当前位置前面，需要借助标志数组
            backTrack(nums, assist, res, path, startIndex + 1);
            //回溯
            path.removeLast();
            assist[i] = false;
        }
    }
}
