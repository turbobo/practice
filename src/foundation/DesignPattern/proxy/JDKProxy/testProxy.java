package foundation.DesignPattern.proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:55
 */
public class testProxy {
    //

    public static void main(String[] args) {
        // 创建目标对象，必须要实现一个接口，否则报错：UserServiceImpl is not an interface
        UserService userService = new UserServiceImpl();

        // 创建代理对象
        InvocationHandler handler = new UserProxy(userService);

        // 动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class<?>[]{UserService.class}, handler);

        // 实际是调用了代理对象的 invoke方法
        proxy.addUser();

        proxy.delUser();
    }
}
