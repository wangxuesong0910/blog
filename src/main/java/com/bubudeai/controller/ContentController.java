package com.bubudeai.controller;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import com.bubudeai.entity.Contents;
import com.bubudeai.service.ContentService;
import com.bubudeai.utils.PageUtils;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("博客后台操作")
@Controller
@RequestMapping("/content")
public class ContentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);
    @Autowired
    ContentService contentService;

    @ApiOperation("添加文章")
    @PostMapping("/add")
    @ResponseBody
    public Result addContent(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "interest") Integer gid,
            @RequestParam(value = "tabstract") String tabstract,
            @RequestParam(value = "content") String content
    ) {
        int i = contentService.addArticle(title, gid, tabstract, content);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED);
    }


    @ApiOperation("据id遍历获取文章列表")
    @GetMapping("/queryContentById")
    @ResponseBody
    public Result queryContentById(@RequestParam(value = "page") int page, @RequestParam(value = "gid") int gid) {
        //由于前端传来的page参数由layui加载，所以page从1开始累加
        PageRowBounds pageRowBounds = PageUtils.getPageRowBounds(5 * page - 5, 5);

        List<Contents> contents = contentService.queryContentById(gid, pageRowBounds);
        //获取总数
        Long total = pageRowBounds.getTotal();
        if (total==0){
            return Result.succ(contents, 0);
        }
        //计算得到总页数
        int pages = (int) (total / 5);
        if (total % 5 != 0) {
            pages++;
        }
        return Result.succ(contents, pages);
    }

    @ApiOperation("根据tid获取文章内容")
    @GetMapping("/queryContent")
    @ResponseBody
    public Result queryContent(@RequestParam(value = "tid") int tid){
        Contents contents = contentService.queryContent(tid);
        return Result.succ(contents);
    }


}
