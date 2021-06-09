package com.demo.interview.EA;

import com.demo.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Jusven
 * @Date 2021/5/23 20:11
 *
 * 植物大战僵尸中，火焰僵尸每投掷一根火炬，可以点燃一棵树木和与其直接相邻的树木，但无法蔓延更远。树林的结构是一棵二叉树，火焰僵尸想知道，他最少需要多少个火炬才可以燃烧完整个树林。
 *
 * 输入：输入一个数字N，后面的N个数字代表树林的层次遍历顺序。1表示节点存在，-1表示节点不存在。
 *
 * 输出：输出一个数字，表示最少需要使用的火炬个数。
 *
 * 示例：输入5 1 1 -1 1 1，则二叉树如下，红色表示火炬使用的位置，直接相邻的树木也会被燃烧。
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
        //构造二叉树
        TreeNode root = CreateTree(array,n);

        return -1;
    }

    public static TreeNode CreateTree(int[] array, int n){
        List<TreeNode> nodeList = new LinkedList<TreeNode>();

        // 将一个数组的值依次转换为Node节点
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) { //不包括最后一个父节点
            // 左孩子
            if (nodeList.get(parentIndex * 2 + 1).val != -1)
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            // 右孩子
            if (nodeList.get(parentIndex * 2 + 2).val != -1)
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        if (nodeList.get(lastParentIndex * 2 + 1).val != -1) {
            nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
            // 右孩子,如果数组的长度为奇数才建立右孩子----因为有根节点
            if (array.length % 2 == 1 && nodeList.get(lastParentIndex * 2 + 2).val != -1) {
                nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }

}
