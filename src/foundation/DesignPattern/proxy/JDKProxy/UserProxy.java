package foundation.DesignPattern.proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:51
 * UserService�ӿڵĴ�����
 */
// JDK��̬������ŵ����ڿ��Դ�������ʵ���˽ӿڵ��࣬����Ҫ����ض������д������롣���ǣ���ֻ�ܴ���ʵ���˽ӿڵ��࣬�޷�����û��ʵ�ֽӿڵ��ࡣ
public class UserProxy implements InvocationHandler {
    // Ŀ�����
    private Object target;

    // ���췽������Ŀ�����
    public UserProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("����û�ǰ����");
        // ����target�ǹ��캯������Ĳ����������ֶ�������Ŀ����󣨱�����Ķ���
        Object result = method.invoke(target, args);
        System.out.println("����û�ǰ����");
        return result;
    }
}
