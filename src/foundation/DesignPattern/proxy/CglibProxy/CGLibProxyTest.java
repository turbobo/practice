package foundation.DesignPattern.proxy.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;

public class CGLibProxyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        CGLibProxy cgLibProxy = new CGLibProxy();
//        //方法返回的是Object类型,需要转型
//        UserService userServiceProxy = (UserService) cgLibProxy.getProxy(userService.class);
//        userServiceProxy.saveUser();


        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置目标类为父类
        enhancer.setSuperclass(UserServiceImpl.class);
        // 设置拦截器为回调函数
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        UserServiceImpl proxy = (UserServiceImpl) enhancer.create();
        // 调用代理对象的方法
        proxy.save();
    }
}