package foundation.summary;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: wangbo82
 * @Date: 2022年06月13日 17:08
 */
public class TestHashCode {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setAge(31);
        person1.setName("jack");
        Person person2 = new Person();
        person2.setAge(31);
        person2.setName("mary");

        System.out.println("person1.hashCode() = " + person1.hashCode());
        System.out.println("person1.getAge() = " + person1.getAge());
        System.out.println("person2.hashCode() = " + person2.hashCode());
        System.out.println("person2.getAge() = " + person2.getAge());

        System.out.println("person1.equals(person2) = " + person1.equals(person2));

//        HashMap<Integer, String> map1 = new HashMap<>();
//        map1.put(1,"11aa");
//
//        HashMap<Integer, String> map2 = new HashMap<>();
//        map2.put(2,"22bb");
//
//        System.out.println("map1.hashCode() = " + map1.hashCode());
//
//        System.out.println("map2.hashCode() = " + map2.hashCode());


      /*  HashSet<Person> hashset = new HashSet<>();
        Person jack31 = new Person(31, "jack31");
        Person mary32 = new Person(31,"jack31");
        //HashSet采用的是Object默认的hashCode方法计算得出，两个对象哈希值不同
        hashset.add(jack31);
        hashset.add(mary32);
        System.out.println("hashset.size() = " + hashset.size());*/


        //**************************************************************************

        //在Person类中重写hashCode方法
        //在存放p2时，先通过p2的hash值计算出数组下标，此时发现该位置上已经有元素了（数组下标相同的元素会放在同一个链表中），
        // 接着，会去遍历这个链表，比较他们的name和age值是否和p2的name、age值相同（通过equals方法），
        // 如果相同，就不会将p2存进去，所以此时set的大小为1.

        HashSet<Person> hashset = new HashSet<>();
        Person jack31 = new Person(31, "jack31");
        Person mary32 = new Person(31,"jack31");

        //hashcode equals都不重写时  ===>  hashcode不同  equals结果false
//        jack31.hashCode() = 356573597
//        mary32.hashCode() = 1735600054
//        jack31.equals(mary32) = false
        //        hashset.size() = 2
        System.out.println("jack31.hashCode() = " + jack31.hashCode());
        System.out.println("mary32.hashCode() = " + mary32.hashCode());
        System.out.println("jack31.equals(mary32) = " + jack31.equals(mary32));

        //hashcode根据age、name重写, equals不重写时  ===>  hashcode相同  equals结果false
//        jack31.hashCode() = -1167640065
//        mary32.hashCode() = -1167640065
//        jack31.equals(mary32) = false
//        hashset.size() = 2


        //hashcode, equals根据age、name重写  ===>  hashcode相同  equals结果false


        //hashcode根据age、name重写, equals不重写时  ===>  hashcode不同  equals结果false
//        jack31.hashCode() = -1167640065
//        mary32.hashCode() = -1167640065
//        jack31.equals(mary32) = true
//        hashset.size() = 1


        //HashSet采用的是Object默认的hashCode方法计算得出，两个对象哈希值不同
        hashset.add(jack31);
        hashset.add(mary32);
        //equals 不重写时，比较的还是对象的内存地址
        System.out.println("hashset.size() = " + hashset.size());

        //equals  重写时，根据name和age判断，对象相同，第二个对象不会加入hashset
        System.out.println("hashset.size() = " + hashset.size());
    }
}
