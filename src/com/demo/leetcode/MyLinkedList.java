//package com.demo.leetcode;//��������ʵ�֡�������ѡ��ʹ�õ������˫�����������еĽڵ�Ӧ�þ����������ԣ�val �� next��val �ǵ�ǰ�ڵ��ֵ��next ��ָ����һ���ڵ��ָ��
/////���á����Ҫʹ��˫����������Ҫһ������ prev ��ָʾ�����е���һ���ڵ㡣���������е����нڵ㶼�� 0-index �ġ�
////
//// ����������ʵ����Щ���ܣ�
////
////
//// get(index)����ȡ�����е� index ���ڵ��ֵ�����������Ч���򷵻�-1��
//// addAtHead(val)��������ĵ�һ��Ԫ��֮ǰ���һ��ֵΪ val �Ľڵ㡣������½ڵ㽫��Ϊ����ĵ�һ���ڵ㡣
//// addAtTail(val)����ֵΪ val �Ľڵ�׷�ӵ���������һ��Ԫ�ء�
//// addAtIndex(index,val)���������еĵ� index ���ڵ�֮ǰ���ֵΪ val �Ľڵ㡣��� index ��������ĳ��ȣ���ýڵ㽫����
////�������ĩβ����� index ���������ȣ��򲻻����ڵ㡣���indexС��0������ͷ������ڵ㡣
//// deleteAtIndex(index)��������� index ��Ч����ɾ�������еĵ� index ���ڵ㡣
////
////
////
////
//// ʾ����
////
//// MyLinkedList linkedList = new MyLinkedList();
////linkedList.addAtHead(1);
////linkedList.addAtTail(3);
////linkedList.addAtIndex(1,2);   //�����Ϊ1-> 2-> 3
////linkedList.get(1);            //����2
////linkedList.deleteAtIndex(1);  //����������1-> 3
////linkedList.get(1);            //����3
////
////
////
////
//// ��ʾ��
////
////
//// ����valֵ���� [1, 1000] ֮�ڡ�
//// ������������ [1, 1000] ֮�ڡ�
//// �벻Ҫʹ�����õ� LinkedList �⡣
////
//// Related Topics ��� ���� ? 501 ? 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//public class ListNode {   //������
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//
//class MyLinkedList {
//    //������������
//    int size;  //��¼��ǰ��С
//    ListNode head;  //����ͷ��㣬�������
//
//    public MyLinkedList() {
//        //���췽������ʼ��
//        this.size = 0;
//        head = new ListNode(0);
//    }
//
//    public int get(int index) {  //index��ʾ�±꣬ȡֵ��Χ�� 0 �� size-1  valȡֵ��1 - 1000
//        //get(0)���ǵ�һ�����  ���ơ�����
//        //�ж��Ƿ�Ϸ�
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        //����ָ��
//        ListNode p = head;
//        for (int i = 0; i < index + 1; i++) {  //+1�ų�����ͷ��㣬ÿ�ο�ʼ��Ҫ�ӵ�ǰ��2��λ�ÿ�ʼ���������������׽��
//            p = p.next;
//        }
//        return p.val;
//    }
//
//    public void addAtHead(int val) {   //��һ��λ�ã�ǰ��λ���±�Ϊ0
////        ListNode addHead = new ListNode(val);
////        addHead.next = head;
////        head = addHead;
////        this.size++;
//
//        addAtIndex(0, val);  //�ڵ�0+1��λ��ǰ����룬��0��λ��ʵ��������ͷ��㣬�����룬�����������׽��ǰ����
//    }
//
//    public void addAtTail(int val) {  //ĩβλ�ã�ǰ��λ���±�Ϊsize-1
////        ListNode addTail = new ListNode(val);
////        //����ָ��
////        ListNode p = head;
////        for (int i = 0; i < size; i++) {
////            p = p.next;
////        }
////        p.next = addTail;
////        this.size++;
//        addAtIndex(size, val);  //�ڵ�size��λ��ǰ�����
//    }
//
//    public void addAtIndex(int index, int val) {  //�ڵ�index+1λ��ǰ�����
//        if (index < 0) {
////            addAtHead(val);
//            //indexС��0���൱���ڵ�һ��λ�ò��룬��index = 0;
//            index = 0;
//        } else if (index > size) {
//            return;
//        } else {
//            //����ָ��
//            ListNode p = head;
//            for (int i = 0; i < index; i++) {   //Ҫ��ȡ��index+1ǰ��Ľ��
//                p = p.next;
//            }
//            ListNode addIndexNode = new ListNode(val);
//            //����������λ��
////            ListNode post = p.next;
////            p.next = addIndexNode;
////            p = p.next;
////            p.next = post;
//
//            //�ȸ��½��ȷ����������λ�ã���ȷ��ǰ��λ��
//            addIndexNode.next = p.next;
//            p.next = addIndexNode;
//            this.size++;
//        }
//    }
//
//    public void deleteAtIndex(int index) {
////        if (index < 0) {
////            return;
////        } else if (index >= size) {
////            return;
////        } else if (index == 0) {  //Ͷ���
////            //����ָ��
////            ListNode p = head;
////            p = p.next;
////            head = p;
////
////            this.size--;
////        } else if (index == size - 1) { //β���
////            ListNode p = head;
////            for (int i = 0; i < index - 1; i++) {
////                p = p.next;
////            }
////            p.next = null;
////        } else {  //�м���
////            //����ָ��
////            ListNode p = head;
////            for (int i = 0; i < index - 1; i++) {
////                p = p.next;
////            }
////            ListNode addIndex = new ListNode(val);
////            //����������λ��
////            p.next = p.nex.next;
////            this.size--;
////        }
//
//        if (index <0 || index >= size) {
//            return;
//        } else {
//            //����ָ��
//            ListNode p = head;
//            for (int i = 0; i < index; i++) {   //Ҫ��ȡ��index+1ǰ��Ľ��
//                p = p.next;
//            }
//            p.next = p.next.next;
//            size--;
//
//        }
//
//    }
//}
//
///**
// * Your MyLinkedList object will be instantiated and called as such:
// * MyLinkedList obj = new MyLinkedList();
// * int param_1 = obj.get(index);
// * obj.addAtHead(val);
// * obj.addAtTail(val);
// * obj.addAtIndex(index,val);
// * obj.deleteAtIndex(index);
// */
////leetcode submit region end(Prohibit modification and deletion)
