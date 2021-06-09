package com.demo.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;

/**
 * @Author Jusven
 * @Date 2021/4/19 17:23
 * 二叉搜索树 实现
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

    //广度优先遍历
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

    //添加结点
    public static void  insertIntoBST(int val) {
        root = insertIntoBST(root, val);
//        System.out.println(root);
    }
    //递归构建
    public static TreeNode insertIntoBST(TreeNode root, int val){
        //1.根结点为空时，直接返回
        //2.找到插入结点的位置，创建一个新结点返回(返回的位置就是调用的位置)
        if(root == null){
            return new TreeNode(val);
        }
        //加入左子树
        if(val<root.val){
            root.left = insertIntoBST(root.left,val);  //root左子树需要重新构建
        }
        //加入右子树
        if(val>root.val){
            root.right = insertIntoBST(root.right,val);
        }
        //1.返回的是二叉树的根结点；
        //2.返回当前创建的一个新结点
        return root;
    }

    //根据数值删除某结点
    public static void  deleteBST(int val) {
        root = deleteNode(root, val);
    }
    // delete 考虑不同分支情况， 删除操作也需要自顶向下遍历查找到待删除节点位置
    // 0. 待删除节点为根节点
    // 1. 待删除节点无左孩子，用右孩子替代删除节点
    // 2. 待删除节点无右孩子，用左孩子替代删除节点
    // 3. 待删除节点既有右孩子又有左孩子，找到右子树的最小值替换待删除节点，然后删除右子树最小值
    private static TreeNode deleteNode(TreeNode curNode, int key) {
        if(curNode == null)
            return  null;
        if(key<curNode.val){  //找结点，当前结点的左子树发生变化
            curNode.left = deleteNode(curNode.left,key);
        }else if(key>curNode.val){ //找结点
            curNode.right = deleteNode(curNode.right,key);
        }else{  //找到删除的结点
            if(curNode.left == null){
//                curNode = curNode.right; //删除当前结点，直接连接到右子树即可
                return curNode.right;  //返回调用位置即可
            }
            if(curNode.right == null){
//                curNode = curNode.left; //删除当前结点，直接连接到左子树即可
                return curNode.left;  //返回调用位置即可
            }
            //左右子树都不为空，先找到右子树最小结点
            TreeNode minNode = findMinNode(curNode.right);
            curNode.val = minNode.val;
            //删掉  右子树  中的那个最小结点,并且****连接上当前结点
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

    // 思路：二分查找
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
