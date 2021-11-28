package com.bubudeai.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/21/12:37
 * @Description: 此Controller 用于页面的跳转请求
 **/
@ApiOperation("用于页面跳转的请求")
@Controller
public class PageController {
    private final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/gocontent")
    public String goToContentList(@RequestParam("name")String name, Model model){
        model.addAttribute("content",name);
        System.out.println("name: "+name);
        return "contentlist";
    }

    @RequestMapping("/goblog")
    public String goToBlog(@RequestParam("tid")int tid, Model model){
        model.addAttribute("tid",tid);
        System.out.println("tid:"+tid);
        return "blog";
    }



}
