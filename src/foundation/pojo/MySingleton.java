package foundation.pojo;

import java.io.Serializable;

/**
 * @author: wangbo82
 * @Date: 2022年05月18日 13:50
 */
public class MySingleton implements Serializable {
    //饿汉式--类加载时就已经初始化了
    private static MySingleton instance = new MySingleton();

    private MySingleton() {

    }

    //向外提供接口的方法也需要为静态方法
    public static MySingleton getInstance() {
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
