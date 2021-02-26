package com.demo.algorithm.test;


public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9); //创建首结点
        ListNode nextNode;     //创建下一个结点  ************保留头结点的位置就能找到该链表
        nextNode = list1;    //指向首结点  后续操作节点都是往头节点追加
        //创建链表
        ListNode newnode = new ListNode(23);  //创建新的结点
        nextNode.next = newnode;     // 把新结点连起来
        nextNode = nextNode.next; //把结点往后移  nextNode指向最后一个结点
        newnode = new ListNode(34);  //创建新的结点
        nextNode.next = newnode;     // 把新结点连起来
        nextNode = nextNode.next; //把结点往后移  nextNode指向最后一个结点
        newnode = new ListNode(45);  //创建新的结点
        nextNode.next = newnode;     // 把新结点连起来
//        nextNode = nextNode.next; //把结点往后移  nextNode指向最后一个结点

        ListNode list2 = new ListNode(3); //创建首结点
        ListNode nextNode2;     //创建下一个结点
        nextNode2 = list2;    //指向首结点
        //创建链表
        ListNode newNode2 = new ListNode(14);  //创建新的结点
        nextNode2.next = newNode2;     // 把新结点连起来
        nextNode2 = nextNode2.next; //把结点往后移  nextNode指向最后一个结点
        newNode2 = new ListNode(44);  //创建新的结点
        nextNode2.next = newNode2;     // 把新结点连起来
        nextNode2 = nextNode2.next; //把结点往后移  nextNode指向最后一个结点
        newNode2 = new ListNode(66);  //创建新的结点
        nextNode2.next = newNode2;     // 把新结点连起来
//        nextNode2 = nextNode2.next; //把结点往后移  nextNode指向最后一个结点


        MergeFunction(list1,list2);
    }

    public static void MergeFunction(ListNode list1,ListNode list2) {
        ListNode list3=merge(list1,list2);
        while(list3 != null){
            System.out.println("第一个结点值："+ list3.val);
            list3 = list3.next;
        }
    }
    
    //类似于归并
    public static ListNode merge(ListNode list1,ListNode list2){
        ListNode newHeadNode = new ListNode(0);
        ListNode list3 = newHeadNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
//                 ListNode newNode = new ListNode(list1.val); 
                list3.next = list1;
//                 list3.next = newNode;     // 把新结点连起来
                list3 = list3.next; //把结点往后移
                list1 = list1.next;
            }else{
//                 ListNode newNode = new ListNode(list2.val); 
                list3.next = list2;
//                 list3.next = newNode;     // 把新结点连起来
                list3 = list3.next; //把结点往后移
                list2 = list2.next;
            }
        }
        //list1没遍历完************直接将剩下的整个链表赋给
        if(list1!=null){
            list3.next = list1;
//             ListNode newNode = new ListNode(list1.val); 
//             list3.next = newNode;     // 把新结点连起来
//             list3 = list3.next; //把结点往后移
//             list1 = list1.next;
        }
        //list2没有遍历完
//         while(list2==null){
        if(list2!=null){
             list3.next = list2;
//             ListNode newNode = new ListNode(list2.val); 
//             list3.next = newNode;     // 把新结点连起来
//             list3 = list3.next; //把结点往后移
//             list2 = list2.next;
        }
        return newHeadNode.next;

    }
}