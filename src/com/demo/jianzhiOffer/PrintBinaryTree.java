package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/6/13 16:28
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
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
        //�ö��У�
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            LinkedList<TreeNode> link = new LinkedList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                link.add(t);
            }
            //����ֵ

            //���Һ��ӷ��������
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
}
