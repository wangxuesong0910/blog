package com.bubudeai.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@ApiOperation("页面控制器")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @ApiOperation("登录跳转页")
    @RequestMapping("/toLogin")
    public String login(){
        return "admin/login";
    }

    @ApiOperation("后台添加页面")
    @RequiresAuthentication//验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
    @RequestMapping("/addgroup")
    public String addGroup(){
        return "admin/addgroup";
    }

//    @ApiOperation("后台添加页面")
//    @RequiresAuthentication//验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
//    @RequestMapping("/updateGroup")
//    public String updateGroup(){
//        return "admin/updateGroup";
//    }

    @ApiOperation("授权登录后跳转")
    @RequestMapping("/index")
    @RequiresAuthentication
    public String admin(){
        return "admin/index";
    }

    @ApiOperation("后台添加页面")
    @RequiresAuthentication//验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
    @RequestMapping("/addContent")
    public String add(){
        return "admin/addContent";
    }

    @ApiOperation("更新文章跳转")
    @RequestMapping("/updateContent")
    @RequiresAuthentication
    public String update(@RequestParam(value = "tid")int tid, Model model){
        model.addAttribute("tid",tid);
        return "admin/updateContent";
    }

    @ApiOperation("授权登录后跳转")
    @RequestMapping("/groupIndex")
    @RequiresAuthentication
    public String groupIndex(){
        return "admin/groupIndex";
    }

    @ApiOperation("更新技术分类跳转")
    @RequestMapping("/updateGroup")
    @RequiresAuthentication
    public String updateGroup(@RequestParam(value = "gid")int gid, Model model){
        model.addAttribute("gid",gid);
        return "admin/updateGroup";
    }
}
