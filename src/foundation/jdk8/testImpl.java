package foundation.jdk8;

/**
 * @author: wangbo82
 * @Date: 2022��05��13�� 18:55
 */
public class testImpl implements testInterface {
    @Override
    public void run1() {
        System.out.println("ʵ���෽�� run1");
    }
    @Override
    public void rundefault(){
        System.out.println("ʵ���෽�� rundefault");
    }

    public static void main(String[] args) {
        testImpl test = new testImpl();
        test.run1();
        test.rundefault();
        testInterface.runstatic();

    }
}
