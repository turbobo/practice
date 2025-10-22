package foundation.DesignPattern.adapt.decrypt.target;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * @Author Jusven
 * @Date 2025/10/22 17:46
 * 步骤 1：定义订单解密接口（目标接口）
 * 目标接口，定义统一的解密方法，是前端依赖的接口
 */
public interface OrderDecryptor {
    // 解密操作
    DecryptedOrder decrypt(String encryptedOrderNo);
}
