package foundation.Thread.ThreadLocalTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyThreadContextHolder implements ApplicationContextAware {
    private static final ThreadLocal<ApplicationContext> contextHolder = new InheritableThreadLocal<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        contextHolder.set(applicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        return contextHolder.get();
    }
}
