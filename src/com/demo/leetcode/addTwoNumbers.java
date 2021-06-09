package com.demo.leetcode;

/**
 * @Author Jusven
 * @Date 2021/5/13 22:48
 * ��������?�ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ���?����?�ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
 *
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 *
 * ����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
 *
 * ���룺l1 = [2,4,3], l2 = [5,6,4]
 * �����[7,0,8]
 * ���ͣ�342 + 465 = 807.
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
        int sum = 0;  //��
        int jw = 0;   //��λ
        //ֱ�Ӵ�����������λ��ʼ���
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
            //�������Ϊ0
            jw = 0;
            //�ж��Ƿ��н�λ
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
//            else{
//                jw = 0;
//            }
            node.val = sum;
            if(l1.next!=null || l2.next!=null){  //l1 l2���н��ʱ����½��
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1δ��������������
//        if(l1!=null){
        while(l1!=null){
            sum = l1.val+jw;
            jw = 0;

            //�ж��Ƿ��н�λ
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
            node.val = sum;
            if(l1.next!=null){  //l1���н��ʱ����½��
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l1 = l1.next;   //��������
        }
//        if(l2!=null){
        while(l2!=null){  //����
            sum = l2.val+jw;
            jw = 0;

            //�ж��Ƿ��н�λ
            if(sum>9){
                jw = 1;
                sum = sum%10;
            }
            /*else{
                jw = 0;
            }*/
            node.val = sum;
            if(l2.next!=null){  //l2���н��ʱ����½��
                ListNode p = new ListNode();
                node.next = p;
                node = node.next;
            }
            l2 = l2.next;   //��������
        }
        if(jw==1){  //���н�λ
//            node.val=1;
            //�������
            ListNode p = new ListNode(1);
            node.next = p;
        }
//        else{
//            node = null;
//        }
        return root;
    }

}
