package foundation.DesignPattern.adapt.decrypt.adapter.factory;

import foundation.DesignPattern.adapt.decrypt.adapter.AppOrderAdapter;
import foundation.DesignPattern.adapt.decrypt.adapter.H5OrderAdapter;
import foundation.DesignPattern.adapt.decrypt.adapter.ThirdPartyOrderAdapter;
import foundation.DesignPattern.adapt.decrypt.service.AppOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.service.H5OrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.service.ThirdPartyOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;

import java.util.HashMap;
import java.util.Map;

/**
 * ���� 5������������������������ܹ���ƥ�䣩
 * �����������������������ģ�������Դƥ����ܹ���
 */
public class OrderDecryptAdapterFactory {
    // ����������ʵ���������ظ�������
    private static final Map<String, OrderDecryptor> DECRYPTOR_MAP = new HashMap<>();

    // ��ʼ����ע�����ж�����Դ��Ӧ��������
    static {
        // APP����������
        DECRYPTOR_MAP.put("APP", new AppOrderAdapter(new AppOrderDecryptService()));
        // H5����������
        DECRYPTOR_MAP.put("H5", new H5OrderAdapter(new H5OrderDecryptService()));
        // ������ƽ̨����������
        DECRYPTOR_MAP.put("THIRD_PARTY", new ThirdPartyOrderAdapter(new ThirdPartyOrderDecryptService()));
    }

    /**
     * ���ݶ�����Դ��ȡ��Ӧ�Ľ�����
     * @param source ������Դ����APP��H5��
     * @return ƥ��Ľ�����
     */
    public static OrderDecryptor getDecryptor(String source) {
        OrderDecryptor decryptor = DECRYPTOR_MAP.get(source);
        if (decryptor == null) {
            throw new IllegalArgumentException("��֧�ֵĶ�����Դ��" + source);
        }
        return decryptor;
    }
}