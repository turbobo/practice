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

        if (age != person.age) return false;   //ֻ����age�ж�
        if (name != null ? !name.equals(person.name) : person.name != null) return false;   //����age��name�ж�
        return true;
//        return sex != null ? sex.equals(person.sex) : person.sex == null;
    }

    @Override
    public int hashCode() {
//        int result = age;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (sex != null ? sex.hashCode() : 0);
//        return result;

        //�ڴ��p2ʱ����ͨ��p2��hashֵ����������±꣬��ʱ���ָ�λ�����Ѿ���Ԫ���ˣ������±���ͬ��Ԫ�ػ����ͬһ�������У���
        // ���ţ���ȥ������������Ƚ����ǵ�name��ageֵ�Ƿ��p2��name��ageֵ��ͬ��ͨ��equals��������
        // �����ͬ���Ͳ��Ὣp2���ȥ�����Դ�ʱset�Ĵ�СΪ1.
        return Objects.hash(age,name);
    }
}