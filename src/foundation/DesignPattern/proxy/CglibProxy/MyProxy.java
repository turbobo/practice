package foundation.DesignPattern.proxy.CglibProxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class MyProxy {
    public static Object getProxy(Class<?> clazz) {
        //1.创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2.通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(clazz);
        /*3.设置回调，需实现org.springframework.cglib.proxy.Callback接口，
        此处使用的是org.springframework.cglib.proxy.MethodInterceptor，也是一个接口，实现了Callback接口，
        当调用代理对象的任何方法的时候，都会被MethodInterceptor接口的invoke方法处理*/
        enhancer.setCallback((Callback) new MyMethodInterceptor());
        //4.获取代理对象,调用enhancer.create方法获取代理对象，这个方法返回的是Object类型.
        return enhancer.create();
    }
}