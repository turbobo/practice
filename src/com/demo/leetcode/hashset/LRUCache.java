package com.demo.leetcode.hashset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Jusven
 * @Date 2023/1/3 22:26
 */
public class LRUCache {
    //使用HashMap + 双向链表实现  LRU (最近最少使用) 缓存
    //替代LinkedHashMap的功能

    //HashMap用来判断key是否存在 以及存取
    //双向链表负责排序、移动元素：使用虚拟头结点和尾结点


    //实际为结点，多个则构成链表
    class DoubleLinkedNode {
        //双向指针
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

//        //虚拟结点
//        DoubleLinkedList head;
//        DoubleLinkedList tail;

        //结点值,分别对应map中的key -- value
        int value;
        int key;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * LRU缓存的参数
     */
    //初始容量
    private int capacity;
    //当前容量
    private int size;

    //虚拟结点,在LRU缓存中使用虚拟结点  标识自定义的双向链表
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    //将结点放入map中保存，作为value  可以通过key获取结点在双向链表的位置！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    private Map<Integer, DoubleLinkedNode> cache = new HashMap();

    public LRUCache() {

    }

    public DoubleLinkedNode getHead() {
        return head;
    }

    public void setHead(DoubleLinkedNode head) {
        this.head = head;
    }

    //初始化容量
    public LRUCache(int capacity) {
        this.capacity = capacity;
        //创建空的双向链表
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        //建立指针连接
        head.next = this.tail;
        tail.pre = this.head;

        //初始化当前 缓存的容量
//            size = 0;   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.size = 0;

    }

    //get操作
    public int get(int key) {
        //先获取map中的结点
        DoubleLinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }
        //存在，则返回，并且要更新双向链表中的位置
        moveToHead(node);
        return node.value;
    }

    //put操作
    public void put(int key, int value) {
        //首先判断结点是否存在
        DoubleLinkedNode node = cache.get(key);
        if (null != node) {
//            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            //存在直接替换即可
//            cache.put(key,newNode);
            //此处直接移动新结点保存，新结点不在链表中！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//            moveToHead(newNode);


            //需要移动 旧结点，更新旧结点值即可，无需创建新结点
            node.value = value;  //引用类型，此node还存在map中，所以修改node之后，map中Node会更新，不用再cache.put(key,newNode);
            moveToHead(node);


        } else {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            //直接添加，然后再判断是否超出最大容量
            cache.put(key,newNode);
            ++size;
            addHead(newNode);
            if (size > capacity) {
                //移除末尾元素
                DoubleLinkedNode last = removeTail();
                //根据key移除！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！11
//                cache.remove(last);  //未删除成功
                cache.remove(last.key);
                --size;
            }



            //不存在需要判断是否超出最大容量
            //先判断当前容量
//            if (size >= capacity) {
//                //大于等于  则需要去除双向链表末尾的元素
//                //且map也要操作
//                DoubleLinkedNode last = removeTail();//链表只操作结点  不用管LRU的当前容量
//                cache.remove(last.key);
//                size--;
//            }
//
//            //未超过容量，则直接放到双向链表的开头
//            //当前容量加1
//            size++;
//            cache.put(key, newNode);
//            addHead(newNode);


        }
    }

    //map不用管 容量导致的移动操作
    //双向链表不用管 容量，只负责移动

    //在头结点处添加
    public void addHead(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        // 先操作.next.pre
        // 如果先操作next，那么next.pre就错误
        head.next.pre = node;
        head.next = node;

        //map也要添加  链表只负责移动 不负责map元素增删改  ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//            cache.put(node.key, node);
    }


    //移到最前
    public void moveToHead(DoubleLinkedNode node) {
        //先删除当前结点
        removeNode(node);
        addHead(node);
    }


    //删除最后
    public DoubleLinkedNode removeTail() {
        //尾结点位置，就是tail的前面
        DoubleLinkedNode tail_pre = tail.pre;
        removeNode(tail_pre);
        return tail_pre;
    }

    //删除指定结点
    public void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}


/* class LRUCache {
     //自行实现LinkedHashMap

     Map<Integer,Integer> linkedHashMap;
     Integer capacityMax;
     public LRUCache(int capacity) {
         capacityMax = capacity;
         linkedHashMap = new LinkedHashMap<Integer,Integer>(capacity,1.6f,true); // 访问顺序;
     }

     public int get(int key) {
         if (!linkedHashMap.containsKey(key)) {
             return -1;
         }
         return linkedHashMap.get(key);
     }

     public void put(int key, int value) {
         //如果当前key不存在，去除最近未使用的
         if (!linkedHashMap.containsKey(key) && linkedHashMap.size() == capacityMax) {
             //去除最近未使用，就是集合中的第一个元素
             Map.Entry<Integer, Integer> head = getHead(linkedHashMap);
             Integer del_key = head.getKey();
             linkedHashMap.remove(del_key);
         }
         linkedHashMap.put(key,value);
     }

     //获取LinkedHashMap中的头部元素（最早添加的元素）：时间复杂度O(1)
     public Map.Entry<Integer, Integer> getHead(Map<Integer, Integer> map) {
         return map.entrySet().iterator().next();
     }

     //通过反射获取LinkedHashMap中的末尾元素：时间复杂度O(1)，访问tail属性
     // public  Map.Entry<Integer,Integer> getTailByReflection(Map<Integer,Integer> map)
     //         throws NoSuchFieldException, IllegalAccessException {
     //     Field tail = map.getClass().getDeclaredField("tail");
     //     tail.setAccessible(true);
     //     return (Map.Entry<Integer,Integer>) tail.get(map);
     // }
 }*/
