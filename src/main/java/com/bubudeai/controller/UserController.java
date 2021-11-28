package com.bubudeai.controller;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import com.bubudeai.entity.User;
import com.bubudeai.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Api("登录相关接口")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserMapper userMapper;


    @ApiOperation("登录")
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(name = "username")String username,  @RequestParam(name = "password")String password,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        User user = userMapper.queryUser(username);
        try {
            //执行登录方法，如果没有异常就说明加密ok
            subject.login(token);
            //设置session
            httpServletRequest.getSession().setAttribute("user", user);
            return Result.succ(ResultCode.SUCCESS);
        } catch (UnknownAccountException e) {
            return Result.failed(ResultCode.FAILED);
        }catch (IncorrectCredentialsException e){
            return Result.failed(ResultCode.FAILED);
        }

    }

    @ApiOperation("登录")
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest httpServletRequest){
        //删除session值
        httpServletRequest.removeAttribute("user");
        //使当前会话无效，取消任何绑定到它的对象的绑定
        httpServletRequest.getSession().invalidate();
        return "admin/login";
    }



}
