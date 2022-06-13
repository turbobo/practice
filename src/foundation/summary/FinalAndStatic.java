package foundation.summary;

/**
 * @author: wangbo82
 * @Date: 2022��06��10�� 10:35
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
        System.out.println("�޸�ǰ��age  " + f1.getAge());
        System.out.println("�޸�ǰ��name  " + f1.getName());

        FinalAndStatic f2 = new FinalAndStatic(22, "f2");
        System.out.println("�޸�ǰf1��age  " + f1.getAge());
        System.out.println("�޸�ǰf2��age  " + f2.getAge());
        System.out.println("�޸�ǰf1��name  " + f1.getName());
        System.out.println("�޸�ǰf2��name  " + f2.getName());
        f1.setAge(1111);
        f1.setName("f2");

        System.out.println("�޸�final��age  " + f1.getAge());    //�������ָ�������age���ɱ�
        System.out.println("�޸�final  f2��age  " + f2.getAge());    //
        System.out.println("�޸�static��name  " + f1.getName());   //�����࣬���ж�����
        System.out.println("�޸�static��name  " + f2.getName());
    }
}
