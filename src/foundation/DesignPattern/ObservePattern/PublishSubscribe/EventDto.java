package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.context.ApplicationEvent;

/**
 * 发布订阅模型
 * 观察者模式。定义了一对多的依赖关系，其中一个对象（主题）维护了一个观察者对象的列表，当主题的状态发生变化时，它会通知所有的观察者。
 * 这种模式的特点是观察者和被观察者直接交互，观察者需要注册到主题对象，以便接收通知。
 *
 * 发布-订阅模式。引入了一个中间件或调度中心，在这个模式中，发布者负责发布事件或消息，而订阅者则订阅它们感兴趣的事件。
 * 调度中心负责管理订阅和发布之间的联系，使得发布者和订阅者之间不需要直接交互。
 * 这样，发布者和订阅者可以互不干扰地工作，提高了系统的解耦性和灵活性。
 * @Author Jusven
 * @Date 2024/4/18 12:40
 * 定义事件
 */
public class EventDto extends ApplicationEvent {
    // 自定义事件
    private final String event;

    /**
     *
     * @param source source参数指的是发生事件的对象，该对象可以在监听内被获取。 可以不去定义event，直接获取Object类型的消息
     * @param event
     */
    public EventDto(Object source, String event) {
        super(source);
        this.event = event;
    }
    // 获取事件
    public String getEvent() {
        return event;
    }
}
