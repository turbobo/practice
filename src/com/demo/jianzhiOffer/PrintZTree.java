package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Jusven
 * @Date 2021/9/8 21:56给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * 例如：
 */

public class PrintZTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        n2.left = n4;
        n4.right = n7;
        TreeNode n8 = new TreeNode(8);
        root.left = n2;
        root.right = n8;

        System.out.println(Print(root));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        TreeNode p = pRoot;
        Queue<TreeNode> queue1 = new PriorityQueue<TreeNode>();
        Queue<TreeNode> queue2 = new PriorityQueue<TreeNode>();
        boolean flag = true;
        while (p!=null){
            queue1.offer(p);
            ArrayList<Integer> l1 = new ArrayList<Integer>();
            while (!queue1.isEmpty()){
                TreeNode temp = (TreeNode) queue1.poll();
                l1.add(temp.val);
                if (temp.left!=null){
                    queue2.offer(temp.left);
                }
                if (temp.right!=null){
                    queue2.offer(temp.right);
                }
                if (!flag){
                    Collections.reverse(l1);
                }
            }
            if (flag){
                flag = false;
            }else {
                flag = true;
            }
            res.add(l1);
        }
        return res;    }
}
