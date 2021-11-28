package com.bubudeai.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data

public class Result<T>  implements Serializable{
    //状态码
    private long code;
    //提示信息
    private String msg;
    //数据封装
    private T data;
    //分页数据
    private long pages;
    //格式化提交日期
    private String created;
    //格式化修改日期
    private String lastchange;

    public Result() {
    }

    public Result(long code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Result(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(long code, String msg, T data, long pages) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pages = pages;
    }

    public Result(long code, String msg, T data, String created, String lastchange) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.created = created;
        this.lastchange = lastchange;
    }

    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> succ(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    /**
     * 查询格式化后的日期 返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> succ(T data,String created,String lastchange){
        return new Result<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data,created,lastchange);
    }
    /**
     * 分页查询成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> succ(T data,long pages){
        return new Result<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data,pages);
    }

    /**
     * 成功返回结果
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> succ(T data,String message){
        return new Result<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(IErrorCode errorCode){
        return new Result<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param errorCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(IErrorCode errorCode,String message){
        return new Result<T>(errorCode.getCode(),message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(String message){
        return new Result<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 失败返回结果
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> Result<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }
    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> Result<T> badRequest(){
        return failed(ResultCode.BAD_REQUEST);
    }
    /**
     * 参数验证失败返回结果提示信息
     */

    public static <T> Result<T> validateFailed(String message){
        return new Result<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data){
        return new Result<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data){
        return new Result<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
    }

}
