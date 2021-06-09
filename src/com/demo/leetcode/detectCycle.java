package com.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2021/5/21 20:14
 *
 * �жϵ������Ƿ��л�
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
        ListNode p = head;  //����ָ��

        ListNode p1 = new ListNode(2);
        p.next = p1;
        p = p.next;
        p1= new ListNode(3);
        p.next = p1;
        p = p.next;
        //��
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
            if(set.contains(p)){  //��һ����ĩβ
                return  p;
            }else {
                set.add(p);
            }
            //��������
            p = p.next;
        }
        return null;
    }
}
