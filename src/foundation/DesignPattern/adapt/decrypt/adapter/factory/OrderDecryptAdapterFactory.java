package foundation.DesignPattern.adapt.decrypt.adapter.factory;

import foundation.DesignPattern.adapt.decrypt.adapter.AppOrderAdapter;
import foundation.DesignPattern.adapt.decrypt.adapter.H5OrderAdapter;
import foundation.DesignPattern.adapt.decrypt.adapter.ThirdPartyOrderAdapter;
import foundation.DesignPattern.adapt.decrypt.service.AppOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.service.H5OrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.service.ThirdPartyOrderDecryptService;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 步骤 5：创建适配器工厂（管理解密规则匹配）
 * 订单解密适配器工厂（核心：根据来源匹配解密规则）
 */
public class OrderDecryptAdapterFactory {
    // 缓存适配器实例（避免重复创建）
    private static final Map<String, OrderDecryptor> DECRYPTOR_MAP = new HashMap<>();

    // 初始化：注册所有订单来源对应的适配器
    static {
        // APP订单适配器
        DECRYPTOR_MAP.put("APP", new AppOrderAdapter(new AppOrderDecryptService()));
        // H5订单适配器
        DECRYPTOR_MAP.put("H5", new H5OrderAdapter(new H5OrderDecryptService()));
        // 第三方平台订单适配器
        DECRYPTOR_MAP.put("THIRD_PARTY", new ThirdPartyOrderAdapter(new ThirdPartyOrderDecryptService()));
    }

    /**
     * 根据订单来源获取对应的解密器
     * @param source 订单来源（如APP、H5）
     * @return 匹配的解密器
     */
    public static OrderDecryptor getDecryptor(String source) {
        OrderDecryptor decryptor = DECRYPTOR_MAP.get(source);
        if (decryptor == null) {
            throw new IllegalArgumentException("不支持的订单来源：" + source);
        }
        return decryptor;
    }
}