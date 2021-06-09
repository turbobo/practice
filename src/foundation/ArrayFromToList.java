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
        //数组转集合
        /*Arrays.asList()如果传入的参数是一个数组，
        那么这个数组一定要是引用类型才能将其转换为List集合，
        当传入基本数据类型数组时则会将这个数组对象当成一个引用类型对象存进List集合。*/

        //传入基本类型，需要使用jdk1.8的流进行装箱
        int[] arr = {1,2};
        List list1 = Arrays.asList(arr);
        System.out.println("list1 = " + list1);
        //传入基本类型，用jdk1.8装箱，转为引用类型
        List<Integer> list_Integer = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        ArrayList<Integer> list2 = (ArrayList<Integer>)Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("list_Integer = " + list_Integer);

        //传入引用类型，可以直接使用asList方法
        Integer[] arr2 = {1,2};
        List list2 = Arrays.asList(arr2);
        System.out.println("list2 = " + list2);


        //集合转数组
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        Object[] objects = list3.toArray();   //toArray()的无参方法返回的是一个Object类型数组
        System.out.println("objects = " + objects);
        for (int i = 0; i < objects.length; i++) {
            System.out.print("objects[i] = " + objects[i] + " ");
        }
        //传入数组
        Integer[] arr3 = new Integer[list3.size()];
        list3.toArray(arr3);
        System.out.println("\n arr3 = " + Arrays.toString(arr3));

    }
}
