//package com.demo.jianzhiOffer;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Stack;
//
///**
// * @Author Jusven
// * @Date 2021/9/8 21:32
// * ����һ�������ͷ�ڵ㣬�������β��ͷ��˳�򷵻�ÿ���ڵ��ֵ�������鷵�أ���
// */
//public class printListFromTailToHead {
//
//    public  class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
//        Stack<Integer> stack = new Stack<Integer>();
//        ArrayList<Integer> res = new ArrayList<Integer>();
//
//        ListNode p = listNode;
//        while (p!=null){
////            stack.push(p.val);
//            res.add(p.val);
//            p = p.next;
//        }
////        while (!stack.isEmpty()){
////            res.add(stack.pop());
////        }
//        Collections.reverse(res);
////        System.out.println(res);
//        return res;
//    }
//}
