package com.demo.concurrency.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author Jusven
 * @Date 2023/5/7 19:24
 * list集合线程不安全
 */
public class ThreadDemo4 {
    public static void main(String[] args) {

        // ArrayList线程不安全
//        List<String> list = new ArrayList<>();

        // 解决1：vector线程安全
//        List<String> list = new Vector<>();

        // 解决2：Collections
//        List<String> list = Collections.synchronizedList(new ArrayList<>());


        // 解决3： CopyOnWriteArrayList
//        List<String> list = new CopyOnWriteArrayList<>();



        // ======= hashset不安全
//        Set<String> list = new HashSet<>();
        // 安全--写时复制
        Set<String> list = new CopyOnWriteArraySet<>();

        /*for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 添加元素----一个线程在向list添加数据
                list.add(String.valueOf(UUID.randomUUID().toString().substring(0, 8)));
                // 获取元素----另一个线程在从list中取元素，导致出现并发修改异常
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/

        // ========map
//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, String.valueOf(UUID.randomUUID().toString().substring(0, 8)));

                System.out.println(map);
            }, String.valueOf(i)).start();
        }


    }
}
