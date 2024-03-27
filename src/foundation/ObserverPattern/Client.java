package foundation.ObserverPattern;

/**
 * �ͻ���
 */

public class Client {
    public static void main(String[] args){
        Subject sub = new ConcreteSubject();
        sub.addObserver(new MyObserver1()); //��ӹ۲���1
        sub.addObserver(new MyObserver2()); //��ӹ۲���2
        sub.doSomething();
    }
}