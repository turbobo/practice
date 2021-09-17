package foundation.pojo;

/**
 * @Author Jusven
 * @Date 2021/5/26 16:01
 */
public class Parent {
    public String name;
    public int age;

    public Parent() {
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

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
