package foundation.DesignPattern.proxy.CglibProxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 17:37
 * 定义一个MethodInterceptor接口的实现类，实现intercept()方法，在该方法中实现对目标对象方法的调用和增强逻辑的织入。
 * https://blog.csdn.net/x_xhuashui/article/details/129292297
 *
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {// 执行增强逻辑
        System.out.println("before method");

        // 调用目标方法
        Object result = methodProxy.invokeSuper(obj, args);

        // 执行增强逻辑
        System.out.println("after method");

        return result;
    }
}
