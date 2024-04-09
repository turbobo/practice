package com.demo.interview.xtransfer;

import com.demo.tree.TreeNode;

import java.util.*;

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
//            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
//            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
//        printTree(root);
        WideFirst(root);
    }

    // ��������
    // �ȱ�����ڵ�

    // �������/�������
    public static void WideFirst (TreeNode node) {
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

    // ������ȣ���Ϊ ǰ�к� �� 3��
    public static void deepFirst(TreeNode node) {



//        Queue<TreeNode> deque = new LinkedList<>();
//        // ���ȵ�ǰ�ڵ�
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



        // ���ڶ��еĲ���������ʹ�� offer() ������Ԫ����ӵ����е�β����ʹ�� poll() �����Ӷ��е�ͷ���Ƴ�������Ԫ�أ�����ʹ�� peek() �����鿴���е�ͷ��Ԫ�ء�
        //
        //����ջ�Ĳ���������ʹ�� push() ������Ԫ��ѹ��ջ����ʹ�� pop() ������ջ���Ƴ�������Ԫ�أ�����ʹ�� peek() �����鿴ջ��Ԫ�ء�
        Deque<TreeNode> deque = new LinkedList<>();

//        PriorityQueue<TreeNode> queue = new PriorityQueue<>(new Comparator<TreeNode>() {
//            @Override
//            public int compare(TreeNode o1, TreeNode o2) {
//                return 0;
//            }
//        });
        TreeNode p = node;
        // ���ȵ�ǰ�ڵ�
        deque.push(p);
        while (deque.size()>0) {
            // ���ȵ�ǰ�ڵ�
            TreeNode pop = deque.pop();  // ��Ҫ��������Ԫ��
            System.out.println(pop.val);

//            if (null != p.left) {
//                deque.offer(p.left);
//            }
//
//            if (null != p.right) {
//                deque.offer(p.right);
//            }

            // �ȱ����ҽڵ�
//            if (null != poll.left) {
//                deque.push(poll.left);
//            }
//            if (null != poll.right) {
//                deque.push(poll.right);
//            }

            // �ȱ�����ڵ�---�������
            if (null != pop.right) {
                deque.push(pop.right);
            }
            if (null != pop.left) {
                deque.push(pop.left);
            }
//            // ����
//            p = p.left;
        }
    }

    // ǰ����ջ������������ջ
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);

            // ��ѹ���ҽڵ�
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return res;
    }

    // ��������ң�ջ��
    public void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current); // ���ڵ�����ջ
                current = current.left; // ����������ջ
            }
            current = stack.pop(); // ������ڵ�
            System.out.print(current.val + " ");
            // �ٱ����ҽڵ㣬��һ�ֻ����ȵ������ڵ㣬�ٽ��ҽڵ���ջ
            current = current.right;
        }

    }


    // �������Ҹ���������ջ����һ��ջ��������ҵ�˳��
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack1 = new LinkedList<>(); // ��һ��ջ���ڴ�Ŵ����ʵĽڵ�
        Deque<TreeNode> stack2 = new LinkedList<>(); // �ڶ���ջ���ڴ�ű������

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;
    }
}
