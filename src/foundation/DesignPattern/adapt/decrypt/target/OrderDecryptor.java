package foundation.DesignPattern.adapt.decrypt.target;

import foundation.DesignPattern.adapt.decrypt.vo.DecryptedOrder;

/**
 * @Author Jusven
 * @Date 2025/10/22 17:46
 * ���� 1�����嶩�����ܽӿڣ�Ŀ��ӿڣ�
 * Ŀ��ӿڣ�����ͳһ�Ľ��ܷ�������ǰ�������Ľӿ�
 */
public interface OrderDecryptor {
    // ���ܲ���
    DecryptedOrder decrypt(String encryptedOrderNo);
}
