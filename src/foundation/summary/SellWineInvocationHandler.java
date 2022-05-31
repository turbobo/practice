package foundation.summary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: wangbo82
 * @Date: 2022年05月20日 18:31
 */
public class SellWineInvocationHandler implements InvocationHandler {
    /*
     * 要代理卖白酒这件事，明确要卖谁生产的白酒，代理对象就是白酒生产厂家
     * */
    //让目标对象有代理功能

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
