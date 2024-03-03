package foundation.DesignPattern.proxyy.StaticProxy;

import foundation.DesignPattern.proxy.JDKProxy.UserService;
import foundation.DesignPattern.proxy.StaticProxy.UserServiceImpl22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:55
 */
public class testProxy {
    //

    public static void main(String[] args) {
        foundation.DesignPattern.proxy.UserService22 userService22 = new UserServiceImpl22();

        // 把实现类传入代理类参数
        foundation.DesignPattern.proxy.UserService22 proxy = new foundation.DesignPattern.proxy.UserProxy22(userService22);
        proxy.addUser();
    }
}
