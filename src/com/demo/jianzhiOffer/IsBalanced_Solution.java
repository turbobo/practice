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
        //����������
        int[] array = {  5, 6, 7, 8, 9 };
        List<Node> nodeList = new LinkedList<Node>();
        BinaryTree.createBinTree(array,nodeList);

        //1����map�洢���λ��ֻҪ��һ����㲻ƽ�⣬�ͱ��Ϊfalse
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("flag",1);
        String str = "true";  //�������ͺ�String��Ϊֵ����

        //1.2�����鱣���־λ***********88*****************************
        int[] arr = {1};

        //2��ͳ��������ȣ�ͬʱ�ж�ÿ������Ƿ�ƽ��
//         TreeDepth2(root,map);
//        TreeDepth(root,arr);
        TreeDepth(nodeList.get(0),arr);

        //3���жϱ��λ
        if(arr[0]==1)    ////��Խ98%   6%
            System.out.println("��ƽ�������");
        else
            System.out.println("����ƽ�������");

//        TreeDepth3(arr)

//         int flag = map.get("flag");  //��Խ90%   2%
//         if(flag==1)
//             return true;
//         else
//             return false;

//         if(str.equals("true"))
//             return true;
//         else
//             return false;
    }




    //������
    public static int TreeDepth(Node root, int[] map){
        if(root==null)
            return 0;
        int leftDepth = TreeDepth(root.leftChild,map);  //�����жϷǿ�
        int rightDepth = TreeDepth(root.rightChild,map);  //�����жϷǿ�
        if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//             map = "false";
            map[0] = 0;
        return Math.max(leftDepth,rightDepth)+1;  //���ϱ��������
    }

    //��map
//     public static int TreeDepth2(TreeNode root, HashMap map){
//         if(root==null)
//             return 0;
//         int leftDepth = TreeDepth2(root.left,map);  //�����жϷǿ�
//         int rightDepth = TreeDepth2(root.right,map);  //�����жϷǿ�
//         if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//         return Math.max(leftDepth,rightDepth)+1;  //���ϱ��������
//     }

    public static int TreeDepth3(Node root){
        if(root==null)
            return 0;
        //******************������һ����Ǽ�¼����������ƽ��****************************
        int leftDepth = TreeDepth3(root.leftChild);  //�����жϷǿ�
        if(leftDepth==-1) return -1;
        int rightDepth = TreeDepth3(root.rightChild);  //�����жϷǿ�
        if(rightDepth==-1) return -1;
        if(Math.abs(leftDepth-rightDepth)>1)
            return -1;
/*        if(Math.abs(leftDepth-rightDepth)>1)
//             map.put("flag",0);
//             map = "false";
            map[0] = 0;*/
        return Math.max(leftDepth,rightDepth)+1;  //���ϱ��������
    }
}
