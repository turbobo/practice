package foundation.jdk8;

/**
 * @author: wangbo82
 * @Date: 2022年05月13日 18:54
 */
public interface testInterface {
    void run1();
    default void rundefault(){
        System.out.println("默认接口方法");
    };
    static void runstatic(){
        System.out.println("静态接口方法");
    };
}
