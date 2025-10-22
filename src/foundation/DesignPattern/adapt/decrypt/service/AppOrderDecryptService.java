package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * 具体解密逻辑
 * APP订单解密实现（AES加密）
 */
public class AppOrderDecryptService {
    // 实际解密逻辑（AES）
    public DecryptedOrder decryptByAES(String encryptedOrderNo) {
        // 模拟AES解密过程
        String originalNo = "APP_" + encryptedOrderNo.replace("encrypt_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(10001L);
            setSource("APP");
            setCreateTime(LocalDateTime.now());
        }};
    }
}