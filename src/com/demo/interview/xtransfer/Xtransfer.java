package com.demo.interview.xtransfer;

import com.demo.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Jusven
 * @Date 2024/3/14 17:12
 * Xtransfer ��α���
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

    // ��������
    // �ȱ�����ڵ�

    public static void printTree (TreeNode node) {
        //
        Queue<TreeNode> deque = new LinkedList<>();
        TreeNode p = node;
        // ���ȵ�ǰ�ڵ�
        deque.offer(p);
        while (deque.size()>0) {
            // ���ȵ�ǰ�ڵ�
            TreeNode poll = deque.poll();  // ��Ҫ��������Ԫ��
            System.out.println(poll.val);

//            if (null != p.left) {
//                deque.offer(p.left);
//            }
//
//            if (null != p.right) {
//                deque.offer(p.right);
//            }

            // �ѵ����ĵ�ǰ�ڵ�ĺ��ӽڵ������У�����p�ڵ㣡��������������
            if (null != poll.left) {
                deque.offer(poll.left);
            }

            if (null != poll.right) {
                deque.offer(poll.right);
            }
//            // ����
//            p = p.left;
        }

    }
}
