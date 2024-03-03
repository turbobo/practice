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
        // 迭代器删除元素
//        List<Integer> list = Arrays.asList(1,432,654,4,87);  //  通过上面的图片我们可以看到，这里的ArrayList并不是我们平时使用的ArrayList,这里的ArrayList是Arrays自己定义的一个内部类,  Arrays.asList()方法创建的list，并不支持对数据的更改操作
        
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
