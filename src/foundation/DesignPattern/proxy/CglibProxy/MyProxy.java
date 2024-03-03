package foundation.DesignPattern.proxy.CglibProxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class MyProxy {
    public static Object getProxy(Class<?> clazz) {
        //1.����Enhancer����
        Enhancer enhancer = new Enhancer();
        //2.ͨ��setSuperclass�����ø����ͣ�����Ҫ���ĸ��ഴ��������
        enhancer.setSuperclass(clazz);
        /*3.���ûص�����ʵ��org.springframework.cglib.proxy.Callback�ӿڣ�
        �˴�ʹ�õ���org.springframework.cglib.proxy.MethodInterceptor��Ҳ��һ���ӿڣ�ʵ����Callback�ӿڣ�
        �����ô��������κη�����ʱ�򣬶��ᱻMethodInterceptor�ӿڵ�invoke��������*/
        enhancer.setCallback((Callback) new MyMethodInterceptor());
        //4.��ȡ�������,����enhancer.create������ȡ�����������������ص���Object����.
        return enhancer.create();
    }
}