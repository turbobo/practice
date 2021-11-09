package com.demo.interview.CTrip1108;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/11/8 18:56
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
//        HashMap<Integer, Integer> tempMap = new HashMap<>();
//        LinkedList<Map.Entry<Integer, Integer>> tempList = new LinkedList<Map.Entry<Integer, Integer>>();
        LinkedList<Map.Entry<Integer, Integer>> listRepeat = new LinkedList<Map.Entry<Integer, Integer>>();
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] arr_hole = new int[n];
        in.nextLine();
        int curr = 0;
        int curr_hole = 0;
        for (int i = 0; i < n; i++) {
            curr = in.nextInt();
            arr[i] = curr;
            curr_hole = countHole(curr);
            if (map.containsKey(curr)) {
                //重复的元素单独记录
                HashMap<Integer, Integer> tempMap = new HashMap<>();
                tempMap.put(curr, curr_hole);
                LinkedList<Map.Entry<Integer, Integer>> tempList = new LinkedList<>(map.entrySet());
                listRepeat.add(tempList.get(0));
                //清空
                tempList.clear();
                tempMap.clear();
            } else {
                map.put(curr, curr_hole);
            }
        }
        LinkedList<Map.Entry<Integer, Integer>> list = sortByHole(listRepeat, map);
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> m = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(m.getKey() + " ");
            } else {
                System.out.print(m.getKey());
            }
        }
    }

    public static LinkedList<Map.Entry<Integer, Integer>> sortByHole(LinkedList<Map.Entry<Integer, Integer>> listRepeat,
                                                                     HashMap<Integer, Integer> map) {
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        for (int i = 0; i < listRepeat.size(); i++) {
            list.add(listRepeat.get(i));
        }
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                if (res == 0) {
                    return o2.getKey() - o1.getKey();
                }
                return res;
            }
        });
        return list;
    }

    public static int countHole(int x) {
        int[] hole = new int[10];
        hole[0] = 1;
        hole[1] = 0;
        hole[2] = 0;
        hole[3] = 0;
        hole[4] = 1;
        hole[5] = 0;
        hole[6] = 1;
        hole[7] = 0;
        hole[8] = 2;
        hole[9] = 1;

        int res = 0;
        int temp = 0;
        //取每位数值
        while (x != 0) {
            temp = x % 10;
            res += hole[temp];
            x = x / 10;
        }
        return res;
    }
}
