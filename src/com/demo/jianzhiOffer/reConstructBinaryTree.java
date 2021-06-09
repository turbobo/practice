package com.demo.jianzhiOffer;

import com.demo.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/22 20:36
 * 根据前序和中序 重建二叉树
 */
public class reConstructBinaryTree {
    public static void main(String[] args) {
//        int[] pre = {1,2,3,4,5,6,7};  //前序
//        int[] in = {3,2,4,1,6,5,7};
//        Node n = reConstructBinaryTree_Solution(pre,in);

        String s=Integer.toBinaryString(6);   //数字转为二进制

        int[] in = {2,3,4,5,7,8};
        int[] post = {2,4,3,8,7,5};   //后序
        Node n = reConstructBinaryTree_Solution2(in,post);
        test(4);

        rectCover(3);

    }

    public static int rectCover(int target) {
        if(target<=2)
            return target;
        int[] arr = new int[target];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<=target;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }

    public static int test(int target){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //前两种种特殊情况
        list.add(1);  //  f(0)
        list.add(1);  //  f(1)
        System.out.println(list.get(0));
//         list.add(2);
        for(int i=2;i<=target;i++){  //从0开始的
            list.add(list.get(i-1) + list.get(i-2));
        }
        return list.get(target);
    }

    /*
    * 每次递归 ---- 前序和中序的总个数是相同的
    * 根据中序、前序重建二叉树
    * */
    public static Node reConstructBinaryTree_Solution(int [] pre, int [] in) {
        //前序--根左右 为空
        if(pre.length==0)
            return null;
        //只剩一个元素，直接返回
        if(pre.length==1)
            return new Node(pre[0]);

        //当前根结点是前序的第一个元素
        int rootVal = pre[0];
        Node root = new Node(rootVal);
        int rootIndex = 0;    //根结点在中序遍历中的位置

        //在中序找出根结点位置，分开左右子树
        for(int i=0;i<in.length;i++){
            if(in[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        //假设当前根结点左右子树已建立，将左右子树赋给根结点即可
        /*
        * copyOfRange(arr,start,end)  分割数组[start,end)  左闭右开
        * */
        root.leftChild = reConstructBinaryTree_Solution(Arrays.copyOfRange(pre,1,rootIndex+1), Arrays.copyOfRange(in,0,rootIndex));
        root.rightChild = reConstructBinaryTree_Solution(Arrays.copyOfRange(pre,rootIndex+1,pre.length), Arrays.copyOfRange(in,rootIndex+1,in.length));

        //返回当前根结点
        return root;
    }

    /*
     * 每次递归 ---- 前序和中序的总个数是相同的
     * 根据中序、后序重建二叉树
     * */
    public static Node reConstructBinaryTree_Solution2(int [] in, int [] post) {
        //后序--左右根 为空
        if(post.length==0)
            return null;
        //只剩一个元素，直接返回
        if(post.length==1)
            return new Node(post[post.length-1]);

        //当前根结点是后序的最后的那个元素
        int rootVal = post[post.length-1];
        Node root = new Node(rootVal);
        int rootIndex = 0;    //根结点在中序遍历中的位置

        //在中序找出根结点位置，分开左右子树
        for(int i=0;i<in.length;i++){
            if(in[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        //假设当前根结点左右子树已建立，将左右子树赋给根结点即可
        /*in
         * copyOfRange(arr,start,end)  分割数组[start,end)  左闭右开
         * */
        root.leftChild = reConstructBinaryTree_Solution2(Arrays.copyOfRange(in,0,rootIndex), Arrays.copyOfRange(post,0,rootIndex));
        //右子树的后序遍历的截止下标应该是 当前根节点的位置(后序的最后一位), 不包含该位置   不是post.length
        root.rightChild = reConstructBinaryTree_Solution2(Arrays.copyOfRange(in,rootIndex+1,in.length), Arrays.copyOfRange(post,rootIndex,post.length-1));

        //返回当前根结点
        return root;
    }
}
