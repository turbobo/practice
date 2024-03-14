package com.demo.interview.xtransfer;

import com.demo.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Jusven
 * @Date 2024/3/14 17:12
 * Xtransfer 层次遍历
 */
public class Xtransfer {
    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
        printTree(root);
    }

    // 借助队列
    // 先保存左节点

    public static void printTree (TreeNode node) {
        //
        Queue<TreeNode> deque = new LinkedList<>();
        TreeNode p = node;
        // 首先当前节点
        deque.offer(p);
        while (deque.size()>0) {
            // 首先当前节点
            TreeNode poll = deque.poll();  // 需要弹出所有元素
            System.out.println(poll.val);

//            if (null != p.left) {
//                deque.offer(p.left);
//            }
//
//            if (null != p.right) {
//                deque.offer(p.right);
//            }

            // 把弹出的当前节点的孩子节点放入队列，不是p节点！！！！！！！！
            if (null != poll.left) {
                deque.offer(poll.left);
            }

            if (null != poll.right) {
                deque.offer(poll.right);
            }
//            // 弹出
//            p = p.left;
        }

    }
}
