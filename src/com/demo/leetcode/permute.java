package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/28 18:30
 * ȫ����
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
        //��������
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
        }
        //����������飬ÿ��ȡ��ͬλ�õ���
        for (int i = 0; i < nums.length; i++) {
            //�������
            if(!assist[i]){
                path.add(nums[i]);
                assist[i] = true;
            }
            //����ݹ飬��һ����ȡ��Ԫ�ؿ����ڵ�ǰλ��ǰ�棬��Ҫ������־����
            backTrack(nums, assist, res, path, startIndex + 1);
            //����
            path.removeLast();
            assist[i] = false;
        }
    }
}
