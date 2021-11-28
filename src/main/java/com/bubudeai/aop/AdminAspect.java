package com.bubudeai.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/27/13:53
 * @Description:
 **/
@Aspect
@Component
public class AdminAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(AdminAspect.class);

    @Pointcut(value = "execution(* com.bubudeai.service.impl.*.*(..))")
    public void servicePoint(){}

    @Before(value = "servicePoint()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("IP地址："+request.getRequestURL()+"调用："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"方法");
        LOGGER.info("请求参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "servicePoint()")
    public void doAfterThrowing(JoinPoint joinPoint){
        LOGGER.error(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"出现了一个异常");
    }
}
