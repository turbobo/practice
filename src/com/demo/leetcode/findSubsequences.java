package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2021/12/10 22:01
 */
public class findSubsequences {
    static List<List<Integer>> res = new ArrayList();
    //��ǰ·�����
    static LinkedList<Integer> path = new LinkedList<Integer>();

    public static void main(String[] args) {
        findSubsequences(new int[]{4,4,3,2});
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        // Arrays.sort(nums);
        // boolean[] used = new boolean[10];
        backTrack(nums,0);
        return res;
    }

    public static void backTrack(int[] nums, int startIndex){
        if(path.size()>=2){
            res.add(new ArrayList(path));
        }
        if(startIndex >= nums.length){
            return;
        }
        //ֻ��¼������(��¼���ֵ)
        int[] used = new int[201];  // -100 <= nums[i] <= 100  -100��100��201����
        for(int i = startIndex;i<nums.length;i++){
            //�������
            //used[i+100] ���ָ���������
            if ((path.size()>0 && path.getLast() > nums[i]) || used[nums[i]+100] == 1){
                continue;
            }
            else{
                path.add(nums[i]);
                used[nums[i]+100] = 1;
                //�ݹ�  �������¸�λ�ÿ�ʼ
                backTrack(nums,i+1);
                //����
                path.removeLast();
                // used[i] = false;


            }

        }

    }
}
