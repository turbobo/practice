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
 * ���� 6���������ӿڣ������ṩ����
 * �������ܽӿڣ�ǰ��ֱ�ӵ��ã�
 */
@RestController
@RequestMapping("/api/order")
public class OrderDecryptController {

    /**
     * ���ܶ���
     *
     * @param encryptedOrderNo ���ܵĶ�����
     * @param source           ������Դ����APP��H5��THIRD_PARTY��
     *         platform ƽ̨��Դ
     * @return ���ܺ�Ķ�����Ϣ
     */
    @GetMapping("/decrypt")
    public ApiResponse<DecryptedOrder> decryptOrder(
            @RequestParam("encryptedOrderNo") String encryptedOrderNo,
            @RequestParam("source") String source) {

        // 1. ͨ��������ȡ��Ӧ��������������ľ�����ܹ���
        OrderDecryptor decryptor = OrderDecryptAdapterFactory.getDecryptor(source);

        // 2. ����ͳһ���ܷ���
        DecryptedOrder decryptedOrder = decryptor.decrypt(encryptedOrderNo);

        return ApiResponse.success(decryptedOrder);
    }
}