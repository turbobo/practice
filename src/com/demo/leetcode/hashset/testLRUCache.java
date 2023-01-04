package com.demo.leetcode.hashset;

/**
 * @Author Jusven
 * @Date 2023/1/4 12:45
 */
public class testLRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        print(lruCache);

        lruCache.put(2,2);
        print(lruCache);

        lruCache.get(2);
        print(lruCache);


        lruCache.put(1,1);
        print(lruCache);

        lruCache.put(4,1);
        print(lruCache);

        lruCache.get(2);
        print(lruCache);



    }

    public static void print(LRUCache lruCache) {
        LRUCache.DoubleLinkedNode head = lruCache.getHead();
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println("************************************");

    }
}
