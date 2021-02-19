package com.demo.algorithm.test;

import com.demo.algorithm.sort.Student;

/**
 * @Author Jusven
 * @Date 2021/2/19 10:24
 */
public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(11);
        s1.setName("张三");

        Student s2 = new Student();
        s2.setAge(12);
        s2.setName("李四");

        Comparable c = getMaxStudent(s1,s2);
        System.out.println(c);
    }

    private static Comparable getMaxStudent(Comparable c1, Comparable c2){
       int result = c1.compareTo(c2);
       if(result>=0)
           return c1;
       else
           return c2;
    }
}
