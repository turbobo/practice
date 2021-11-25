package com.demo.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author Jusven
 * @Date 2021/11/23 17:46
 * ����һ���ѡ�� c ��һ��Ŀ���� t ���ҳ���ѡ���������͵��� t ��������ϡ�
 *
 *  c �е�ÿ��������һ�������ֻ��ʹ��һ�Ρ�
 */
public class combinationSum2 {
    public static void main(String[] args) {
        int[] arr = new int[]{22,49,5,24,26};
        System.out.println(combinationSum2(arr, 77));
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        //���
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        //��ǰ·�����
        LinkedList<Integer> path = new LinkedList<Integer>();
        //��ǰ�ܺ�
        int tempSum = 0;
        backTrack(num,target,0,path,res,tempSum);
        return res;
    }

    public static void backTrack(int[] num, int target, int start,
                          LinkedList<Integer> path, ArrayList<ArrayList<Integer>> res,
                          int tempSum){
        //��������,path������
        if(tempSum == target){
            ArrayList<Integer> list = new ArrayList<>(path);
            Collections.sort(list);
            res.add(list);
            return;
        }
        for(int i=start;i<num.length;i++){
            //����ǰ���
            path.add(num[i]);
            tempSum += num[i];
            //�ݹ�
            backTrack(num,target,i+1,path,res,tempSum);
            //����
            tempSum -= num[i];
            path.removeLast();
        }
    }

}
