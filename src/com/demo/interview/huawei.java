package com.demo.interview;

import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/3/31 19:06
 */
public class huawei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashSet set = new HashSet();
//        String str = null;
//
//        String s = null;
//        int start;
//        str = sc.nextLine();
//        s = sc.nextLine();
//        start = sc.nextInt();
//        System.out.println(str);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if("".equals(str.trim()))
                break;
            //分割
            String[] a = str.split(" ");
            //左边是队伍
            String[] team = a[0].split("-");
            //右边是比分
            String[]  score= a[1].split(":");
            //比较得分
            if(Integer.parseInt(score[0]) > Integer.parseInt(score[1])){

                //字母所处位置
//                int index0 = score[0].toCharArray()[0] - 'a';
//                list.add(index0,list.get(index0)+3);
                if(map.containsKey(team[0])){
                    map.put(team[0],map.get(team[0])+3);
                }else{
                    map.put(team[0],3);
                }
                if(!map.containsKey(team[1])){
                    map.put(team[1],0);
                }

            }else if(Integer.parseInt(score[0]) == Integer.parseInt(score[1])){
//                int index0 = score[0].toCharArray()[0] - 'a';
//                int index1 = score[1].toCharArray()[0] - 'a';
//                list.add(index0,list.get(index0)+1);
//                list.add(index1,list.get(index1)+1);

                if(map.containsKey(team[0])){
                    map.put(team[0],map.get(team[0])+1);
                }else{
                    map.put(team[0],1);
                }
                if(!map.containsKey(team[1])){
                    map.put(team[1],1);
                }else {
                    map.put(team[1],map.get(team[1])+1);
                }
            }else {
                if(map.containsKey(team[1])){
                    map.put(team[1],map.get(team[1])+3);
                }else{
                    map.put(team[1],3);
                }
                if(!map.containsKey(score[0])){
                    map.put(team[0],0);
                }
            }
        }
//        map.put("a",3);
//        map.put("g",1);
//        map.put("c",4);
//        map.put("e",2);
//        map.put("u",0);
//        map.put("n",4);
        //排序--转为List
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue()==o1.getValue()){
                    return o1.getKey().compareTo(o2.getKey());  //按照队名排序升序
                }
                return o2.getValue().compareTo(o1.getValue());  //按分数排序降序
            }
        });
        //collections.sort()
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //输出
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1)
                System.out.print(list.get(i).getKey() + " " + list.get(i).getValue());
            else
                System.out.print(list.get(i).getKey() + " " + list.get(i).getValue()+",");
        }

    }
}
