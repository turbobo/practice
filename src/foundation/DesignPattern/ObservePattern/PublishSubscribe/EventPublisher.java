package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author Jusven
 * @Date 2024/4/18 12:45
 * 事件发布器
 */
@Component
public class EventPublisher implements ApplicationEventPublisherAware {
    // 使用事件发布者，与 Spring 容器进行交互
    private ApplicationEventPublisher applicationEventPublisher;

    // 构造函数注入依赖
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    // 发布事件
    public void publish(String message) {
//        applicationEventPublisher.publishEvent(new EventDto(new EventListener(), message));
//        applicationEventPublisher.publishEvent(new EventDto(this, message));
    }
}
