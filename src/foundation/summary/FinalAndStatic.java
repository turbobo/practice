package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022年06月10日 10:35
 */
public class FinalAndStatic {
    public final int age;
    public static String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinalAndStatic(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public static void main(String[] args) {
        FinalAndStatic f1 = new FinalAndStatic(11, "f1");
//        FinalAndStatic f2 = new FinalAndStatic(11,"f2");
        System.out.println("修改前的age  " + f1.getAge());
        System.out.println("修改前的name  " + f1.getName());

        FinalAndStatic f2 = new FinalAndStatic(22, "f2");
        System.out.println("修改前f1的age  " + f1.getAge());
        System.out.println("修改前f2的age  " + f2.getAge());
        System.out.println("修改前f1的name  " + f1.getName());
        System.out.println("修改前f2的name  " + f2.getName());
        f1.setAge(1111);
        f1.setName("f2");

        System.out.println("修改final的age  " + f1.getAge());    //跟随对象，指定对象的age不可变
        System.out.println("修改final  f2的age  " + f2.getAge());    //
        System.out.println("修改static的name  " + f1.getName());   //跟随类，所有对象共享
        System.out.println("修改static的name  " + f2.getName());
    }
}
