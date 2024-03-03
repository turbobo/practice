package foundation.DesignPattern.proxy.CglibProxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Jusven
 * @Date 2024/3/2 17:37
 * ����һ��MethodInterceptor�ӿڵ�ʵ���࣬ʵ��intercept()�������ڸ÷�����ʵ�ֶ�Ŀ����󷽷��ĵ��ú���ǿ�߼���֯�롣
 * https://blog.csdn.net/x_xhuashui/article/details/129292297
 *
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {// ִ����ǿ�߼�
        System.out.println("before method");

        // ����Ŀ�귽��
        Object result = methodProxy.invokeSuper(obj, args);

        // ִ����ǿ�߼�
        System.out.println("after method");

        return result;
    }
}
