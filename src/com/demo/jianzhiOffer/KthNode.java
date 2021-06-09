package com.demo.jianzhiOffer;

import com.demo.tree.BinaryTree;
import com.demo.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/3/18 21:31
 * ����һ�ö��������������ҳ����еĵ�kС��TreeNode��㡣
 *  {5,3,7,2,4,6,8},3
 *  ����ֵ
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
    //�������
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
    * ����������
    * */
    public static Node createBinaryTree(int[] arr){
        //��ȫ��У��
        if(arr.length==0)
            return null;

        //1���Ȱ���������Ԫ��תΪ���
        List<Node> nodeList = new LinkedList<Node>();
        for(int key: arr){
            nodeList.add(new Node(key));
        }

        //2�����������е�ÿ�����ڵ㸳�����������������һ�������
        for(int index=0;index<arr.length/2-1;index++){
            //���ӽ��
            nodeList.get(index).leftChild = nodeList.get(index*2+1);
            //�Һ��ӽ��
            nodeList.get(index).rightChild = nodeList.get(index*2+2);
        }
        //3��3�����һ�������Ҫ���⿼�ǣ�����ܸ���Ϊ���������һ�������Ż����Һ���
        nodeList.get(arr.length/2-1).leftChild = nodeList.get(arr.length-2); //����
        if(arr.length%2==1){
            nodeList.get(arr.length/2-1).rightChild = nodeList.get(arr.length-1);
        }

        //���ص��Ƕ����������ĸ����
        return nodeList.get(0);
    }

    public static Node createBinarySearchTree(int[] arr){
        if(arr.length==0)
            return null;
        //1�������
        Node bstRoot = new Node(arr[0]);
        //2���������
        for(int i=1;i<arr.length;i++){
            insertNode(bstRoot,arr[i]);
        }

        return bstRoot;
    }
    //���ĸ�����ϲ������½�㣨ֵ��data��
    public static void insertNode(Node node, int data){
        //����ֵ���ڸ����
        if(data>node.data){
            //�жϸ��ڵ��Ƿ�����ӽ��
            if(node.rightChild==null){
                node.rightChild = new Node(data);  //����ֵ�����½��
            }else{
                insertNode(node.rightChild,data);  //�����ж��ӽ��
            }
        }else{
            //�жϸ��ڵ��Ƿ�����ӽ��
            if(node.leftChild==null){
                node.leftChild = new Node(data);  //����ֵ�����½��
            }else{
                insertNode(node.leftChild,data);  //�����ж��ӽ��
            }
        }
    }

}
