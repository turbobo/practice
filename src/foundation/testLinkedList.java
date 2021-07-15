package foundation;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author Jusven
 * @Date 2021/6/5 20:27
 */
public class testLinkedList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(677);
        arrayList.add(3);
        arrayList.add(4);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("linkedList = " + linkedList);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("linkedList.get(i) = " + linkedList.get(i));
        }
    }
}
