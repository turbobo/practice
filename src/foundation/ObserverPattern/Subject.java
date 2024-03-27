package foundation.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Author Jusven
 * @Date 2024/3/21 15:44
 * ���屻�۲���-Ŀ��
 */
abstract class Subject {
    List<MyObserver> observers = new ArrayList<>();

    // ���۲��߶����е�����
    // ���ӹ۲���
    public void addObserver(MyObserver o) {
        this.observers.add(o);
    }

    // ɾ���۲���
    public void delObserver(MyObserver o) {
        this.observers.remove(o);
    }

    // ֪ͨ�۲���
    public void notifyAllObservers() {
        for (MyObserver o : observers) {
            o.update();
        }
    }

    // Ŀ�걻��ص���Ϊ, ��Ҫ�����Ŀ��ִ��
    public abstract void doSomething();

}
