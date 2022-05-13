package foundation.jdk8;

/**
 * @author: wangbo82
 * @Date: 2022年05月13日 18:55
 */
public class testImpl implements testInterface {
    @Override
    public void run1() {
        System.out.println("实现类方法 run1");
    }
    @Override
    public void rundefault(){
        System.out.println("实现类方法 rundefault");
    }

    public static void main(String[] args) {
        testImpl test = new testImpl();
        test.run1();
        test.rundefault();
        testInterface.runstatic();

    }
}
