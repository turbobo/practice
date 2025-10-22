package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * 第三方平台订单解密实现（自定义加密）
 */
public class ThirdPartyOrderDecryptService {
    // 实际解密逻辑（自定义规则）
    public DecryptedOrder decryptByCustom(String encryptedOrderNo) {
        // 模拟自定义解密过程
        String originalNo = "THIRD_" + encryptedOrderNo.replace("custom_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(30003L);
            setSource("THIRD_PARTY");
            setCreateTime(LocalDateTime.now());
        }};
    }
}