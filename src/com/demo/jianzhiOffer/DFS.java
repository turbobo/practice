package com.demo.jianzhiOffer;

import com.demo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Jusven
 * @Date 2021/4/19 15:04
 * ������ȱ���
 * �����ĸ��ڵ㿪ʼ���ȱ�����������Ȼ�������������
 */
public class DFS {
    public static void main(String[] args) {
        int[] array = {5,3,7,2,4,6,9};
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        createBinTree(array,nodeList);
        DFS_(nodeList.get(0));
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

    public static void DFS_(TreeNode pNode){
        if(pNode == null){
            System.out.println("������Ϊ�գ�");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //��������
        stack.push(pNode);
        while(!stack.empty()){
            //ȡ��Ŀǰ��ջ��Ԫ��
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //�Ȱ��ҽ�����ջ��
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
    }
}
