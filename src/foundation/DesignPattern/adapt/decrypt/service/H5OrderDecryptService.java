package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * H5订单解密实现（RSA加密）
 */
public class H5OrderDecryptService {
    // 实际解密逻辑（RSA）
    public DecryptedOrder decryptByRSA(String encryptedOrderNo) {
        // 模拟RSA解密过程
        String originalNo = "H5_" + encryptedOrderNo.replace("rsa_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(20002L);
            setSource("H5");
            setCreateTime(LocalDateTime.now());
        }};
    }
}