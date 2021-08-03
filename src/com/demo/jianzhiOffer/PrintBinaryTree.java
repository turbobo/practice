package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/6/13 16:28
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinaryTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static void main(String[] args) {
        System.out.println(String.valueOf(9393));
        System.out.println("Double.valueOf(99) = " + Double.valueOf(99));
        System.out.println("Double.valueOf(\"99\") = " + Double.valueOf("99"));
        System.out.println("Double.parseDouble(\"98\") = " + Double.parseDouble("98"));
        int[] array = {5,3,7,2,4,6,9};
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        createBinTree(array,nodeList);
        System.out.println(Print(nodeList.get(0)));
    }
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer> >();
        //用队列？
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            LinkedList<TreeNode> link = new LinkedList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                link.add(t);
            }
            //返回值

            //左右孩子放入队列中
            for(TreeNode k: link){
                temp.add(k.val);
                if(k.left != null) {
                    queue.offer(k.left);
                }
                if(k.right != null) {
                    queue.offer(k.right);
                }
            }
            result.add(temp);
        }

        return result;

    }

    public static void createBinTree(int[] array, List<TreeNode> nodeList) {
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) { //不包括最后一个父节点
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子----因为有根节点
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
    }
}
