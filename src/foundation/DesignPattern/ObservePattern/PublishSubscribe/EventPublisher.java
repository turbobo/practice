package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author Jusven
 * @Date 2024/4/18 12:45
 * �¼�������
 */
@Component
public class EventPublisher implements ApplicationEventPublisherAware {
    // ʹ���¼������ߣ��� Spring �������н���
    private ApplicationEventPublisher applicationEventPublisher;

    // ���캯��ע������
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    // �����¼�
    public void publish(String message) {
//        applicationEventPublisher.publishEvent(new EventDto(new EventListener(), message));
//        applicationEventPublisher.publishEvent(new EventDto(this, message));
    }
}
