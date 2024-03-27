package foundation.ObserverPattern;

/**
 * 客户端
 */

public class Client {
    public static void main(String[] args){
        Subject sub = new ConcreteSubject();
        sub.addObserver(new MyObserver1()); //添加观察者1
        sub.addObserver(new MyObserver2()); //添加观察者2
        sub.doSomething();
    }
}