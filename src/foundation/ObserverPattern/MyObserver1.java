package foundation.ObserverPattern;

/**
 * @Author Jusven
 * @Date 2024/3/21 15:51
 * 具体的观察者，做出具体修改
 */
public class MyObserver1 implements MyObserver{
    @Override
    public void update() {
        System.out.println("观察者1 收到通知");
    }
}
