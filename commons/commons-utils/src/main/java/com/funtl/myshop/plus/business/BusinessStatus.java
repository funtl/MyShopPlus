package com.funtl.myshop.plus.business;

/**
 * 全局业务状态码
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-24 01:20:16
 * @see com.funtl.myshop.plus.business
 */
public enum BusinessStatus {
    /**
     * 管理员 - 账号密码错误
     */
    ADMIN_PASSWORD(100101, "管理员账号密码错误"),

    /**
     * 未知错误
     */
    UNKNOWN(-1, "未知错误"),

    /**
     * 请求成功
     */
    OK(20000, "成功"),

    /**
     * 请求失败
     */
    FAIL(20001, "失败"),

    /**
     * 熔断请求
     */
    BREAKING(20002, "熔断"),

    /**
     * 非法请求
     */
    ILLEGAL_REQUEST(50000, "非法请求"),

    /**
     * 非法令牌
     */
    ILLEGAL_TOKEN(50008, "非法令牌"),

    /**
     * 其他客户登录
     */
    OTHER_CLIENTS_LOGGED_IN(50012, "其他客户登录"),

    /**
     * 令牌已过期
     */
    TOKEN_EXPIRED(50014, "令牌已过期");

    private Integer code;
    private String message;

    BusinessStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessage(int code) {
        for (BusinessStatus status : values()) {
            if (status.getCode().equals(code)) {
                return status.getMessage();
            }
        }
        return null;
    }
}
