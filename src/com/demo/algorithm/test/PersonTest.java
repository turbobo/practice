package com.demo.algorithm.test;

/**
 * @Author Jusven
 * @Date 2021/4/27 14:10
 *
 * ���
 * ǳ����
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setId(001);
        person1.setName("pete");
        //ǳ����
        Person person2 = person1;

        //���--1. new�¶���
        Person person3 = new Person();
//        System.out.println("person1 = " + person1);
//        System.out.println("person2 = " + person2);
//        System.out.println("person1.getName() = " + person1.getName());
//        System.out.println("person2.getName() = " + person2.getName());

//        System.out.println("********person2�޸ĺ�**********");
//        person2.setName("jack");
//        System.out.println("person1 = " + person1);
//        System.out.println("person2 = " + person2);
//        System.out.println("person1.getName() = " + person1.getName());
//        System.out.println("person2.getName() = " + person2.getName());

        //���--2. ��дclone(),����ʹ�ù��췽��
        try {
            Person person11 = new Person(0011,"pete11");
//            person1.setId(0011);
//            person1.setName("pete11");
            Person person22 = person11.clone();

            System.out.println("person11 = " + person11);
            System.out.println("person22 = " + person22);
            System.out.println("person11.getName() = " + person11.getName());
            System.out.println("person22.getName() = " + person22.getName());
            System.out.println("********person22�޸ĺ�**********");
            person22.setName("jack");
            System.out.println("person11 = " + person11);
            System.out.println("person22 = " + person22);
            System.out.println("person11.getName() = " + person11.getName());
            System.out.println("person22.getName() = " + person22.getName());
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
