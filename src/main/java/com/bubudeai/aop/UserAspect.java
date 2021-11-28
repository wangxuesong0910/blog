package com.bubudeai.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/26/12:22
 * @Description: 对每次用户登录，权限认证操作进行日志记录
 **/
@Aspect
@Component
public class UserAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut(value = "execution(* com.bubudeai.controller.UserController.login(..))")
    public void userPoint(){}


    //用户登录前获取用户登录信息并记录日志
    @Before(value = "userPoint()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        System.out.println("attributes的值："+attributes);
        //获取请求的HttpServletRequest对象
        HttpServletRequest request = attributes.getRequest();
        System.out.println("request的值："+request);
        //获取Session对象
        HttpSession session = request.getSession();
        System.out.println("session的值: "+ session);
        //获取请求的URL
        LOGGER.info("URL|: "+ request.getRequestURL().toString());
        //获取请求方式
        LOGGER.info("HTTP_METHOD : " + request.getMethod());
        //获取请求者的IP地址
        LOGGER.info("IP : " + request.getRemoteAddr());
        //获取请求者的主机名
        LOGGER.info("主机名 : " + request.getRemoteHost());
        //获取请求的方法名以及包名
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取请求的参数
        LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        LOGGER.info("用户登录操作...");
    }

}
