package com.demo.leetcode.hashset;


import sun.misc.VM;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangbo82
 * @Date: 2022年12月14日 20:03
 */
class ListNode11 {
    public int val;
    public ListNode11 next;

    public ListNode11(int x) {
        val = x;
        next = null;
    }
}

class getIntersectionNode {


    public static void main(String[] args) {
        ListNode11 headA = new ListNode11(11);
        ListNode11 p1 = new ListNode11(1);
        ListNode11 p2 = new ListNode11(2);
        ListNode11 p3 = new ListNode11(3);
        p1.next = p3;
        headA.next = p1;



        ListNode11 headB = new ListNode11(22);
        p2.next = p3;
        headB.next = p2;

        getIntersectionNode(headA,headB);
    }

    public static ListNode11 getIntersectionNode(ListNode11 headA, ListNode11 headB) {
        if (headA == null || headB == null) {
            return null;

        }
        if (headA.equals(headB)) {

        }
        //先遍历两个链表长度
        //然后取差值，从同一长度位置开始遍历
        ListNode11 p1 = headA;
        ListNode11 p2 = headB;
        int length1 = 0;
        int length2 = 0;
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }

        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }

        if (length1 < length2) {
            //交换两个链表，默认headA长
            ListNode11 temp = headA;
            headA = headB;
            headB = temp;

            int tempLen = length1;
            length1 = length2;
            length2 = tempLen;
        }

        while (length1 > length2) {
            length1--;
            headA = headA.next;
        }

        //同时遍历
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    //使用哈希表保存链表
    public static ListNode11 getIntersectionNode11(ListNode11 headA, ListNode11 headB) {
        if (headA == null || headB == null) {
            return null;

        }

        Set<ListNode11> set = new HashSet();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
