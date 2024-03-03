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
        // ����Ŀ����󣬱���Ҫʵ��һ���ӿڣ����򱨴�UserServiceImpl is not an interface
        UserService userService = new UserServiceImpl();

        // �����������
        InvocationHandler handler = new UserProxy(userService);

        // ��̬���ɴ������
        UserService proxy = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class<?>[]{UserService.class}, handler);

        // ʵ���ǵ����˴������� invoke����
        proxy.addUser();

        proxy.delUser();
    }
}
