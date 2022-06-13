package foundation.summary;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: wangbo82
 * @Date: 2022��06��13�� 17:08
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
        //HashSet���õ���ObjectĬ�ϵ�hashCode��������ó������������ϣֵ��ͬ
        hashset.add(jack31);
        hashset.add(mary32);
        System.out.println("hashset.size() = " + hashset.size());*/


        //**************************************************************************

        //��Person������дhashCode����
        //�ڴ��p2ʱ����ͨ��p2��hashֵ����������±꣬��ʱ���ָ�λ�����Ѿ���Ԫ���ˣ������±���ͬ��Ԫ�ػ����ͬһ�������У���
        // ���ţ���ȥ������������Ƚ����ǵ�name��ageֵ�Ƿ��p2��name��ageֵ��ͬ��ͨ��equals��������
        // �����ͬ���Ͳ��Ὣp2���ȥ�����Դ�ʱset�Ĵ�СΪ1.

        HashSet<Person> hashset = new HashSet<>();
        Person jack31 = new Person(31, "jack31");
        Person mary32 = new Person(31,"jack31");

        //hashcode equals������дʱ  ===>  hashcode��ͬ  equals���false
//        jack31.hashCode() = 356573597
//        mary32.hashCode() = 1735600054
//        jack31.equals(mary32) = false
        //        hashset.size() = 2
        System.out.println("jack31.hashCode() = " + jack31.hashCode());
        System.out.println("mary32.hashCode() = " + mary32.hashCode());
        System.out.println("jack31.equals(mary32) = " + jack31.equals(mary32));

        //hashcode����age��name��д, equals����дʱ  ===>  hashcode��ͬ  equals���false
//        jack31.hashCode() = -1167640065
//        mary32.hashCode() = -1167640065
//        jack31.equals(mary32) = false
//        hashset.size() = 2


        //hashcode, equals����age��name��д  ===>  hashcode��ͬ  equals���false


        //hashcode����age��name��д, equals����дʱ  ===>  hashcode��ͬ  equals���false
//        jack31.hashCode() = -1167640065
//        mary32.hashCode() = -1167640065
//        jack31.equals(mary32) = true
//        hashset.size() = 1


        //HashSet���õ���ObjectĬ�ϵ�hashCode��������ó������������ϣֵ��ͬ
        hashset.add(jack31);
        hashset.add(mary32);
        //equals ����дʱ���ȽϵĻ��Ƕ�����ڴ��ַ
        System.out.println("hashset.size() = " + hashset.size());

        //equals  ��дʱ������name��age�жϣ�������ͬ���ڶ������󲻻����hashset
        System.out.println("hashset.size() = " + hashset.size());
    }
}
