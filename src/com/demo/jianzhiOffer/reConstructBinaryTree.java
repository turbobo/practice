package com.demo.jianzhiOffer;

import com.demo.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Jusven
 * @Date 2021/3/22 20:36
 * ����ǰ������� �ؽ�������
 */
public class reConstructBinaryTree {
    public static void main(String[] args) {
//        int[] pre = {1,2,3,4,5,6,7};  //ǰ��
//        int[] in = {3,2,4,1,6,5,7};
//        Node n = reConstructBinaryTree_Solution(pre,in);

        String s=Integer.toBinaryString(6);   //����תΪ������

        int[] in = {2,3,4,5,7,8};
        int[] post = {2,4,3,8,7,5};   //����
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
        //ǰ�������������
        list.add(1);  //  f(0)
        list.add(1);  //  f(1)
        System.out.println(list.get(0));
//         list.add(2);
        for(int i=2;i<=target;i++){  //��0��ʼ��
            list.add(list.get(i-1) + list.get(i-2));
        }
        return list.get(target);
    }

    /*
    * ÿ�εݹ� ---- ǰ���������ܸ�������ͬ��
    * ��������ǰ���ؽ�������
    * */
    public static Node reConstructBinaryTree_Solution(int [] pre, int [] in) {
        //ǰ��--������ Ϊ��
        if(pre.length==0)
            return null;
        //ֻʣһ��Ԫ�أ�ֱ�ӷ���
        if(pre.length==1)
            return new Node(pre[0]);

        //��ǰ�������ǰ��ĵ�һ��Ԫ��
        int rootVal = pre[0];
        Node root = new Node(rootVal);
        int rootIndex = 0;    //���������������е�λ��

        //�������ҳ������λ�ã��ֿ���������
        for(int i=0;i<in.length;i++){
            if(in[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        //���赱ǰ��������������ѽ�����������������������㼴��
        /*
        * copyOfRange(arr,start,end)  �ָ�����[start,end)  ����ҿ�
        * */
        root.leftChild = reConstructBinaryTree_Solution(Arrays.copyOfRange(pre,1,rootIndex+1), Arrays.copyOfRange(in,0,rootIndex));
        root.rightChild = reConstructBinaryTree_Solution(Arrays.copyOfRange(pre,rootIndex+1,pre.length), Arrays.copyOfRange(in,rootIndex+1,in.length));

        //���ص�ǰ�����
        return root;
    }

    /*
     * ÿ�εݹ� ---- ǰ���������ܸ�������ͬ��
     * �������򡢺����ؽ�������
     * */
    public static Node reConstructBinaryTree_Solution2(int [] in, int [] post) {
        //����--���Ҹ� Ϊ��
        if(post.length==0)
            return null;
        //ֻʣһ��Ԫ�أ�ֱ�ӷ���
        if(post.length==1)
            return new Node(post[post.length-1]);

        //��ǰ������Ǻ���������Ǹ�Ԫ��
        int rootVal = post[post.length-1];
        Node root = new Node(rootVal);
        int rootIndex = 0;    //���������������е�λ��

        //�������ҳ������λ�ã��ֿ���������
        for(int i=0;i<in.length;i++){
            if(in[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        //���赱ǰ��������������ѽ�����������������������㼴��
        /*in
         * copyOfRange(arr,start,end)  �ָ�����[start,end)  ����ҿ�
         * */
        root.leftChild = reConstructBinaryTree_Solution2(Arrays.copyOfRange(in,0,rootIndex), Arrays.copyOfRange(post,0,rootIndex));
        //�������ĺ�������Ľ�ֹ�±�Ӧ���� ��ǰ���ڵ��λ��(��������һλ), ��������λ��   ����post.length
        root.rightChild = reConstructBinaryTree_Solution2(Arrays.copyOfRange(in,rootIndex+1,in.length), Arrays.copyOfRange(post,rootIndex,post.length-1));

        //���ص�ǰ�����
        return root;
    }
}
