package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

}

public class VerifySquenceOfBST {
    public static void main(String[] args) {
//        int[] arr = {4,8,6,12,16,14,10};
        int[] arr = {7,4,9,3,8,11,12,10};
        boolean flag1 = true;
        //找到第一个比根结点大的结点，然后
        int i = 0;
        for (; i < arr.length; i++) {
            if(arr[i] > arr[arr.length-1]){
                break;
            }
        }
        //大于根节点的后面存在小于根节点的值
        for (int j = i; j < arr.length; j++) {
            if(arr[j] < arr[arr.length-1]){
                flag1 = false;
                break;
            }
        }

        TreeNode root = buildBiSearchTree(arr);
        System.out.println("root = " + root);
        //后序遍历
        ArrayList<Integer> list = new ArrayList<Integer>();
        postOrder(root,list);
        boolean flag2 = true;
        for (int k = 0; k < arr.length; k++) {
            if(arr[k] != list.get(k)){
                flag2 = false;
            }
        }
        boolean result = flag1 & flag2;
        System.out.println("result = " + result);

    }

    //根据数组逆序创建二叉搜索树
    public static TreeNode buildBiSearchTree(int [] sequence){
        TreeNode root = new TreeNode(sequence[sequence.length-1]);
        TreeNode pop = root;
        //使用一个栈存放结点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(pop);
        for(int i=sequence.length-2;i>=0;i--){
            //序列当前结点和栈顶结点比较
            TreeNode newNode = new TreeNode(sequence[i]);
            pop = stack.peek();
            if(sequence[i] > pop.val){
                pop.right = newNode;
                stack.push(newNode);
            }else{
                //匹配左结点的父结点
                while(true){
                    pop = stack.pop();
                    if(stack.empty()){  //遇到根结点
                        pop.left = newNode;
                        stack.push(newNode);
                        break;
                    }
                    TreeNode peek = stack.peek();
                    if(sequence[i]<pop.val && sequence[i]>peek.val){
                        pop.left = newNode;
                        stack.push(newNode);
                        break;
                    }
                }
            }
        }
        return root;
    }

    //直接根据根节点创建二叉搜索树
    public static TreeNode buildBiSearchTreeBySequence(int [] sequence){
        TreeNode root = new TreeNode(sequence[sequence.length-1]);
        TreeNode pop = root;

        return root;
    }

    public static void postOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
}
