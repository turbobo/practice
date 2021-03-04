package com.demo.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/3/2 19:57
 * java二叉树
 */
public class BinaryTree {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Node> nodeList = new LinkedList<Node>();
        createBinTree(array,nodeList);
        preOrderTraverse(nodeList.get(0));  //传入根节点
        System.out.println();
        Mirror(nodeList.get(0));
        preOrderTraverse(nodeList.get(0));  //传入根节点
    }
    public static void createBinTree(int[] array, List<Node> nodeList) {
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子----因为有根节点
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    //二叉树镜像----左右子树交换
    public static Node Mirror (Node pRoot) {
        if(pRoot == null){  //结束条件
            return null;
        }

        if(pRoot != null){
            //先交换本节点
            Node temp = pRoot.leftChild;
            pRoot.leftChild = pRoot.rightChild;
            pRoot.rightChild = temp;
            //再交换左右子树
            if(pRoot.leftChild != null){
                Mirror(pRoot.leftChild);  //递归
            }

            if(pRoot.rightChild != null){
                Mirror(pRoot.rightChild);  //递归
            }
        }
        return pRoot;
    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }
}
