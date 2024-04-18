package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author Jusven
 * @Date 2024/4/18 12:43
 * 定义事件监听器  需要注入ioc容器
 */
@Component
public class EventListener implements ApplicationListener<EventDto> {

    // 接受事件
    @Override
    public void onApplicationEvent(EventDto eventDto) {
        // 处理事件
        System.out.println("事件监听器 接收到事件 ：" + eventDto.getEvent());
    }
}
