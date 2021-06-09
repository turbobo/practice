package foundation;

/**
 * @Author Jusven
 * @Date 2021/5/26 16:04
 */
public class Child2 extends Parent {
    @Override
    public void print() {
        System.out.println("this = " + this);

        super.print();
        System.out.println("Child2.print");
    }
}
