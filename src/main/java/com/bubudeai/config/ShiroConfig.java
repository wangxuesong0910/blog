package com.bubudeai.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator d = new DefaultAdvisorAutoProxyCreator();
        d.setProxyTargetClass(true);
        return d;
    }

//    @Autowired
//    DefaultWebSessionManager defaultSessionManager;

    /**
     * 1. Apache Shiro 的核心通过 Filter 来实现
     * 基础搭建需要：
     * ShiroFilterFactoryBean：shiro过滤工厂bean
     * MyShiroRealm：自定义Realm
     * SecurityManager：安全管理器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        //获取一个工厂bean
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //// 拦截器.(配置要拦截的内容)
        Map<String, String> filterMap = new LinkedHashMap<>();

        /**
         *添加shiro的内置过滤器
         *  anon：无需认证就可以访问
         *  authc：必须认证才可访问
         *  user：必须有记住我 功能才可使用
         *  perms：拥有对某个资源的权限才能访问
         *  role：拥有某个角色权限才能访问
         */
        // 配置不会被拦截的链接 顺序判断
        filterMap.put("/static/**", "anon");
        // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //拦截更新请求
        filterMap.put("/admin/toLogin","anon");
        filterMap.put("/admin/**", "authc");


        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //设置登录请求
        bean.setLoginUrl("/admin/toLogin");

        //
        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm) {
        //安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        //设置自己的自定义Realm
        securityManager.setRealm(userRealm);


        return securityManager;

    }

    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager defaultSessionManager = new DefaultWebSessionManager();
        return defaultSessionManager;
    }

    //创建自定义Realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
