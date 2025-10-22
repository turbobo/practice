package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.H5OrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * H5订单解密适配器
 */
public class H5OrderAdapter implements OrderDecryptor {
    private final H5OrderDecryptService h5DecryptService;

    public H5OrderAdapter(H5OrderDecryptService h5DecryptService) {
        this.h5DecryptService = h5DecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // 适配：调用H5订单的解密方法
        return h5DecryptService.decryptByRSA(encryptedOrderNo);
    }
}