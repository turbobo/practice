package foundation.DesignPattern.proxy.StaticProxy;

import foundation.DesignPattern.proxy.UserService22;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:50
 */
public class UserServiceImpl22 implements UserService22 {
    @Override
    public void addUser() {
        System.out.println("用户实现类 UserServiceImpl22 创建一个用户");
    }

    @Override
    public void delUser() {
        System.out.println("用户实现类  删除一个用户");

    }
}
