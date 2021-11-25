package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/23 13:56
 * �������
 * https://leetcode-cn.com/problems/combinations/
 */
public class combine {
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        //�洢�ܽ��
        List<List<Integer>> res = new ArrayList<>();
        //�洢����·�����
        LinkedList<Integer> path = new LinkedList<Integer>();
        //1-n��������1��ʼ
        backtracking(n, k, 1, res, path);
        return res;
    }

    //�����������Կ������νṹ
    public static void backtracking(int n, int k, int start, List<List<Integer>> res, LinkedList<Integer> path) {
        //��������--��ǰ·�����㳤��k
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
//        �Ѿ�ѡ���Ԫ�ظ�����path.size();
//        ����Ҫ��Ԫ�ظ���Ϊ: k - path.size();
//        �ڼ���n������Ҫ�Ӹ���ʼλ�� : n - (k - path.size()) + 1����ʼ������i�����λ��֮��ʼ�����Ͳ���k������
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            //1.�������
            path.add(i);
            //2.���������i+1  ����������Ľ�㲻�ٱ���
            backtracking(n, k, i + 1, res, path);
            //3.for����������һ�ν��������ˣ���һ��ĵ�i��λ�õ������Ѿ���������
            //i+1 �������ұ��������������i+1λ�õ����������
            //��ʱpathֻ��Ҫȥ�����һ����㼴�ɣ����������ϲ�������Ľ�㣬������һ�����һ����ұ߽����Ҫ����ʹ��path
            path.removeLast();
        }
    }

}
