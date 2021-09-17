package foundation.pojo;

/**
 * @Author Jusven
 * @Date 2021/5/26 16:04
 */
public class Child1 extends Parent {
    @Override
    public void print() {
        System.out.println("this = " + this);
        super.print();
        System.out.println("Child1.print");
    }
}
