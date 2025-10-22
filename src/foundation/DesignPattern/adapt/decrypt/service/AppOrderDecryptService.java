package foundation.DesignPattern.adapt.decrypt.service;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

import java.time.LocalDateTime;

/**
 * ��������߼�
 * APP��������ʵ�֣�AES���ܣ�
 */
public class AppOrderDecryptService {
    // ʵ�ʽ����߼���AES��
    public DecryptedOrder decryptByAES(String encryptedOrderNo) {
        // ģ��AES���ܹ���
        String originalNo = "APP_" + encryptedOrderNo.replace("encrypt_", "");
        return new DecryptedOrder() {{
            setOriginalOrderNo(originalNo);
            setUserId(10001L);
            setSource("APP");
            setCreateTime(LocalDateTime.now());
        }};
    }
}