package foundation.DesignPattern.proxy.JDKProxy;

/**
 * @Author Jusven
 * @Date 2024/3/2 16:50
 */
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("�û�ʵ���� ����һ���û�");
    }

    @Override
    public void delUser() {
        System.out.println("�û�ʵ���� ɾ��һ���û�");

    }
}
