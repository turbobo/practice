package foundation.DesignPattern;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 统一API响应格式
 * @param <T> 响应数据类型
 */
@Data
public class ApiResponse<T> implements Serializable {

    /**
     * 响应状态码（200表示成功，非200表示失败）
     */
    private int code;

    /**
     * 响应消息（成功/失败描述）
     */
    private String message;

    /**
     * 响应数据（成功时返回的数据，失败时可为null）
     */
    private T data;

    /**
     * 响应时间戳（服务器处理时间）
     */
    private LocalDateTime timestamp;


    // ------------------------------ 构造方法 ------------------------------
    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now(); // 自动填充当前时间
    }


    // ------------------------------ 静态工厂方法（推荐使用） ------------------------------

    /**
     * 成功响应（无数据）
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(200, "操作成功", null);
    }

    /**
     * 成功响应（带数据）
     * @param data 响应数据
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "操作成功", data);
    }

    /**
     * 成功响应（自定义消息+数据）
     * @param message 成功消息
     * @param data 响应数据
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }


    /**
     * 失败响应（使用默认消息）
     * @param code 错误码（非200）
     */
    public static <T> ApiResponse<T> fail(int code) {
        return new ApiResponse<>(code, "操作失败", null);
    }

    /**
     * 失败响应（自定义错误消息）
     * @param code 错误码（非200）
     * @param message 错误描述
     */
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * 失败响应（带错误数据，如验证失败的字段信息）
     * @param code 错误码（非200）
     * @param message 错误描述
     * @param data 错误相关数据（如校验失败的字段列表）
     */
    public static <T> ApiResponse<T> fail(int code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

}