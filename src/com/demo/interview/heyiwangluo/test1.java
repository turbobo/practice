package com.demo.interview.heyiwangluo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2023/8/21 18:56
 */
public class test1 {
    public static void main(String[] args) {
        // ������ɾ��Ԫ��
//        List<Integer> list = Arrays.asList(1,432,654,4,87);  //  ͨ�������ͼƬ���ǿ��Կ����������ArrayList����������ƽʱʹ�õ�ArrayList,�����ArrayList��Arrays�Լ������һ���ڲ���,  Arrays.asList()����������list������֧�ֶ����ݵĸ��Ĳ���
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(8);
        for (Integer i :list) {
            if (i == 3) {
                list.remove(i);
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//                        System.out.println(list.get(i));
//
//            if (list.get(i) == 2) {
//                list.remove(i);
//                i--;
//            }
//        }

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//            if (next == 6) {
//                iterator.remove();
//            }
//        }

    }
}
