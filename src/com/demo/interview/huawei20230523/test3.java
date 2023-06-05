package com.demo.interview.huawei20230523;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2023/5/23 21:54
 * 元器件 多种，每种可靠性高  价格高
 * 不超过总价的情况下 可靠性最高
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 预算
        int s = sc.nextInt();
        // 型号
        int n = sc.nextInt();
        // 记录最小可靠性-种类
        // 记录每个种类的  价格-可靠行
        // 每次输入后使用队列 记录每种型号 可靠性最低的类型，形成堆？
        int total = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int lowestType = 0;
        int lowestReliable = 100001;
        int lowestPrice = 0;
        int ans = 0, x;
        for(int i = 0; i < total; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b <= lowestReliable) {
                lowestReliable = b;
                lowestType = a;
                lowestPrice = c;
            }

            String d = sc.nextLine();  //换行
            // 借助数组排序，升序排序 元器件
            Map<Integer, Integer> temp = new HashMap<>();
            if (map.containsKey(a)) {
                // 记录可靠性最低的
                Map<Integer, Integer> integerIntegerMap = map.get(a);
                integerIntegerMap.put(b,c);
//                LinkedHashMap<Integer, Integer> objectObjectLinkedHashMap = new LinkedHashMap<>();
//                LinkedList<Integer> objects = new LinkedList<>();
//                objects.getFirst()
            } else {
                temp.put(b,c);
                map.put(a, temp);
            }
        }
        System.out.println(getReliable(s,n,total,map,lowestType,lowestReliable,lowestPrice));
    }
    public static int getReliable(int s, int n, int total, Map<Integer, Map<Integer, Integer>> map,
                                  int lowestType,
                                  int lowestReliable,
                                  int lowestPrice) {
        if (total == 1) {
            Map<Integer, Integer> integerIntegerMap = map.get(0);
            // 只有一个
            for (Map.Entry<Integer, Integer> e : integerIntegerMap.entrySet()) {
                if (e.getValue() > s) {
                    return -1;
                }
            }

        }
        ArrayList<Map.Entry<Integer, Map<Integer, Integer>>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Map<Integer, Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, Map<Integer, Integer>> o1, Map.Entry<Integer, Map<Integer, Integer>> o2) {
                Integer key = o1.getKey();
                return 0;
            }
        });
        // 首先找到低可靠性

        //每种元器件必须用


        return 0;
    }
}
