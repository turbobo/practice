package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.ThirdPartyOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * ��������������������
 */
public class ThirdPartyOrderAdapter implements OrderDecryptor {
    private final ThirdPartyOrderDecryptService thirdPartyDecryptService;

    public ThirdPartyOrderAdapter(ThirdPartyOrderDecryptService thirdPartyDecryptService) {
        this.thirdPartyDecryptService = thirdPartyDecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // ���䣺���õ����������Ľ��ܷ���
        return thirdPartyDecryptService.decryptByCustom(encryptedOrderNo);
    }
}