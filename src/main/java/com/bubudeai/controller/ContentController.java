package com.bubudeai.controller;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import com.bubudeai.dto.AdminContentDto;
import com.bubudeai.dto.ContentListDto;
import com.bubudeai.dto.UpdateContentDto;
import com.bubudeai.entity.Contents;
import com.bubudeai.service.ContentService;
import com.bubudeai.utils.DateUtils;
import com.bubudeai.utils.EntityUtils;
import com.bubudeai.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@ApiOperation("博客后台操作")
@Controller
@RequestMapping("/content")
public class ContentController {
    //PageHelper 中每次分页查询的包含多少个数据：pageSize = 8;
    private int pageSize = 8;

    @Autowired
    ContentService contentService;

    @ApiOperation("添加文章")
    @ResponseBody
    @PostMapping("/add")
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
    @ResponseBody
    @GetMapping("/queryContentById")
    public Result queryContentById(@RequestParam(value = "page") int page, @RequestParam(value = "gid") int gid) {
        //逻辑分页示例
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
    @ResponseBody
    @GetMapping("/queryContent")
    public Result queryContent(@RequestParam(value = "tid") int tid){
        Contents contents = contentService.queryContent(tid);
        return Result.succ(contents);
    }

    @ApiOperation("根据前端页面传入的name查询文章列表")
    @ResponseBody
    @RequestMapping("/goContentList")
    public Result queryContentList(@RequestParam("name")String name,@RequestParam("pageNum") int pageNum){
        //PageHelper只对紧跟着的第一个SQL语句起作用.
        PageHelper.startPage(pageNum,pageSize);
        List<ContentListDto> contentListDtos = contentService.queryContentList(name);
        return Result.succ(contentListDtos);
    }

    @ApiOperation("用于更新文章的查询")
    @ResponseBody
    @RequestMapping("/queryForUpdate")
    public Result queryContentForUpdate(@RequestParam(value = "tid")int tid){
        UpdateContentDto updateContentDto = contentService.queryContentForUpdate(tid);
        Contents contents = updateContentDto.getContents();
        String created = DateUtils.formatTime(contents.getCreated());
        String lastchange = DateUtils.formatTime(contents.getLastchange());
        return Result.succ(updateContentDto,created,lastchange);
    }

    @ApiOperation("用于文章的更新")
    @ResponseBody
    @PostMapping("/updateContent")
    public Result updateContent(           @RequestParam(value = "tid") int tid,
                                             @RequestParam(value = "title") String title,
                                             @RequestParam(value = "interest") Integer gid,
                                            @RequestParam(value = "tabstract") String tabstract,
                                            @RequestParam(value = "content") String content,
                                            @RequestParam(value = "tauthor") String tauthor,
                                            @RequestParam(value = "created") String created,
                                            @RequestParam(value = "lastchange") String lastchange){
        Contents contents = EntityUtils.getContents();
        contents.setTid(tid);
        contents.setTitle(title);
        contents.setGid(gid);
        contents.setTabstract(tabstract);
        contents.setContent(content);
        contents.setTauthor(tauthor);
        contents.setCreated(DateUtils.formatTime(created));
        contents.setLastchange(DateUtils.formatTime(lastchange));
        int i = contentService.updateContent(contents);
        if (i==1){
            return Result.succ(ResultCode.SUCCESS);
        }
       return Result.failed(ResultCode.FAILED);
    }

    @ApiOperation("后台主页用于显示指定技术分类的所有文章")
    @ResponseBody
    @RequestMapping("/queryContentForAdmin")
    public Result queryContentForAdmin(@RequestParam(value = "gid")int gid){
        List<AdminContentDto> adminContentDtos = contentService.queryContentForAdmin(gid);
        return Result.succ(adminContentDtos);
    }

    @ApiOperation("删除文章")
    @ResponseBody
    @RequestMapping("/deleteContent")
    public Result deleteContent(@RequestParam(value = "tid")int tid){
        int i = contentService.deleteContent(tid);
        if (i==1){
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED);
    }

}
