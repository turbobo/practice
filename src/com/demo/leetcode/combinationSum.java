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
        //��������
        if (tempSum == target) {
            res.add(path);
            return;
        }
        //ÿ��������������������һ��Ԫ�ؿ�ʼ����ΪԪ�ؿ����ظ�ѡ
        //ע���жϣ���ѡԪ�ء���ѡԪ���ܺ� ����Ѿ�����n������Ҫ��ĺͣ��ˣ���ô���������û�������ˣ�ֱ�Ӽ�����
        for (int i = startIndex; i < candidates.length && tempSum <= target && candidates[i] <= target; i++) {
            //�������
            path.add(candidates[i]);
            tempSum += candidates[i];
            //�ݹ�
            backTrace(res, path, candidates, target, i, tempSum);
            //����
            path.removeLast();
            tempSum -= candidates[i];
        }
    }


}
