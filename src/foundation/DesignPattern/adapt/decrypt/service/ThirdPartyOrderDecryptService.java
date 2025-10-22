package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * ������ƽ̨��������ʵ�֣��Զ�����ܣ�
 */
public class ThirdPartyOrderDecryptService {
    // ʵ�ʽ����߼����Զ������
    public DecryptedOrder decryptByCustom(String encryptedOrderNo) {
        // ģ���Զ�����ܹ���
        String originalNo = "THIRD_" + encryptedOrderNo.replace("custom_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(30003L);
            setSource("THIRD_PARTY");
            setCreateTime(LocalDateTime.now());
        }};
    }
}