package foundation.jdk8;

/**
 * @author: wangbo82
 * @Date: 2022��05��13�� 18:54
 */
public interface testInterface {
    void run1();
    default void rundefault(){
        System.out.println("Ĭ�Ͻӿڷ���");
    };
    static void runstatic(){
        System.out.println("��̬�ӿڷ���");
    };
}
