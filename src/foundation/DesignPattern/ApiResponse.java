package foundation.DesignPattern;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ͳһAPI��Ӧ��ʽ
 * @param <T> ��Ӧ��������
 */
@Data
public class ApiResponse<T> implements Serializable {

    /**
     * ��Ӧ״̬�루200��ʾ�ɹ�����200��ʾʧ�ܣ�
     */
    private int code;

    /**
     * ��Ӧ��Ϣ���ɹ�/ʧ��������
     */
    private String message;

    /**
     * ��Ӧ���ݣ��ɹ�ʱ���ص����ݣ�ʧ��ʱ��Ϊnull��
     */
    private T data;

    /**
     * ��Ӧʱ���������������ʱ�䣩
     */
    private LocalDateTime timestamp;


    // ------------------------------ ���췽�� ------------------------------
    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now(); // �Զ���䵱ǰʱ��
    }


    // ------------------------------ ��̬�����������Ƽ�ʹ�ã� ------------------------------

    /**
     * �ɹ���Ӧ�������ݣ�
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(200, "�����ɹ�", null);
    }

    /**
     * �ɹ���Ӧ�������ݣ�
     * @param data ��Ӧ����
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "�����ɹ�", data);
    }

    /**
     * �ɹ���Ӧ���Զ�����Ϣ+���ݣ�
     * @param message �ɹ���Ϣ
     * @param data ��Ӧ����
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }


    /**
     * ʧ����Ӧ��ʹ��Ĭ����Ϣ��
     * @param code �����루��200��
     */
    public static <T> ApiResponse<T> fail(int code) {
        return new ApiResponse<>(code, "����ʧ��", null);
    }

    /**
     * ʧ����Ӧ���Զ��������Ϣ��
     * @param code �����루��200��
     * @param message ��������
     */
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * ʧ����Ӧ�����������ݣ�����֤ʧ�ܵ��ֶ���Ϣ��
     * @param code �����루��200��
     * @param message ��������
     * @param data ����������ݣ���У��ʧ�ܵ��ֶ��б�
     */
    public static <T> ApiResponse<T> fail(int code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

}