package com.demo.jianzhiOffer;

import com.demo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Jusven
 * @Date 2021/4/19 15:04
 * 深度优先遍历
 * 从树的根节点开始，先遍历左子树，然后遍历右子树。
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

    public static void DFS_(TreeNode pNode){
        if(pNode == null){
            System.out.println("二叉树为空！");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //加入根结点
        stack.push(pNode);
        while(!stack.empty()){
            //取出目前的栈顶元素
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //先把右结点加入栈中
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
    }
}
