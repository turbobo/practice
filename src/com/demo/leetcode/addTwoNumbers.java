package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/5/13 22:48
 * 给你两个?非空 的链表，表示两个非负的整数。它们每位数字都是按照?逆序?的方式存储的，并且每个节点只能存储?一位?数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0?开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode p1 = l1;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode p2 = l2;
        p2.next = new ListNode(9);
        p2 = p2.next;
        p2.next = new ListNode(9);
        p2 = p2.next;
        p2.next = new ListNode(9);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode node = root;
        if(l1==null || l2==null){
            return node;
        }
        int v1 = 0;
        int v2 = 0;
        int sum = 0;  //和
        int jw = 0;   //进位
        //直接从两个链表首位开始相加
        while(l1!=null && l2!=null){
//            if(l1!=null){
                v1 = l1.val;
//            }
/*            else{
                v1 = 0;
                break;
            }*/
//            if(l2!=null){
                v2 = l2.val;
/*            }else{
                v2 = 0;
                break;
            }*/
            sum = v1+v2+jw;
            //加完后置为0
            jw = 0;
            //判断是否有进位
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
//            else{
//                jw = 0;
//            }
            node.val = sum;
            if(l1.next!=null || l2.next!=null){  //l1 l2还有结点时添加新结点
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1未结束，继续遍历
//        if(l1!=null){
        while(l1!=null){
            sum = l1.val+jw;
            jw = 0;

            //判断是否有进位
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
            node.val = sum;
            if(l1.next!=null){  //l1还有结点时添加新结点
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l1 = l1.next;   //继续遍历
        }
//        if(l2!=null){
        while(l2!=null){  //继续
            sum = l2.val+jw;
            jw = 0;

            //判断是否有进位
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
            /*else{
                jw = 0;
            }*/
            node.val = sum;
            if(l2.next!=null){  //l2还有结点时添加新结点
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l2 = l2.next;   //继续遍历
        }
        if(jw==1){  //还有进位
//            node.val=1;
            //新增结点
            ListNode p = new ListNode(1);
            node.next = p;
        }
//        else{
//            node = null;
//        }
        return root;
    }

}
