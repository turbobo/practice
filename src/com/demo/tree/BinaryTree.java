package com.demo.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/3/2 19:57
 * java������
 */
public class BinaryTree {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Node> nodeList = new LinkedList<Node>();
        createBinTree(array,nodeList);
        preOrderTraverse(nodeList.get(0));  //������ڵ�
        System.out.println();
        Mirror(nodeList.get(0));
        preOrderTraverse(nodeList.get(0));  //������ڵ�
    }
    public static void createBinTree(int[] array, List<Node> nodeList) {
        // ��һ�������ֵ����ת��ΪNode�ڵ�
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // ����
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            // �Һ���
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������
        int lastParentIndex = array.length / 2 - 1;
        // ����
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���----��Ϊ�и��ڵ�
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    //����������----������������
    public static Node Mirror (Node pRoot) {
        if(pRoot == null){  //��������
            return null;
        }

        if(pRoot != null){
            //�Ƚ������ڵ�
            Node temp = pRoot.leftChild;
            pRoot.leftChild = pRoot.rightChild;
            pRoot.rightChild = temp;
            //�ٽ�����������
            if(pRoot.leftChild != null){
                Mirror(pRoot.leftChild);  //�ݹ�
            }

            if(pRoot.rightChild != null){
                Mirror(pRoot.rightChild);  //�ݹ�
            }
        }
        return pRoot;
    }

    /**
     * �������
     *
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
     *
     * @param node
     *            �����Ľڵ�
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * �������
     *
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
     *
     * @param node
     *            �����Ľڵ�
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * �������
     *
     * �����ֲ�ͬ�ı����ṹ����һ���ģ�ֻ���Ⱥ�˳��һ������
     *
     * @param node
     *            �����Ľڵ�
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }
}
