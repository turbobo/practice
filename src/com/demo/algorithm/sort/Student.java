package com.demo.algorithm.sort;

/**
 * @Author Jusven
 * @Date 2021/2/19 10:22
 */
public class Student implements Comparable<Student>{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();  //大于0 前者大
    }
}
