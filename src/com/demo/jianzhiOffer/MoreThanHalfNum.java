package com.demo.jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
* 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
* 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
* */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        String s="";
        char ch = 's';
        int[] a = {1,2,5,5,7,8,5,2,2,2,3,2,2,2,};
//        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("数组中出现的次数超过数组长度的一半的数字为："+MoreThanHalfNum_Solution2(a));
    }

    public static int MoreThanHalfNum_Solution2(int [] array){
        int temp = array[0];   //temp存放出现最多的元素
        int count = 1;
        //1、先找出 出现最多的数字----不一定是次数大于数组长度一半
        for(int i=1;i<array.length;i++){
            if(array[i]==temp){
                count++;
            }else{  //值不同，重新统计
                count--;   //将之前重复的次数都减去了---如果该数字出现次数大于数组一半，在数组遍历完之前，它的次数肯定不会减完，所有temp还会是该数字
            }
            //该数字第一次出现  重新赋值temp
            if(count==0){
                temp=array[i];
                count=1;
            }
        }
        //2、统计该数字次数
        count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp)
                count++;
        }
        return count>array.length/2 ? temp : 0;
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        //使用哈希表存储元素出现次数
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //遍历数组，统计次数
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){  //第一次统计
                map.put(array[i],1);
            }
            else{
                int currCount = map.get(array[i]);
                currCount++;
                map.put(array[i],currCount);
            }
        }
        int haflArray = array.length/2;
        //找出出现次数 超过数组长度的一半元素
        for(int key : map.keySet()) {  //map.keySet()---获取Map集合的所有键名
            if(map.get(key)>haflArray)
                return key;
        }
        
        return 0;
    }
}