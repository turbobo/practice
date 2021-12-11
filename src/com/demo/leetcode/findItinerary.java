package com.demo.leetcode;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/12/11 20:54
 * 332. ���°����г�
 */
public class findItinerary {
    private static Deque<String> res;
    private static Map<String, Map<String, Integer>> map;

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        ArrayList<String> lists1 = new ArrayList<String>();
        lists1.add("JFK");
        lists1.add("AAA");

        ArrayList<String> lists2 = new ArrayList<String>();
        lists2.add("JFK");
        lists2.add("BBB");

        ArrayList<String> lists3= new ArrayList<String>();
        lists3.add("BBB");
        lists3.add("JFK");

        tickets.add(lists1);
        tickets.add(lists2);
        tickets.add(lists3);
        findItinerary(tickets);
    }

    private static boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//��ֹ����null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    //map��Ķ�Ӧֵ�ı�
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) return true;
                    //������߲�ͨ����res��ȥ��
                    res.removeLast();
                    //��ԭmap��Ķ�Ӧֵ
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                //��������ڣ�����յ�ŵ�value�еļ�ֵ����
                //<JFK,<AAA,1>>  <JFK,(<AAA,1>,<BBB,1>)>
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//����Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
}
