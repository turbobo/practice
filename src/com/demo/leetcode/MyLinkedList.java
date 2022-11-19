//package com.demo.leetcode;//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
/////引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
////
//// 在链表类中实现这些功能：
////
////
//// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
////到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
////
////
////
////
//// 示例：
////
//// MyLinkedList linkedList = new MyLinkedList();
////linkedList.addAtHead(1);
////linkedList.addAtTail(3);
////linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
////linkedList.get(1);            //返回2
////linkedList.deleteAtIndex(1);  //现在链表是1-> 3
////linkedList.get(1);            //返回3
////
////
////
////
//// 提示：
////
////
//// 所有val值都在 [1, 1000] 之内。
//// 操作次数将在 [1, 1000] 之内。
//// 请不要使用内置的 LinkedList 库。
////
//// Related Topics 设计 链表 ? 501 ? 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//public class ListNode {   //链表结点
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
//    //设计链表的属性
//    int size;  //记录当前大小
//    ListNode head;  //虚拟头结点，方便操作
//
//    public MyLinkedList() {
//        //构造方法，初始化
//        this.size = 0;
//        head = new ListNode(0);
//    }
//
//    public int get(int index) {  //index表示下标，取值范围： 0 到 size-1  val取值：1 - 1000
//        //get(0)就是第一个结点  类推。。。
//        //判断是否合法
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        //遍历指针
//        ListNode p = head;
//        for (int i = 0; i < index + 1; i++) {  //+1排除虚拟头结点，每次开始都要从当前第2个位置开始，即链表真正的首结点
//            p = p.next;
//        }
//        return p.val;
//    }
//
//    public void addAtHead(int val) {   //第一个位置，前面位置下标为0
////        ListNode addHead = new ListNode(val);
////        addHead.next = head;
////        head = addHead;
////        this.size++;
//
//        addAtIndex(0, val);  //在第0+1个位置前面插入，第0个位置实际是虚拟头结点，其后插入，就是在链表首结点前插入
//    }
//
//    public void addAtTail(int val) {  //末尾位置，前面位置下标为size-1
////        ListNode addTail = new ListNode(val);
////        //遍历指针
////        ListNode p = head;
////        for (int i = 0; i < size; i++) {
////            p = p.next;
////        }
////        p.next = addTail;
////        this.size++;
//        addAtIndex(size, val);  //在第size个位置前面插入
//    }
//
//    public void addAtIndex(int index, int val) {  //在第index+1位置前面插入
//        if (index < 0) {
////            addAtHead(val);
//            //index小于0，相当于在第一个位置插入，则index = 0;
//            index = 0;
//        } else if (index > size) {
//            return;
//        } else {
//            //遍历指针
//            ListNode p = head;
//            for (int i = 0; i < index; i++) {   //要获取第index+1前面的结点
//                p = p.next;
//            }
//            ListNode addIndexNode = new ListNode(val);
//            //保留后面结点位置
////            ListNode post = p.next;
////            p.next = addIndexNode;
////            p = p.next;
////            p.next = post;
//
//            //先给新结点确定后面连接位置，再确定前面位置
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
////        } else if (index == 0) {  //投结点
////            //遍历指针
////            ListNode p = head;
////            p = p.next;
////            head = p;
////
////            this.size--;
////        } else if (index == size - 1) { //尾结点
////            ListNode p = head;
////            for (int i = 0; i < index - 1; i++) {
////                p = p.next;
////            }
////            p.next = null;
////        } else {  //中间结点
////            //遍历指针
////            ListNode p = head;
////            for (int i = 0; i < index - 1; i++) {
////                p = p.next;
////            }
////            ListNode addIndex = new ListNode(val);
////            //保留后面结点位置
////            p.next = p.nex.next;
////            this.size--;
////        }
//
//        if (index <0 || index >= size) {
//            return;
//        } else {
//            //遍历指针
//            ListNode p = head;
//            for (int i = 0; i < index; i++) {   //要获取第index+1前面的结点
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
