package foundation.DesignPattern.proxy.StaticProxy;

import foundation.DesignPattern.proxy.UserService22;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:50
 */
public class UserServiceImpl22 implements UserService22 {
    @Override
    public void addUser() {
        System.out.println("�û�ʵ���� UserServiceImpl22 ����һ���û�");
    }

    @Override
    public void delUser() {
        System.out.println("�û�ʵ����  ɾ��һ���û�");

    }
}
