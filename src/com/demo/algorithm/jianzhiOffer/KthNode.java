package com.demo.algorithm.jianzhiOffer;

import com.demo.tree.BinaryTree;
import com.demo.tree.Node;
import com.demo.tree.TreeNode;

import java.util.ArrayList;
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
    static void inOrder(Node p, List arr){
        if(p==null)
            return;
        if(p.leftChild!=null)
            inOrder(p.leftChild,arr);
        arr.add(p);
        if(p.rightChild!=null)
            inOrder(p.rightChild,arr);
    }

}
