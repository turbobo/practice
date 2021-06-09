package com.demo.jianzhiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jusven
 * @Date 2021/4/18 21:27
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindFirstCommonNode {
    public static void main(String[] args) {

    }

    public ListNode FindFirstCommonNode_Solution(ListNode pHead1, ListNode pHead2) {
        //用map
        //遍历
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        Map<String,Integer> map1 = new HashMap<String,Integer>();
        Map<String,Integer> map2 = new HashMap<String,Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        while(true){
            if(p1.val==p2.val){
                return new ListNode(p1.val);
            }
            while(p1!=null){
                //p1是否存在于p2所有的数据
                if(set2.contains(p1.val)){
                    return new ListNode(p1.val);
                }
                set1.add(p1.val);
                p1 = p1.next;
            }
            while(p2!=null){
                //p2是否存在于p1所有的数据
                if(set1.contains(p2.val)){
                    return new ListNode(p2.val);
                }
                set2.add(p2.val);
//                 map2.put(p2.val);
                p2 = p2.next;
            }
            if(p1==null || p2==null)
                break;
        }
        return null;
    }

}
