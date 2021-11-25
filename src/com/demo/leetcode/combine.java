package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/11/23 13:56
 * 组合问题
 * https://leetcode-cn.com/problems/combinations/
 */
public class combine {
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        //存储总结果
        List<List<Integer>> res = new ArrayList<>();
        //存储单个路径结果
        LinkedList<Integer> path = new LinkedList<Integer>();
        //1-n个数，从1开始
        backtracking(n, k, 1, res, path);
        return res;
    }

    //整个遍历可以看成树形结构
    public static void backtracking(int n, int k, int start, List<List<Integer>> res, LinkedList<Integer> path) {
        //结束条件--当前路径满足长度k
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
//        已经选择的元素个数：path.size();
//        还需要的元素个数为: k - path.size();
//        在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历，i在这个位置之后开始遍历就不够k个数了
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            //1.处理本结点
            path.add(i);
            //2.纵向遍历，i+1  本层遍历过的结点不再遍历
            backtracking(n, k, i + 1, res, path);
            //3.for代表横向遍历一次结束，至此，这一层的第i个位置的纵向已经遍历结束
            //i+1 继续向右遍历，继续本层的i+1位置的纵向遍历，
            //此时path只需要去掉最后一个结点即可，其余结点是上层遍历过的结点，返回上一层后，上一层的右边结点需要继续使用path
            path.removeLast();
        }
    }

}
