package foundation.pojo;

import java.io.Serializable;

/**
 * @author: wangbo82
 * @Date: 2022��05��18�� 13:50
 */
public class MySingleton implements Serializable {
    //����ʽ--�����ʱ���Ѿ���ʼ����
    private static MySingleton instance = new MySingleton();

    private MySingleton() {

    }

    //�����ṩ�ӿڵķ���Ҳ��ҪΪ��̬����
    public static MySingleton getInstance() {
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
