package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Jusven
 * @Date 2021/5/11 17:48
 */
public class twosum {
    public static int[] twoSum2(int[] nums, int target) {
        //��������������±�ı���
//        Arrays.sort(nums);
        int[] array=new int[2];
        //��������
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int temp = nums[left]+nums[right];
            if(temp==target){
                array[0]=left;
                array[1]=right;
                //���ں�Ҳ��Ҫ�����ƶ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//                left++;
                break;
            }else if(temp>target){
                //��ָ������
                right--;
            }else if(temp<target){
                //��ָ������
                left++;
            }
        }
        return array;
    }

    public static int[] twoSum3(int[] nums, int target) {
        //��������������±�ı���
//        Arrays.sort(nums);
        int[] array=new int[2];
        //ʹ��map
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){   //���������value�У�˵��������ĳ������Ϊtarget
                array[0] = i;
                array[1] = hash.get(nums[i]);  //�����ҵ���ֵ���±�
                return array;
            }
            // �����ݴ��� keyΪ���� ��valueΪ�±�
            hash.put(target-nums[i],i);  //���  ��ǰ��ֵ��target�Ĳ�ֵ --- ��ǰ��ֵ�±�
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4};
        System.out.println(twoSum3(a, 6));

    }
}
