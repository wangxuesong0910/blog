package com.bubudeai.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiOperation("页面控制器")
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @ApiOperation("登录跳转页")
    @GetMapping(value = {"","/toLogin"})
    public String login(){
        return "login";
    }

    @ApiOperation("后台添加页面")
    @RequiresAuthentication//验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
    @RequestMapping("/addgroup")
    public String addGroup(){
        return "admin/addgroup";
    }

    @ApiOperation("授权登录后跳转")
    @RequestMapping("/admin")
    public String admin(){
        return "admin/index";
    }

    @ApiOperation("后台添加页面")
    @RequiresAuthentication//验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
    @RequestMapping("/add")
    public String add(){
        return "admin/add";
    }

}
