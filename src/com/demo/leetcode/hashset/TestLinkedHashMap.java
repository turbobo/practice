package com.demo.leetcode.hashset;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2022/12/29 22:06
 */
public class TestLinkedHashMap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
            * 实例化一个LinkedHashMap;
		 *
                 * LinkedHashMap的插入顺序和访问顺序;
		 * LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder);
		 * 说明:
            * 	当accessOrder为true时表示当前数据的插入读取顺序为访问顺序；
            * 	当accessOrder为false时表示当前数据的插入读取顺序为插入顺序；
            */
        Map<String,String> linkedHashMap = new LinkedHashMap<String,String>(0,1.6f,true); // 访问顺序;
//		Map<String,String> linkedHashMap = new LinkedHashMap<String,String>(0,1.6f,false); // 插入顺序;

        // 数据插入;
        linkedHashMap.put("key_1", "value_11111");
        linkedHashMap.put("key_2", "value_22222");
        linkedHashMap.put("key_3", "value_33333");
        linkedHashMap.put("key_4", "value_44444");
        linkedHashMap.put("key_5", "value_55555");

        /**
         * 打印集合数据,看输出顺序是什么样子?
         * 首先获取Map对象的Entry对象集;
         * 然后遍历打印Entry对象;
         * 注意:此时是程序开始的第一次数据打印;
         */
        Set<Map.Entry<String,String>> entrySet = linkedHashMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet){
            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
        }

        System.out.println("*************************************8");

        // 首先随机调用数据中的一个元素;
//        linkedHashMap.remove("key_3");

        linkedHashMap.get("key_3");


        //按照插入顺序：访问时，先删除，再重新插入即可
//        linkedHashMap.remove("key_3");
//        linkedHashMap.put("key_3", "value_33333");

        /**
         * 然后以同样的方式遍历打印Entry对象;
         * 注意:此时是程序开始的第二次数据打印;
         */
        Set<Map.Entry<String,String>> entrySet2 = linkedHashMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet2){
            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
        }
        Map.Entry<String, String> head = getHead(linkedHashMap);
        String key = head.getKey();

        System.out.println(getTailByReflection((LinkedHashMap<String, String>) linkedHashMap));
        System.out.println(getHead(linkedHashMap));

    }


    //获取LinkedHashMap中的头部元素（最早添加的元素）：时间复杂度O(1)
    public static Map.Entry<String, String> getHead(Map<String, String> map) {
        return map.entrySet().iterator().next();
    }

    //通过反射获取LinkedHashMap中的末尾元素：时间复杂度O(1)，访问tail属性
    public static  Map.Entry<String,String> getTailByReflection(LinkedHashMap<String,String> map)
            throws NoSuchFieldException, IllegalAccessException {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Map.Entry<String,String>) tail.get(map);
    }

}
