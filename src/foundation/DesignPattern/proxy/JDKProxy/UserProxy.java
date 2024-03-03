package foundation.DesignPattern.proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:51
 * UserService接口的代理类
 */
// JDK动态代理的优点在于可以代理任意实现了接口的类，不需要针对特定的类编写代理代码。但是，它只能代理实现了接口的类，无法代理没有实现接口的类。
public class UserProxy implements InvocationHandler {
    // 目标对象
    private Object target;

    // 构造方法传入目标对象
    public UserProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("添加用户前处理");
        // 这里target是构造函数传入的参数，就是手动创建的目标对象（被代理的对象）
        Object result = method.invoke(target, args);
        System.out.println("添加用户前处理");
        return result;
    }
}
