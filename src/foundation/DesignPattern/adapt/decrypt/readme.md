1. 核心业务场景
   订单来源多样（如：APP、H5、第三方平台），不同来源的订单加密规则不同（如 AES、RSA、自定义加密）。
   前端仅需传入订单号和订单来源，后端自动适配对应解密规则，返回解密后的订单信息。
2. 代码实现
   步骤 1：定义订单解密接口（目标接口）
   统一的解密方法，所有适配器都需实现此接口：
   java
   运行
   /**
* 订单解密目标接口（前端依赖的统一接口）
  */
  public interface OrderDecryptor {
  /**
   * 解密订单信息
   * @param encryptedOrderNo 加密的订单号
   * **加上特殊参数，用map传**
   * @return 解密后的订单详情（示例：包含原始订单号、用户ID等）
     */
     DecryptedOrder decrypt(String encryptedOrderNo);
     }
     步骤 2：定义解密结果实体类
     java
     运行
     /**
* 解密后的订单信息
  */
  @Data
  public class DecryptedOrder {
  private String originalOrderNo; // 原始订单号
  private Long userId; // 下单用户ID
  private String source; // 订单来源（如APP、H5）
  private LocalDateTime createTime; // 下单时间
  private Map<String, String> paramsMap;
  }
  步骤 3：实现具体解密规则（适配者）
  不同订单来源的实际解密逻辑（被适配的类）：
  java
  运行
  /**
* APP订单解密实现（AES加密）
  */
  public class AppOrderDecryptService {
  // 实际解密逻辑（AES）
  public DecryptedOrder decryptByAES(String encryptedOrderNo) {
  // 模拟AES解密过程
  String originalNo = "APP_" + encryptedOrderNo.replace("encrypt_", "");
  return new DecryptedOrder() {{
  setOriginalOrderNo(originalNo);
  setUserId(10001L);
  setSource("APP");
  setCreateTime(LocalDateTime.now());
  }};
  }
  }

/**
* H5订单解密实现（RSA加密）
  */
  public class H5OrderDecryptService {
  // 实际解密逻辑（RSA）
  public DecryptedOrder decryptByRSA(String encryptedOrderNo) {
  // 模拟RSA解密过程
  String originalNo = "H5_" + encryptedOrderNo.replace("rsa_", "");
  return new DecryptedOrder() {{
  setOriginalOrderNo(originalNo);
  setUserId(20002L);
  setSource("H5");
  setCreateTime(LocalDateTime.now());
  }};
  }
  }

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
  步骤 4：实现适配器（连接目标接口与适配者）
  将具体解密规则适配到统一接口OrderDecryptor：
  java
  运行
  /**
* APP订单解密适配器
  */
  public class AppOrderAdapter implements OrderDecryptor {
  // 持有被适配的具体解密服务
  private final AppOrderDecryptService appDecryptService;

  public AppOrderAdapter(AppOrderDecryptService appDecryptService) {
  this.appDecryptService = appDecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // 适配：调用APP订单的解密方法
  return appDecryptService.decryptByAES(encryptedOrderNo);
  }
  }

/**
* H5订单解密适配器
  */
  public class H5OrderAdapter implements OrderDecryptor {
  private final H5OrderDecryptService h5DecryptService;

  public H5OrderAdapter(H5OrderDecryptService h5DecryptService) {
  this.h5DecryptService = h5DecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // 适配：调用H5订单的解密方法
  return h5DecryptService.decryptByRSA(encryptedOrderNo);
  }
  }

/**
* 第三方订单解密适配器
  */
  public class ThirdPartyOrderAdapter implements OrderDecryptor {
  private final ThirdPartyOrderDecryptService thirdPartyDecryptService;

  public ThirdPartyOrderAdapter(ThirdPartyOrderDecryptService thirdPartyDecryptService) {
  this.thirdPartyDecryptService = thirdPartyDecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // 适配：调用第三方订单的解密方法
  return thirdPartyDecryptService.decryptByCustom(encryptedOrderNo);
  }
  }
  步骤 5：创建适配器工厂（管理解密规则匹配）
  根据订单来源自动选择对应的适配器，屏蔽适配细节：
  java
  运行
  /**
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
     步骤 6：控制器接口（对外提供服务）
     前端调用的接口，无需关心解密逻辑：
     java
     运行
     /**
* 订单解密接口（前端直接调用）
  */
  @RestController
  @RequestMapping("/api/order")
  public class OrderDecryptController {

  /**
   * 解密订单
   * @param encryptedOrderNo 加密的订单号
   * @param source 订单来源（如APP、H5、THIRD_PARTY）
   * @return 解密后的订单信息
     */
     @GetMapping("/decrypt")
     public Result<DecryptedOrder> decryptOrder(
     @RequestParam("encryptedOrderNo") String encryptedOrderNo,
     @RequestParam("source") String source) {

     // 1. 通过工厂获取对应适配器（无需关心具体解密规则）
     OrderDecryptor decryptor = OrderDecryptAdapterFactory.getDecryptor(source);

     // 2. 调用统一解密方法
     DecryptedOrder decryptedOrder = decryptor.decrypt(encryptedOrderNo);

     return Result.success(decryptedOrder);
     }
     }
3. 模式解析
   目标接口（Target）：OrderDecryptor，定义统一的解密方法，是前端依赖的接口。
   适配者（Adaptee）：AppOrderDecryptService、H5OrderDecryptService等，包含不同来源订单的具体解密逻辑。
   适配器（Adapter）：AppOrderAdapter、H5OrderAdapter等，实现OrderDecryptor接口，内部调用对应适配者的解密方法，完成接口转换。
   工厂（Factory）：OrderDecryptAdapterFactory，根据订单来源自动匹配适配器，简化调用方逻辑。
4. 优势
   前端无感知：前端只需传递订单来源和加密订单号，无需了解解密细节。
   扩展性强：新增订单来源时，只需实现新的适配者和适配器，并注册到工厂，无需修改现有代码（符合开闭原则）。
   解耦：解密逻辑与业务接口分离，不同来源的解密规则互不影响。
5. 扩展场景
   若解密规则需动态配置（如从配置中心获取加密密钥），可在适配器中注入配置服务。
   对于复杂解密逻辑，可在适配器中添加缓存（如解密结果缓存），提升性能。