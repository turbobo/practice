package foundation.DesignPattern.adapt.decrypt.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ���� 2��������ܽ��ʵ����
 * �������ܺ������
 */
@Data
  public class DecryptedOrder {
  private String originalOrderNo; // ԭʼ������
  private Long userId; // �µ��û�ID
  private String source; // ������Դ����APP��H5��
  private LocalDateTime createTime; // �µ�ʱ��
  private Map<String, String> paramsMap;  // �������
  }