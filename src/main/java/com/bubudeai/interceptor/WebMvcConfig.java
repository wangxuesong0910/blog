package com.bubudeai.interceptor;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA
 *此页面是对Spring MVC的自定义配置，虽然Spring Boot 对MVC的
 * 自动配置可以满足大部分需求，但也可 通过自定义配置类并实现WebMvcConfig
 * 接口来定制Spring MVC 配置；例如拦截器、格式化程序、视图控制、跨域处理等
 * @Author: wxs
 * @Date: 2021/11/21/12:32
 * @Description:
 **/
@ApiOperation("定制MVC 配置")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @ApiOperation("无业务逻辑跳转")
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 所有 / 请求都会跳转到index.html页面
         */
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin/index");
    }
}
