package foundation.DesignPattern.adapt.decrypt.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 步骤 2：定义解密结果实体类
 * 订单解密后的数据
 */
@Data
  public class DecryptedOrder {
  private String originalOrderNo; // 原始订单号
  private Long userId; // 下单用户ID
  private String source; // 订单来源（如APP、H5）
  private LocalDateTime createTime; // 下单时间
  private Map<String, String> paramsMap;  // 特殊参数
  }