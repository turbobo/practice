package foundation.DesignPattern.proxy.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;

public class CGLibProxyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        CGLibProxy cgLibProxy = new CGLibProxy();
//        //�������ص���Object����,��Ҫת��
//        UserService userServiceProxy = (UserService) cgLibProxy.getProxy(userService.class);
//        userServiceProxy.saveUser();


        // ����Enhancer����
        Enhancer enhancer = new Enhancer();
        // ����Ŀ����Ϊ����
        enhancer.setSuperclass(UserServiceImpl.class);
        // ����������Ϊ�ص�����
        enhancer.setCallback(new MyMethodInterceptor());
        // �����������
        UserServiceImpl proxy = (UserServiceImpl) enhancer.create();
        // ���ô������ķ���
        proxy.save();
    }
}