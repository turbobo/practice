package com.demo.jianzhiOffer;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/28 23:06
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
//        System.out.println(FindNumbersWithSum(a,15));
        System.out.println(FindNumbersWithSum2(a,15));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //直接循环遍历，用Map存储
        for (int i = 0; i < array.length; i++) {
            if (map.containsValue(array[i]))  //数组递增，同样的值key不可能出现; 需要判断value值是否已存在
                continue;
            for (int j = 0; j < array.length; j++) {
                if (j == i)   //不可与自身相加, value值里也不可存在j
                    continue;
                if (array[i] + array[j] == sum) {
                    //放两个值
//                    map.put(array[i], array[j]);

                    //放一个值和乘积
                    map.put(array[i], array[i]*array[j]);
                }
            }
        }
        if(!map.isEmpty()){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//                @Override  //放两个值
//                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                    return (o1.getKey() * o1.getValue()) - (o2.getKey() * o2.getValue());  //按照乘积排序
//                }

                @Override  //直接比较乘积--->value
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();  //按照乘积排序
                }
            });
            Map.Entry<Integer, Integer> m = list.get(0);
            //放两个值
//            resultList.add(m.getKey());
//            resultList.add(m.getValue());

            //放一个值和乘积
            resultList.add(m.getKey());
            resultList.add(sum-m.getKey());
        }
        return resultList;

    }

    //双指针解法
    public static ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //有效校验
        if(array.length<2)
            return resultList;

        //左右指针从前 后往中间遍历
        int left = 0;
        int right = array.length-1;
        int tempSum = 0;
        while(left<right){   //左右指针不能相遇
            tempSum = array[left] + array[right];
            if(tempSum < sum){  //左指针右移
                left++;
//                tempSum = array[left] + array[right];
            }else if(tempSum > sum){  //右指针左移
                right--;
//                tempSum = array[left] + array[right];
            }else{
                //放一个值和乘积
                map.put(array[left], array[left]*array[right]);

                //继续移动指针**************************************
                right--;
            }
        }
        if(!map.isEmpty()){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//                @Override  //放两个值
//                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                    return (o1.getKey() * o1.getValue()) - (o2.getKey() * o2.getValue());  //按照乘积排序
//                }

                @Override  //直接比较乘积--->value
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();  //按照乘积排序
                }
            });
            Map.Entry<Integer, Integer> m = list.get(0);

            //放一个值和乘积
            resultList.add(m.getKey());
            resultList.add(sum-m.getKey());
        }

        return resultList;
    }
}
