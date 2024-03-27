package foundation.ObserverPattern;

/**
 * @Author Jusven
 * @Date 2024/3/21 15:53
 */
public class ConcreteSubject extends Subject{
    @Override
    public void doSomething() {
        System.out.println("目标1 行为");
        // 通知观察者
        this.notifyAllObservers();
    }
}
