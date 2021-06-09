package foundation;

import java.util.LinkedList;

/**
 * @Author Jusven
 * @Date 2021/6/5 20:27
 */
public class testLinkedList {
    public static void main(String[] args) {
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
