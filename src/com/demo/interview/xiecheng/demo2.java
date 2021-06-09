package com.demo.interview.xiecheng;


import java.util.*;

/**
 * @Author Jusven
 * @Date 2021/4/15 20:18
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        List<String[]> list = new ArrayList<String[]>();
        List<String> list = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        Map map = new HashMap();
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(" ".equals(str))  //空格退出
                break;
//            String[] arr_str = str.split(",");
//            list.add(arr_str);
            list.add(str);
        }
//        String a = list.get(0);
        if(list.size()==0){
            System.out.println(-1);
            return;
        }
        String key = list.get(0);  //修改包
        String ss="dand";
        System.out.println(ss.indexOf("a"));

        for(String s:list){
            if(s.indexOf(key)!=0)
                map.put(s.substring(0,1),1);
        }

        int sum = 0;
        for(Object s2:map.keySet()){
            sum += Integer.parseInt((String)s2);
        }
        System.out.println(sum);
    }
}
