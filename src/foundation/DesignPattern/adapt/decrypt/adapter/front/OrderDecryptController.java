package foundation.DesignPattern.adapt.decrypt.adapter.front;

import foundation.DesignPattern.ApiResponse;
import foundation.DesignPattern.adapt.decrypt.adapter.factory.OrderDecryptAdapterFactory;
import foundation.DesignPattern.adapt.decrypt.target.OrderDecryptor;
import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * 步骤 6：控制器接口（对外提供服务）
 * 订单解密接口（前端直接调用）
 */
@RestController
@RequestMapping("/api/order")
public class OrderDecryptController {

    /**
     * 解密订单
     *
     * @param encryptedOrderNo 加密的订单号
     * @param source           订单来源（如APP、H5、THIRD_PARTY）
     *         platform 平台来源
     * @return 解密后的订单信息
     */
    @GetMapping("/decrypt")
    public ApiResponse<DecryptedOrder> decryptOrder(
            @RequestParam("encryptedOrderNo") String encryptedOrderNo,
            @RequestParam("source") String source) {

        // 1. 通过工厂获取对应适配器（无需关心具体解密规则）
        OrderDecryptor decryptor = OrderDecryptAdapterFactory.getDecryptor(source);

        // 2. 调用统一解密方法
        DecryptedOrder decryptedOrder = decryptor.decrypt(encryptedOrderNo);

        return ApiResponse.success(decryptedOrder);
    }
}