package com.bubudeai.common;

/**
 * 枚举了一些常用API操作码
 */
public enum  ResultCode implements IErrorCode {
    SUCCESS(200,"操作成功"),
    TABLE_SUCCESS(0,"操作成功"),
    FAILED(500,"服务器错误，操作失败"),
    VALIDATE_FAILED(404,"参数校验失败"),
    UNAUTHORIZED(401,"未登录或token已经过期"),
    BAD_REQUEST(400,"错误请求"),
    FORBIDDEN(403,"没有相关权限");



    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
