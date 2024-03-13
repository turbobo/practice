package com.demo.leetcode.lianbiao;

import com.demo.algorithm.test.ListNode;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author Jusven
 * @Date 2024/3/7 22:18
 */


public class addTwoNumbersTest {
    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();
        linkedList.add("");
        HashMap map = new HashMap(10);
        ListNode p1 = new ListNode(2);
        ListNode p = p1;
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(1);
        p1.next = p2;
        p1 = p1.next;
        p1.next = p3;
        p1 = p1.next;
        p1.next = p4;


        ListNode q1 = new ListNode(5);
        ListNode q = q1;
        ListNode q2 = new ListNode(6);
        ListNode q3 = new ListNode(4);
        q1.next = q2;
        q1 = q1.next;
        q1.next = q3;
        addTwoNumbers(p,q);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Scheduled
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 从尾部去加
        ListNode p1 = l1;
        ListNode p2 = l2;

        StringBuffer sb = new StringBuffer();
        int ten_digit = 0;
        int single_digit = 0;
        int sum = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                sum = p1.val + p2.val + ten_digit;
                if (sum >= 10) {
                    single_digit = sum % 10;
                    ten_digit = 1;
                } else {
                    single_digit = sum;
                    ten_digit = 0;
                }
                sb.append(single_digit);
                p1=p1.next;
                p2=p2.next;
            } else if (p1 == null && p2 != null) {
                while (p2 != null) {
                    sum = p2.val + ten_digit;
                    if (sum >= 10) {
                        single_digit = sum % 10;
                        ten_digit = 1;
                    } else {
                        single_digit = sum;
                        ten_digit = 0;
                    }
                    sb.append(single_digit);
                    p2=p2.next;
                }
            } else if (p1 != null && p2 == null) {
                while (p1 != null) {
                    sum = p1.val + ten_digit;
                    if (sum >= 10) {
                        single_digit = sum % 10;
                        ten_digit = 1;
                    } else {
                        single_digit = sum;
                        ten_digit = 0;
                    }
                    sb.append(single_digit);
                    p1=p1.next;
                }
            }



        }
        String res = sb.toString();
        char[] arr = res.toCharArray();
        if (res.length() > 1) {
            // 反转字符串
//            char[] arr = res.toCharArray();
            arr = reverseStr(arr,0, arr.length-1);
            res = sb.toString();
        } else {
            ListNode res_node = new ListNode(Integer.valueOf(res));
            return res_node;
        }
//        char[] arr = res.toCharArray();
        ListNode res_node = new ListNode(arr[0]-'0');
        ListNode result = res_node;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]-'0');
            res_node.next = temp;
            res_node = res_node.next;

        }
        return result;

    }

    public static char[] reverseStr(char[] arr, int start, int end) {

        int i = start;
        int j = end;
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
//        return new String(arr);
    }
}
