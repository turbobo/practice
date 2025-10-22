1. ����ҵ�񳡾�
   ������Դ�������磺APP��H5��������ƽ̨������ͬ��Դ�Ķ������ܹ���ͬ���� AES��RSA���Զ�����ܣ���
   ǰ�˽��贫�붩���źͶ�����Դ������Զ������Ӧ���ܹ��򣬷��ؽ��ܺ�Ķ�����Ϣ��
2. ����ʵ��
   ���� 1�����嶩�����ܽӿڣ�Ŀ��ӿڣ�
   ͳһ�Ľ��ܷ�������������������ʵ�ִ˽ӿڣ�
   java
   ����
   /**
* ��������Ŀ��ӿڣ�ǰ��������ͳһ�ӿڣ�
  */
  public interface OrderDecryptor {
  /**
   * ���ܶ�����Ϣ
   * @param encryptedOrderNo ���ܵĶ�����
   * **���������������map��**
   * @return ���ܺ�Ķ������飨ʾ��������ԭʼ�����š��û�ID�ȣ�
     */
     DecryptedOrder decrypt(String encryptedOrderNo);
     }
     ���� 2��������ܽ��ʵ����
     java
     ����
     /**
* ���ܺ�Ķ�����Ϣ
  */
  @Data
  public class DecryptedOrder {
  private String originalOrderNo; // ԭʼ������
  private Long userId; // �µ��û�ID
  private String source; // ������Դ����APP��H5��
  private LocalDateTime createTime; // �µ�ʱ��
  private Map<String, String> paramsMap;
  }
  ���� 3��ʵ�־�����ܹ��������ߣ�
  ��ͬ������Դ��ʵ�ʽ����߼�����������ࣩ��
  java
  ����
  /**
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

/**
* H5��������ʵ�֣�RSA���ܣ�
  */
  public class H5OrderDecryptService {
  // ʵ�ʽ����߼���RSA��
  public DecryptedOrder decryptByRSA(String encryptedOrderNo) {
  // ģ��RSA���ܹ���
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
  ���� 4��ʵ��������������Ŀ��ӿ��������ߣ�
  ��������ܹ������䵽ͳһ�ӿ�OrderDecryptor��
  java
  ����
  /**
* APP��������������
  */
  public class AppOrderAdapter implements OrderDecryptor {
  // ���б�����ľ�����ܷ���
  private final AppOrderDecryptService appDecryptService;

  public AppOrderAdapter(AppOrderDecryptService appDecryptService) {
  this.appDecryptService = appDecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // ���䣺����APP�����Ľ��ܷ���
  return appDecryptService.decryptByAES(encryptedOrderNo);
  }
  }

/**
* H5��������������
  */
  public class H5OrderAdapter implements OrderDecryptor {
  private final H5OrderDecryptService h5DecryptService;

  public H5OrderAdapter(H5OrderDecryptService h5DecryptService) {
  this.h5DecryptService = h5DecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // ���䣺����H5�����Ľ��ܷ���
  return h5DecryptService.decryptByRSA(encryptedOrderNo);
  }
  }

/**
* ��������������������
  */
  public class ThirdPartyOrderAdapter implements OrderDecryptor {
  private final ThirdPartyOrderDecryptService thirdPartyDecryptService;

  public ThirdPartyOrderAdapter(ThirdPartyOrderDecryptService thirdPartyDecryptService) {
  this.thirdPartyDecryptService = thirdPartyDecryptService;
  }

  @Override
  public DecryptedOrder decrypt(String encryptedOrderNo) {
  // ���䣺���õ����������Ľ��ܷ���
  return thirdPartyDecryptService.decryptByCustom(encryptedOrderNo);
  }
  }
  ���� 5������������������������ܹ���ƥ�䣩
  ���ݶ�����Դ�Զ�ѡ���Ӧ������������������ϸ�ڣ�
  java
  ����
  /**
* �����������������������ģ�������Դƥ����ܹ���
  */
  public class OrderDecryptAdapterFactory {
  // ����������ʵ���������ظ�������
  private static final Map<String, OrderDecryptor> DECRYPTOR_MAP = new HashMap<>();

  // ��ʼ����ע�����ж�����Դ��Ӧ��������
  static {
  // APP����������
  DECRYPTOR_MAP.put("APP", new AppOrderAdapter(new AppOrderDecryptService()));
  // H5����������
  DECRYPTOR_MAP.put("H5", new H5OrderAdapter(new H5OrderDecryptService()));
  // ������ƽ̨����������
  DECRYPTOR_MAP.put("THIRD_PARTY", new ThirdPartyOrderAdapter(new ThirdPartyOrderDecryptService()));
  }

  /**
   * ���ݶ�����Դ��ȡ��Ӧ�Ľ�����
   * @param source ������Դ����APP��H5��
   * @return ƥ��Ľ�����
     */
     public static OrderDecryptor getDecryptor(String source) {
     OrderDecryptor decryptor = DECRYPTOR_MAP.get(source);
     if (decryptor == null) {
     throw new IllegalArgumentException("��֧�ֵĶ�����Դ��" + source);
     }
     return decryptor;
     }
     }
     ���� 6���������ӿڣ������ṩ����
     ǰ�˵��õĽӿڣ�������Ľ����߼���
     java
     ����
     /**
* �������ܽӿڣ�ǰ��ֱ�ӵ��ã�
  */
  @RestController
  @RequestMapping("/api/order")
  public class OrderDecryptController {

  /**
   * ���ܶ���
   * @param encryptedOrderNo ���ܵĶ�����
   * @param source ������Դ����APP��H5��THIRD_PARTY��
   * @return ���ܺ�Ķ�����Ϣ
     */
     @GetMapping("/decrypt")
     public Result<DecryptedOrder> decryptOrder(
     @RequestParam("encryptedOrderNo") String encryptedOrderNo,
     @RequestParam("source") String source) {

     // 1. ͨ��������ȡ��Ӧ��������������ľ�����ܹ���
     OrderDecryptor decryptor = OrderDecryptAdapterFactory.getDecryptor(source);

     // 2. ����ͳһ���ܷ���
     DecryptedOrder decryptedOrder = decryptor.decrypt(encryptedOrderNo);

     return Result.success(decryptedOrder);
     }
     }
3. ģʽ����
   Ŀ��ӿڣ�Target����OrderDecryptor������ͳһ�Ľ��ܷ�������ǰ�������Ľӿڡ�
   �����ߣ�Adaptee����AppOrderDecryptService��H5OrderDecryptService�ȣ�������ͬ��Դ�����ľ�������߼���
   ��������Adapter����AppOrderAdapter��H5OrderAdapter�ȣ�ʵ��OrderDecryptor�ӿڣ��ڲ����ö�Ӧ�����ߵĽ��ܷ�������ɽӿ�ת����
   ������Factory����OrderDecryptAdapterFactory�����ݶ�����Դ�Զ�ƥ�����������򻯵��÷��߼���
4. ����
   ǰ���޸�֪��ǰ��ֻ�贫�ݶ�����Դ�ͼ��ܶ����ţ������˽����ϸ�ڡ�
   ��չ��ǿ������������Դʱ��ֻ��ʵ���µ������ߺ�����������ע�ᵽ�����������޸����д��루���Ͽ���ԭ�򣩡�
   ��������߼���ҵ��ӿڷ��룬��ͬ��Դ�Ľ��ܹ��򻥲�Ӱ�졣
5. ��չ����
   �����ܹ����趯̬���ã�����������Ļ�ȡ������Կ����������������ע�����÷���
   ���ڸ��ӽ����߼�����������������ӻ��棨����ܽ�����棩���������ܡ�