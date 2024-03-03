package foundation.DesignPattern.proxy;

import foundation.DesignPattern.proxy.JDKProxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:51
 * UserService接口的代理类
 */
// JDK动态代理的优点在于可以代理任意实现了接口的类，不需要针对特定的类编写代理代码。但是，它只能代理实现了接口的类，无法代理没有实现接口的类。
public class UserProxy22 implements foundation.DesignPattern.proxy.UserService22 {
    private foundation.DesignPattern.proxy.UserService22 userService22;

    public UserProxy22 (foundation.DesignPattern.proxy.UserService22 userService22) {
        this.userService22 = userService22;
    }
    @Override
    public void addUser() {
        System.out.println("静态代理，手动增强");
        userService22.addUser();
    }

    @Override
    public void delUser() {

    }
}
