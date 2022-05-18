package foundation.summary;

import java.io.Serializable;

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
}