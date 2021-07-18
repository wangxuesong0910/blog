package com.bubudeai.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

@ApiOperation("主页跳转")
@Controller
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping("/")
    public String index(){
        return "index";
    }
//    @RequestMapping("/admin")
//    public String admin(){
//        return "redirect:/toLogin";
//    }
}
