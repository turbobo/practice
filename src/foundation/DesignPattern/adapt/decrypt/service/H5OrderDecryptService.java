package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * H5��������ʵ�֣�RSA���ܣ�
 */
public class H5OrderDecryptService {
    // ʵ�ʽ����߼���RSA��
    public DecryptedOrder decryptByRSA(String encryptedOrderNo) {
        // ģ��RSA���ܹ���
        String originalNo = "H5_" + encryptedOrderNo.replace("rsa_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(20002L);
            setSource("H5");
            setCreateTime(LocalDateTime.now());
        }};
    }
}