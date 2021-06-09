package com.demo.jianzhiOffer;

import com.demo.tree.BinaryTree;
import com.demo.tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/3/5 18:53
 */
public class IsBalanced_Solution {
    public static void main(String[] args) {
        //创建二叉树
        int[] array = {  5, 6, 7, 8, 9 };
        List<Node> nodeList = new LinkedList<Node>();
        BinaryTree.createBinTree(array,nodeList);

        //1、用map存储标记位，只要有一个结点不平衡，就标记为false
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("flag",1);
        String str = "true";  //基本类型和String均为值传递

        //1.2用数组保存标志位***********88*****************************
        int[] arr = {1};

        //2、统计树的深度，同时判断每个结点是否平衡
//         TreeDepth2(root,map);
//        TreeDepth(root,arr);
        TreeDepth(nodeList.get(0),arr);

        //3、判断标记位
        if(arr[0]==1)    ////超越98%   6%
            System.out.println("是平衡二叉树");
        else
            System.out.println("不是平衡二叉树");

//        TreeDepth3(arr)

//         int flag = map.get("flag");  //超越90%   2%
//         if(flag==1)
//             return true;
//         else
//             return false;

//         if(str.equals("true"))
//             return true;
//         else
//             return false;
    }




    //用数组
    public static int TreeDepth(Node root, int[] map){
        if(root==null)
            return 0;
        int leftDepth = TreeDepth(root.leftChild,map);  //不用判断非空
        int rightDepth = TreeDepth(root.rightChild,map);  //不用判断非空
        if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//             map = "false";
            map[0] = 0;
        return Math.max(leftDepth,rightDepth)+1;  //加上本结点的深度
    }

    //用map
//     public static int TreeDepth2(TreeNode root, HashMap map){
//         if(root==null)
//             return 0;
//         int leftDepth = TreeDepth2(root.left,map);  //不用判断非空
//         int rightDepth = TreeDepth2(root.right,map);  //不用判断非空
//         if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//         return Math.max(leftDepth,rightDepth)+1;  //加上本结点的深度
//     }

    public static int TreeDepth3(Node root){
        if(root==null)
            return 0;
        //******************可以用一个标记记录左右子树不平衡****************************
        int leftDepth = TreeDepth3(root.leftChild);  //不用判断非空
        if(leftDepth==-1) return -1;
        int rightDepth = TreeDepth3(root.rightChild);  //不用判断非空
        if(rightDepth==-1) return -1;
        if(Math.abs(leftDepth-rightDepth)>1)
            return -1;
/*        if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//             map = "false";
            map[0] = 0;*/
        return Math.max(leftDepth,rightDepth)+1;  //加上本结点的深度
    }
}
