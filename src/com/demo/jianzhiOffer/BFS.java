package com.demo.jianzhiOffer;

import com.demo.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/4/19 14:59
 * ������ȱ���  ���������Ĳ��������
 * �Ӹ��ڵ㿪ʼ���������Ŀ�����α�������ÿ���ڵ�
 */

public class BFS {
    public static void main(String[] args) {
        int[] array = {5,3,7,2,4,6,9};
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        createBinTree(array,nodeList);
        BFS_(nodeList.get(0));
    }
    public static void createBinTree(int[] array, List<TreeNode> nodeList) {
        // ��һ�������ֵ����ת��ΪNode�ڵ�
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) { //���������һ�����ڵ�
            // ����
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            // �Һ���
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������
        int lastParentIndex = array.length / 2 - 1;
        // ����
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���----��Ϊ�и��ڵ�
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    public static void BFS_(TreeNode pNode){
        if(pNode == null){
            System.out.println("empty");
            return;
        }
        //�ö�����������и����
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
        //��������
        arrayDeque.add(pNode);  //�ڶ���β�����һ��Ԫ��
        while(!arrayDeque.isEmpty()){  //���в�Ϊ��
            //���Ȼ�ö��еĵ�һ��Ԫ��
            TreeNode node = arrayDeque.remove();
            System.out.println(node.val);
            //�Ȱ������ӽ����������
            if(node.left!=null)
                arrayDeque.add(node.left);
            if(node.right!=null)
                arrayDeque.add(node.right);

        }
    }
}
