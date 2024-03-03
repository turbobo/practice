package foundation.DesignPattern.proxy.JDKProxy;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:50
 */
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("用户实现类 创建一个用户");
    }

    @Override
    public void delUser() {
        System.out.println("用户实现类 删除一个用户");

    }
}
