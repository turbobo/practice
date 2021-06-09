package foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Jusven
 * @Date 2021/5/26 11:58
 */
public class ArrayFromToList {
    protected int anInt = 10;
//    protected boolean anInt;
    protected void print(){
        System.out.println("ArrayFromToList--print(); = ");
    }

    public static void main(String[] args) {
        //����ת����
        /*Arrays.asList()�������Ĳ�����һ�����飬
        ��ô�������һ��Ҫ���������Ͳ��ܽ���ת��ΪList���ϣ�
        ���������������������ʱ��Ὣ���������󵱳�һ���������Ͷ�����List���ϡ�*/

        //����������ͣ���Ҫʹ��jdk1.8��������װ��
        int[] arr = {1,2};
        List list1 = Arrays.asList(arr);
        System.out.println("list1 = " + list1);
        //����������ͣ���jdk1.8װ�䣬תΪ��������
        List<Integer> list_Integer = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        ArrayList<Integer> list2 = (ArrayList<Integer>)Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("list_Integer = " + list_Integer);

        //�����������ͣ�����ֱ��ʹ��asList����
        Integer[] arr2 = {1,2};
        List list2 = Arrays.asList(arr2);
        System.out.println("list2 = " + list2);


        //����ת����
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        Object[] objects = list3.toArray();   //toArray()���޲η������ص���һ��Object��������
        System.out.println("objects = " + objects);
        for (int i = 0; i < objects.length; i++) {
            System.out.print("objects[i] = " + objects[i] + " ");
        }
        //��������
        Integer[] arr3 = new Integer[list3.size()];
        list3.toArray(arr3);
        System.out.println("\n arr3 = " + Arrays.toString(arr3));

    }
}
