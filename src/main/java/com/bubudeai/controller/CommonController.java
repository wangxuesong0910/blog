package com.bubudeai.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@ApiOperation("公共处理跳转")
@Controller
@RequestMapping("/common")
public class CommonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
//    @RequestMapping("/error")
//    public String commonError(){
//        return "error/404";
//    }

    @GetMapping("/blog")
    public String toBlog(){
        return "blog/blog";
    }
}
