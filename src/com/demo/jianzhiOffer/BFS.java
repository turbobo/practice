package com.demo.jianzhiOffer;

import com.demo.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/4/19 14:59
 * 广度优先遍历  类似于树的层序遍历。
 * 从根节点开始，沿着树的宽度依次遍历树的每个节点
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

    public static void BFS_(TreeNode pNode){
        if(pNode == null){
            System.out.println("empty");
            return;
        }
        //用队列来存放所有根结点
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
        //加入根结点
        arrayDeque.add(pNode);  //在队列尾部添加一个元素
        while(!arrayDeque.isEmpty()){  //队列不为空
            //首先获得队列的第一个元素
            TreeNode node = arrayDeque.remove();
            System.out.println(node.val);
            //先把左右子结点加入队列中
            if(node.left!=null)
                arrayDeque.add(node.left);
            if(node.right!=null)
                arrayDeque.add(node.right);

        }
    }
}
