package com.demo.algorithm.jianzhiOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2021/3/4 19:38
 */
public class FirstNoRepeatingChar {
    public static void main(String[] args) {
        String str = "google";
        String str2 = "ggoo7";
        String str3 = "AggooAaa";
        String str4="NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println("第一个只出现一次的字符的下角标为："+FirstNotRepeatingChar_Solution(str4));
        System.out.println("第一个只出现一次的字符的下角标为："+FirstNotRepeatingChar_Solution2(str4));
        System.out.println(str+"第一个字符的位置下角标为："+str.indexOf('g'));
    }

    public static int FirstNotRepeatingChar_Solution(String str) {
        //用哈希表存储出现次数
        /*
        * HashMap是无序的，当我们希望有顺序地去存储key-value时，就需要使用LinkedHashMap了。
        * LinkedHashMap是有序的，且访问顺序默认为插入顺序。
        * Linked + HashMap，即双向链表+HashMap
        * */
//        HashMap<Object,Integer> map = new HashMap<Object,Integer>();
        LinkedHashMap <Object,Integer> map = new LinkedHashMap<Object,Integer>();
        //当前字符
//         char temp = str.charAt(0);
       /* for(int i=0;i<str.length();i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        Object ch = '0';
        for(Object key: map.keySet()){
            if(map.get(key)==1)
                break;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==char.Parse(ch))
                return i;
        }
        return -1;*/

       for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),count+1);
            }else{  //第一次出现
                map.put(str.charAt(i),1);
            }
        }
//        Object result = null;
        for(Map.Entry<Object,Integer> entry: map.entrySet()){
            if(entry.getValue()==1)
                return str.indexOf(entry.getKey().toString());
//                result = entry.getKey();   //取map中的最后一个元素
        }
//        if(result!=null)
//            return str.indexOf(result.toString());
//        else
            return -1;
    }

    public static int FirstNotRepeatingChar_Solution2(String str) {

        HashMap<Object,Integer> map = new HashMap<Object,Integer>();

        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),count+1);
            }else{  //第一次出现
                map.put(str.charAt(i),1);
            }
        }
        //直接遍历字符串即可，拿出来去map中不用遍历Map，因为Hashmap是无序的！！！！！！！！！！！！！！！！！！！！！！！！！！
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)  //字符在str中出现次数只有1次
                return i;
        }

        return -1;
    }
}
