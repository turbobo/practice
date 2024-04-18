package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author Jusven
 * @Date 2024/4/18 12:43
 * �����¼�������  ��Ҫע��ioc����
 */
@Component
public class EventListener implements ApplicationListener<EventDto> {

    // �����¼�
    @Override
    public void onApplicationEvent(EventDto eventDto) {
        // �����¼�
        System.out.println("�¼������� ���յ��¼� ��" + eventDto.getEvent());
    }
}
