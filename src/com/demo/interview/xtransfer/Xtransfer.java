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
//        printTree(root);
        deepFirst(root);
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

    // 深度优先
    public static void deepFirst(TreeNode node) {



//        Queue<TreeNode> deque = new LinkedList<>();
//        // 首先当前节点
//        deque.offer(node);
//        while (deque.size() > 0) {
//            TreeNode poll = deque.poll();
//            System.out.println(poll.val);
//            TreeNode left = poll.left;
//            while (null != left) {
//                deque.offer(left);
//                left = left.left;
//            }
//            TreeNode right = poll.right;
//            while (null != right) {
//                deque.offer(right);
//                right = right.left;
//            }
//        }



        // 对于队列的操作，可以使用 offer() 方法将元素添加到队列的尾部，使用 poll() 方法从队列的头部移除并返回元素，或者使用 peek() 方法查看队列的头部元素。
        //
        //对于栈的操作，可以使用 push() 方法将元素压入栈顶，使用 pop() 方法从栈顶移除并返回元素，或者使用 peek() 方法查看栈顶元素。
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode p = node;
        // 首先当前节点
        deque.push(p);
        while (deque.size()>0) {
            // 首先当前节点
            TreeNode poll = deque.pop();  // 需要弹出所有元素
            System.out.println(poll.val);

//            if (null != p.left) {
//                deque.offer(p.left);
//            }
//
//            if (null != p.right) {
//                deque.offer(p.right);
//            }

            // 先遍历右节点
//            if (null != poll.left) {
//                deque.push(poll.left);
//            }
//            if (null != poll.right) {
//                deque.push(poll.right);
//            }

            // 先遍历左节点---深度优先
            if (null != poll.right) {
                deque.push(poll.right);
            }
            if (null != poll.left) {
                deque.push(poll.left);
            }
//            // 弹出
//            p = p.left;
        }
    }
}
