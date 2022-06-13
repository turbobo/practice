package foundation.summary;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = -5809452578272945389L;
    private int age;
    private String name;
    private String sex;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;   //只根据age判断
        if (name != null ? !name.equals(person.name) : person.name != null) return false;   //根据age、name判断
        return true;
//        return sex != null ? sex.equals(person.sex) : person.sex == null;
    }

    @Override
    public int hashCode() {
//        int result = age;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (sex != null ? sex.hashCode() : 0);
//        return result;

        //在存放p2时，先通过p2的hash值计算出数组下标，此时发现该位置上已经有元素了（数组下标相同的元素会放在同一个链表中），
        // 接着，会去遍历这个链表，比较他们的name和age值是否和p2的name、age值相同（通过equals方法），
        // 如果相同，就不会将p2存进去，所以此时set的大小为1.
        return Objects.hash(age,name);
    }
}