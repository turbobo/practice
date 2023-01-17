package com.demo.leetcode.hashset;

import java.util.*;
import java.util.stream.Collector;

/**
 * @Author Jusven
 * @Date 2023/1/15 20:49
 */
public class topKFrequent {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,23);
        map.put(43,253);
        map.put(98,3);
        map.put(17,8976);
        map.put(435,95);
        int[] nums = new int[]{23,4534,234};
        for (int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }


        // 1、先定义比较器
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 降序
                return o2.getValue() - o1.getValue();
            }
        };

        // 2、map转为键值对，保存至List
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(map.entrySet());


        // 3、使用比较器
        Collections.sort(entryArrayList, comparator);

        //entryArrayList已经排序
        for (Map.Entry<Integer, Integer> entry : entryArrayList) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }

//        List<Integer> list = new ArrayList<>();
//        Integer[] integers = list.toArray(new Integer[list.size()]);

        //通过stream()方法拿到流对象，mapToInt拿到Int流对象，就可以toArray返回int数组了
        //这里x->x是lambda表达式，对应一个函数式接口，因为集合中泛型为Interger类型，自动拆箱功能，所以直接返回x就行
        //如果这里式String泛型要转为int数组的话，就要调用Integer.parseInt()方法，lambda写法：mapToInt(Integer::parseInt)
        ArrayList<Integer> list = new ArrayList<>();
        int[] ints = list.stream().mapToInt(x -> x).toArray();




        // 二、使用队列==堆，可以获取堆最小次数的元素，然后判断是否入队
        // 类似于k叉树
        // 作用是每次以O(1)取出队列中权值最小的元素,再以O(logK)维护队列,K为堆大小
        // 每次操作 O(logK)  n个元素  n*logK
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 对map进行升序排序  只保存次数大于等于 k的元素
                return map.get(o1) - map.get(o2);
            }
        });



        int k = 23;

        // 题目 约定没有相同次数的 元素
        // 遍历map元素
        // O(nlogk)
        //遍历map元素
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            //当前queue不超过k个，直接入队
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                // 首先queue最少出现次数的元素
                Integer peek = queue.peek();
                Integer count = map.get(peek);
                if (count <= entry.getValue()) {
                    queue.poll();
                    queue.add(entry.getKey());
                }


            }
        }

        while (queue.size() > 0) {
            list.add(queue.poll());
        }

        list.stream().mapToInt(e -> e).toArray();
        System.out.println();



    }


}
