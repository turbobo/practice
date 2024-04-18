package foundation.DesignPattern.ObservePattern.PublishSubscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        EventPublisher publisher = context.getBean(EventPublisher.class);
        publisher.publish("测试事件发布");
    }
}