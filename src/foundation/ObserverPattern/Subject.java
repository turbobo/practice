package foundation.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Author Jusven
 * @Date 2024/3/21 15:44
 * 定义被观察者-目标
 */
abstract class Subject {
    List<MyObserver> observers = new ArrayList<>();

    // 被观察者都具有的能力
    // 增加观察者
    public void addObserver(MyObserver o) {
        this.observers.add(o);
    }

    // 删除观察者
    public void delObserver(MyObserver o) {
        this.observers.remove(o);
    }

    // 通知观察者
    public void notifyAllObservers() {
        for (MyObserver o : observers) {
            o.update();
        }
    }

    // 目标被监控的行为, 需要具体的目标执行
    public abstract void doSomething();

}
