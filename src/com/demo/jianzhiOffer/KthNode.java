package com.demo.jianzhiOffer;

import com.demo.tree.BinaryTree;
import com.demo.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/3/18 21:31
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 *  {5,3,7,2,4,6,8},3
 *  返回值
 *  {4}
 *
 */
public class KthNode {
    public static void main(String[] args) {
        int[] array = {5,3,7,2,4,6,8,1};
        Node nRoot = createBinaryTree(array);
        Node nRoot2 =createBinarySearchTree(array);


        List<Node> nodeList = null;
        BinaryTree.createBinTree(new int[]{5,3,7,2,4,6,8}, nodeList);
        KthNode(nodeList.get(0),3);
    }
    static Node KthNode(Node pRoot, int k) {
        ArrayList<Node> list = new ArrayList<Node> ();
        inOrder(pRoot,list);
        return list.get(k-1);
    }
    //中序遍历
    public static void inOrder(Node p, List arr){
        if(p==null)
            return;
        if(p.leftChild!=null)
            inOrder(p.leftChild,arr);
        arr.add(p);
        if(p.rightChild!=null)
            inOrder(p.rightChild,arr);
    }

    /*
    * 创建二叉树
    * */
    public static Node createBinaryTree(int[] arr){
        //安全性校验
        if(arr.length==0)
            return null;

        //1、先把所有数组元素转为结点
        List<Node> nodeList = new LinkedList<Node>();
        for(int key: arr){
            nodeList.add(new Node(key));
        }

        //2、给二叉树中的每个父节点赋左右子树，除了最后一个父结点
        for(int index=0;index<arr.length/2-1;index++){
            //左孩子结点
            nodeList.get(index).leftChild = nodeList.get(index*2+1);
            //右孩子结点
            nodeList.get(index).rightChild = nodeList.get(index*2+2);
        }
        //3、3、最后一个结点需要特殊考虑，结点总个数为奇数，最后一个父结点才会有右孩子
        nodeList.get(arr.length/2-1).leftChild = nodeList.get(arr.length-2); //左孩子
        if(arr.length%2==1){
            nodeList.get(arr.length/2-1).rightChild = nodeList.get(arr.length-1);
        }

        //返回的是二叉搜索树的根结点
        return nodeList.get(0);
    }

    public static Node createBinarySearchTree(int[] arr){
        if(arr.length==0)
            return null;
        //1、根结点
        Node bstRoot = new Node(arr[0]);
        //2、其他结点
        for(int i=1;i<arr.length;i++){
            insertNode(bstRoot,arr[i]);
        }

        return bstRoot;
    }
    //往哪个结点上插入子新结点（值是data）
    public static void insertNode(Node node, int data){
        //插入值大于父结点
        if(data>node.data){
            //判断父节点是否存在子结点
            if(node.rightChild==null){
                node.rightChild = new Node(data);  //插入值构建新结点
            }else{
                insertNode(node.rightChild,data);  //继续判断子结点
            }
        }else{
            //判断父节点是否存在子结点
            if(node.leftChild==null){
                node.leftChild = new Node(data);  //插入值构建新结点
            }else{
                insertNode(node.leftChild,data);  //继续判断子结点
            }
        }
    }

}
