package com.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2021/5/21 20:14
 *
 * 判断单链表是否有环
 */
public class detectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;  //操作指针

        ListNode p1 = new ListNode(2);
        p.next = p1;
        p = p.next;
        p1= new ListNode(3);
        p.next = p1;
        p = p.next;
        //环
        ListNode p3 = p;

        p1 = new ListNode(4);
        p.next = p1;
        p = p.next;
        p1= new ListNode(5);
        p.next = p1;
        p = p.next;
        p.next = p3;
        System.out.println(soulution(head));
    }

    public static ListNode soulution(ListNode head){
        ListNode p = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while(p!=null){
            if(set.contains(p)){  //环一定在末尾
                return  p;
            }else {
                set.add(p);
            }
            //继续遍历
            p = p.next;
        }
        return null;
    }
}
