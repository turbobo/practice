package com.demo.interview.EA;

import com.demo.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/5/23 20:11
 *
 * ֲ���ս��ʬ�У����潩ʬÿͶ��һ����棬���Ե�ȼһ����ľ������ֱ�����ڵ���ľ�����޷����Ӹ�Զ�����ֵĽṹ��һ�ö����������潩ʬ��֪������������Ҫ���ٸ����ſ���ȼ�����������֡�
 *
 * ���룺����һ������N�������N�����ִ������ֵĲ�α���˳��1��ʾ�ڵ���ڣ�-1��ʾ�ڵ㲻���ڡ�
 *
 * ��������һ�����֣���ʾ������Ҫʹ�õĻ�������
 *
 * ʾ��������5 1 1 -1 1 1������������£���ɫ��ʾ���ʹ�õ�λ�ã�ֱ�����ڵ���ľҲ�ᱻȼ�ա�
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        TreeNode left;
        TreeNode right;
    }
}

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(arr, n));
    }
    public static int cal(int[] array, int n) {
        if (n == 1) {
            return 1;
        }
        //���������
        TreeNode root = CreateTree(array,n);

        return -1;
    }

    public static TreeNode CreateTree(int[] array, int n){
        List<TreeNode> nodeList = new LinkedList<TreeNode>();

        // ��һ�������ֵ����ת��ΪNode�ڵ�
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) { //���������һ�����ڵ�
            // ����
            if (nodeList.get(parentIndex * 2 + 1).val != -1)
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            // �Һ���
            if (nodeList.get(parentIndex * 2 + 2).val != -1)
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������
        int lastParentIndex = array.length / 2 - 1;
        // ����
        if (nodeList.get(lastParentIndex * 2 + 1).val != -1) {
            nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
            // �Һ���,�������ĳ���Ϊ�����Ž����Һ���----��Ϊ�и��ڵ�
            if (array.length % 2 == 1 && nodeList.get(lastParentIndex * 2 + 2).val != -1) {
                nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }

}
