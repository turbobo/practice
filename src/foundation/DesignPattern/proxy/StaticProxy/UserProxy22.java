package foundation.DesignPattern.proxy;

import foundation.DesignPattern.proxy.JDKProxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:51
 * UserService�ӿڵĴ�����
 */
// JDK��̬������ŵ����ڿ��Դ�������ʵ���˽ӿڵ��࣬����Ҫ����ض������д������롣���ǣ���ֻ�ܴ���ʵ���˽ӿڵ��࣬�޷�����û��ʵ�ֽӿڵ��ࡣ
public class UserProxy22 implements foundation.DesignPattern.proxy.UserService22 {
    private foundation.DesignPattern.proxy.UserService22 userService22;

    public UserProxy22 (foundation.DesignPattern.proxy.UserService22 userService22) {
        this.userService22 = userService22;
    }
    @Override
    public void addUser() {
        System.out.println("��̬�����ֶ���ǿ");
        userService22.addUser();
    }

    @Override
    public void delUser() {

    }
}
