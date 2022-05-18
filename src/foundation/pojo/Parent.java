package foundation.pojo;

import java.io.Serializable;

/**
 * @Author Jusven
 * @Date 2021/5/26 16:01
 */
public class Parent implements Serializable {

    private static final long serialVersionUID = 3604972003323896788L;
    public String name;
    public int age;

    public Parent() {
    }

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        name = name;
    }

    public int getAge() {
        return age;
    }

    public static void setAge(int age) {
        age = age;
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println("Parent.print");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (age != parent.age) return false;
        return name != null ? name.equals(parent.name) : parent.name == null;
    }

   /* @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }*/

    @Override
    public String toString() {
        /*return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';*/
        return super.toString();
    }
}
