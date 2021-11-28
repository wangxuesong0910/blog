package com.bubudeai.exception;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
