package foundation.DesignPattern.adapt.decrypt.adapter;

import foundation.DesignPattern.adapt.decrypt.service.H5OrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * H5��������������
 */
public class H5OrderAdapter implements OrderDecryptor {
    private final H5OrderDecryptService h5DecryptService;

    public H5OrderAdapter(H5OrderDecryptService h5DecryptService) {
        this.h5DecryptService = h5DecryptService;
    }

    @Override
    public DecryptedOrder decrypt(String encryptedOrderNo) {
        // ���䣺����H5�����Ľ��ܷ���
        return h5DecryptService.decryptByRSA(encryptedOrderNo);
    }
}