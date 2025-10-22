package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.AppOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * APP订单解密适配器
 */
public class AppOrderAdapter implements OrderDecryptor {
    // 持有被适配的具体解密服务
    private final AppOrderDecryptService appDecryptService;

    public AppOrderAdapter(AppOrderDecryptService appDecryptService) {
        this.appDecryptService = appDecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // 适配：调用APP订单的解密方法
        return appDecryptService.decryptByAES(encryptedOrderNo);
    }
}