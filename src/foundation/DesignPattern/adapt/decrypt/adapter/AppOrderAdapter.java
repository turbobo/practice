package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.AppOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * APP��������������
 */
public class AppOrderAdapter implements OrderDecryptor {
    // ���б�����ľ�����ܷ���
    private final AppOrderDecryptService appDecryptService;

    public AppOrderAdapter(AppOrderDecryptService appDecryptService) {
        this.appDecryptService = appDecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // ���䣺����APP�����Ľ��ܷ���
        return appDecryptService.decryptByAES(encryptedOrderNo);
    }
}