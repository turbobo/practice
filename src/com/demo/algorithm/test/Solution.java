package com.demo.algorithm.test;


public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9); //�����׽��
        ListNode nextNode;     //������һ�����  ************����ͷ����λ�þ����ҵ�������
        nextNode = list1;    //ָ���׽��  ���������ڵ㶼����ͷ�ڵ�׷��
        //��������
        ListNode newnode = new ListNode(23);  //�����µĽ��
        nextNode.next = newnode;     // ���½��������
        nextNode = nextNode.next; //�ѽ��������  nextNodeָ�����һ�����
        newnode = new ListNode(34);  //�����µĽ��
        nextNode.next = newnode;     // ���½��������
        nextNode = nextNode.next; //�ѽ��������  nextNodeָ�����һ�����
        newnode = new ListNode(45);  //�����µĽ��
        nextNode.next = newnode;     // ���½��������
//        nextNode = nextNode.next; //�ѽ��������  nextNodeָ�����һ�����

        ListNode list2 = new ListNode(3); //�����׽��
        ListNode nextNode2;     //������һ�����
        nextNode2 = list2;    //ָ���׽��
        //��������
        ListNode newNode2 = new ListNode(14);  //�����µĽ��
        nextNode2.next = newNode2;     // ���½��������
        nextNode2 = nextNode2.next; //�ѽ��������  nextNodeָ�����һ�����
        newNode2 = new ListNode(44);  //�����µĽ��
        nextNode2.next = newNode2;     // ���½��������
        nextNode2 = nextNode2.next; //�ѽ��������  nextNodeָ�����һ�����
        newNode2 = new ListNode(66);  //�����µĽ��
        nextNode2.next = newNode2;     // ���½��������
//        nextNode2 = nextNode2.next; //�ѽ��������  nextNodeָ�����һ�����


        MergeFunction(list1,list2);
    }

    public static void MergeFunction(ListNode list1,ListNode list2) {
        ListNode list3=merge(list1,list2);
        while(list3 != null){
            System.out.println("��һ�����ֵ��"+ list3.val);
            list3 = list3.next;
        }
    }
    
    //�����ڹ鲢
    public static ListNode merge(ListNode list1,ListNode list2){
        ListNode newHeadNode = new ListNode(0);
        ListNode list3 = newHeadNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
//                 ListNode newNode = new ListNode(list1.val); 
                list3.next = list1;
//                 list3.next = newNode;     // ���½��������
                list3 = list3.next; //�ѽ��������
                list1 = list1.next;
            }else{
//                 ListNode newNode = new ListNode(list2.val); 
                list3.next = list2;
//                 list3.next = newNode;     // ���½��������
                list3 = list3.next; //�ѽ��������
                list2 = list2.next;
            }
        }
        //list1û������************ֱ�ӽ�ʣ�µ�����������
        if(list1!=null){
            list3.next = list1;
//             ListNode newNode = new ListNode(list1.val); 
//             list3.next = newNode;     // ���½��������
//             list3 = list3.next; //�ѽ��������
//             list1 = list1.next;
        }
        //list2û�б�����
//         while(list2==null){
        if(list2!=null){
             list3.next = list2;
//             ListNode newNode = new ListNode(list2.val); 
//             list3.next = newNode;     // ���½��������
//             list3 = list3.next; //�ѽ��������
//             list2 = list2.next;
        }
        return newHeadNode.next;

    }
}