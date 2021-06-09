package com.demo.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;

/**
 * @Author Jusven
 * @Date 2021/4/19 17:23
 * ���������� ʵ��
 */
public class BSTTree {
    public static void main(String[] args) {
        insertIntoBST(56);
        insertIntoBST(234);
        insertIntoBST(43);
        insertIntoBST(58);
        insertIntoBST(1);
        insertIntoBST(4);
        insertIntoBST(33);
        levelOrderTraversal(root);
        deleteBST(43);
        System.out.println();
        levelOrderTraversal(root);

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // construct
        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    //������ȱ���
    public static void levelOrderTraversal(TreeNode node){
        if(node==null){
            System.out.println("empty tree");
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

    //��ӽ��
    public static void  insertIntoBST(int val) {
        root = insertIntoBST(root, val);
//        System.out.println(root);
    }
    //�ݹ鹹��
    public static TreeNode insertIntoBST(TreeNode root, int val){
        //1.�����Ϊ��ʱ��ֱ�ӷ���
        //2.�ҵ��������λ�ã�����һ���½�㷵��(���ص�λ�þ��ǵ��õ�λ��)
        if(root == null){
            return new TreeNode(val);
        }
        //����������
        if(val<root.val){
            root.left = insertIntoBST(root.left,val);  //root��������Ҫ���¹���
        }
        //����������
        if(val>root.val){
            root.right = insertIntoBST(root.right,val);
        }
        //1.���ص��Ƕ������ĸ���㣻
        //2.���ص�ǰ������һ���½��
        return root;
    }

    //������ֵɾ��ĳ���
    public static void  deleteBST(int val) {
        root = deleteNode(root, val);
    }
    // delete ���ǲ�ͬ��֧����� ɾ������Ҳ��Ҫ�Զ����±������ҵ���ɾ���ڵ�λ��
    // 0. ��ɾ���ڵ�Ϊ���ڵ�
    // 1. ��ɾ���ڵ������ӣ����Һ������ɾ���ڵ�
    // 2. ��ɾ���ڵ����Һ��ӣ����������ɾ���ڵ�
    // 3. ��ɾ���ڵ�����Һ����������ӣ��ҵ�����������Сֵ�滻��ɾ���ڵ㣬Ȼ��ɾ����������Сֵ
    private static TreeNode deleteNode(TreeNode curNode, int key) {
        if(curNode == null)
            return  null;
        if(key<curNode.val){  //�ҽ�㣬��ǰ���������������仯
            curNode.left = deleteNode(curNode.left,key);
        }else if(key>curNode.val){ //�ҽ��
            curNode.right = deleteNode(curNode.right,key);
        }else{  //�ҵ�ɾ���Ľ��
            if(curNode.left == null){
//                curNode = curNode.right; //ɾ����ǰ��㣬ֱ�����ӵ�����������
                return curNode.right;  //���ص���λ�ü���
            }
            if(curNode.right == null){
//                curNode = curNode.left; //ɾ����ǰ��㣬ֱ�����ӵ�����������
                return curNode.left;  //���ص���λ�ü���
            }
            //������������Ϊ�գ����ҵ���������С���
            TreeNode minNode = findMinNode(curNode.right);
            curNode.val = minNode.val;
            //ɾ��  ������  �е��Ǹ���С���,����****�����ϵ�ǰ���
            curNode.right = deleteNode(curNode.right,minNode.val);
        }
        return curNode;
    }

    private static TreeNode findMinNode(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    // search
    public int searchBST(int val) {
        TreeNode target = searchBST(root, val);
        return target == null ? -1 : target.val;
    }

    // ˼·�����ֲ���
    private TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
