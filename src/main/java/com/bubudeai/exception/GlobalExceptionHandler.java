package com.bubudeai.exception;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//全局异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {


    //捕获Shiro异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ShiroException.class)
    public Result shiroException(ShiroException e){
        System.out.println("shiro****************");
        e.printStackTrace();
        System.out.println("shiro****************");
        return Result.failed(ResultCode.UNAUTHORIZED);
    }

    //运行时异常捕获
    @ExceptionHandler(RuntimeException.class)
    public Result baseException(RuntimeException e){
        e.printStackTrace();
        return Result.failed(e.getMessage());
    }

}
