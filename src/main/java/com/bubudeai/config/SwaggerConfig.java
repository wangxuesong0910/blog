package com.bubudeai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger2
@Profile({"prod","test"})
public class SwaggerConfig {
    //配置了swagger 的Docket 的bean 实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage：指定要扫描的包
                //any（）：扫描全部
                //none（）：不扫描
                //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.bubudeai.controller"))
                //paths（），过滤什么路径
                //.paths(PathSelectors.ant("/bubudeai/**"))
                .build();
    }

    //配置Swagger 信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("卟卟的爱","www.baidu.com","2248595783@qq.com");
        return new ApiInfo("卟卟的爱API文档"
                , "卟卟自定义Documentation"
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }
}
