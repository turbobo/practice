package com.demo.tree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @Author Jusven
 * @Date 2021/3/5 18:55
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

//    public TreeNode(int val){
//        this.val = val;
//    }


    TreeNode() {
        left = null;
        right = null;
    }
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void setVal(int val) {
        this.val = val;
    }




    /**
     * ά��������������ֵ��ֵ����
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
    }

    /**
     * Create A Binary Tree with TreeValue  ���������
     *
     * @node: a tree node
     * @i: the index of tree value
     */
    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }

/*  ���Թ��������
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = createTree(root, index);
    }*/



    //������ȱ���---�ö���
    public void levelOrderTraversal(TreeNode node){
        if(node==null){
            System.out.print("empty tree");
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(node);
        while(!deque.isEmpty()){
            TreeNode rnode = deque.remove();
            System.out.print(rnode.val+"  ");
            if(rnode.left!=null){
                deque.add(rnode.left);
            }
            if(rnode.right!=null){
                deque.add(rnode.right);
            }
        }
    }

    //������ȱ���---��ջ
    public void depthTraversal(TreeNode node) {
        if (node == null) {
            System.out.print("empty tree");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode rnode = stack.pop();
            System.out.print(rnode.val+"  ");
            if (rnode.right != null) {
                stack.push(rnode.right);   //�ѵ�ǰ�����Ž�ȥ���Ϳ����ҵ����ҽ��
            }
            if (rnode.left != null) {
                stack.push(rnode.left);
            }
        }
    }
}
