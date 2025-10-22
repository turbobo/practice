package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.ThirdPartyOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * 第三方订单解密适配器
 */
public class ThirdPartyOrderAdapter implements OrderDecryptor {
    private final ThirdPartyOrderDecryptService thirdPartyDecryptService;

    public ThirdPartyOrderAdapter(ThirdPartyOrderDecryptService thirdPartyDecryptService) {
        this.thirdPartyDecryptService = thirdPartyDecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // 适配：调用第三方订单的解密方法
        return thirdPartyDecryptService.decryptByCustom(encryptedOrderNo);
    }
}