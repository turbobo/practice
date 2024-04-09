package com.demo.interview.xtransfer;

import com.demo.tree.TreeNode;

import java.util.*;

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
//            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
//            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
//        printTree(root);
        WideFirst(root);
    }

    // 借助队列
    // 先保存左节点

    // 层序遍历/广度优先
    public static void WideFirst (TreeNode node) {
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

    // 深度优先：分为 前中后 序 3种
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

//        PriorityQueue<TreeNode> queue = new PriorityQueue<>(new Comparator<TreeNode>() {
//            @Override
//            public int compare(TreeNode o1, TreeNode o2) {
//                return 0;
//            }
//        });
        TreeNode p = node;
        // 首先当前节点
        deque.push(p);
        while (deque.size()>0) {
            // 首先当前节点
            TreeNode pop = deque.pop();  // 需要弹出所有元素
            System.out.println(pop.val);

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
            if (null != pop.right) {
                deque.push(pop.right);
            }
            if (null != pop.left) {
                deque.push(pop.left);
            }
//            // 弹出
//            p = p.left;
        }
    }

    // 前序序：栈，右子树先入栈
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

            // 先压入右节点
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return res;
    }

    // 中序：左根右，栈，
    public void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current); // 根节点先入栈
                current = current.left; // 左子树后入栈
            }
            current = stack.pop(); // 弹出左节点
            System.out.print(current.val + " ");
            // 再遍历右节点，下一轮会首先弹出根节点，再将右节点入栈
            current = current.right;
        }

    }


    // 后序：左右根，用两个栈，第一个栈保存根左右的顺序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack1 = new LinkedList<>(); // 第一个栈用于存放待访问的节点
        Deque<TreeNode> stack2 = new LinkedList<>(); // 第二个栈用于存放遍历结果

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
