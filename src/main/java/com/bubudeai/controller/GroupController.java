package com.bubudeai.controller;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import com.bubudeai.entity.Group;
import com.bubudeai.service.GroupService;
import com.bubudeai.utils.DateUtils;
import com.bubudeai.utils.EntityUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ApiOperation("技术分类")
@Controller
@RequestMapping("/group")

public class GroupController {

    @Autowired
    GroupService groupService;

    @ApiOperation("获取全部技术分类")
    @GetMapping("/all")
    @ResponseBody
    public Result queryAllGroup() {
        List<Group> groups = groupService.queryAllGroup();
        return Result.succ(groups);
    }

    @ApiOperation("添加技术")
    @RequiresAuthentication
    @PostMapping("/add")
    @ResponseBody
    public Result addGroup( @RequestParam(value = "gname")String gname
                            ,@RequestParam(value = "created")String created
                            ,@RequestParam(value = "gcontent")String gcontent
                            ,@RequestParam(value = "gsvg")String gsvg) {

        Group group = EntityUtils.getGroup();
        group.setGname(gname);
        LocalDateTime localDateTime = DateUtils.formatTime(created);
        group.setCreated(localDateTime);
        group.setGcontent(gcontent);
        group.setGsvg(gsvg);
        int i = groupService.addGroup(group);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED);
    }

    @ApiOperation("删除技术")
    @RequiresAuthentication
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteGroup(int gid) {
//        这只是简单修改，文章模块写完，再次删除时需要判断当前技术分类下，是否有文章分类，如果有，先删除文章，再删除技术分类
        int i = groupService.deleteGroup(gid);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED,"当前技术分类下还有文章，请先删除文章后再试");
    }

    @ApiOperation("根据gid获取指定技术")
    @RequiresAuthentication
    @GetMapping("/queryForUpdate")
    @ResponseBody
    public Result queryGroupForUpdate(@RequestParam(value = "gid")int gid){
        Group group = groupService.queryGroupForUpdate(gid);


        String created = DateUtils.formatTime(group.getCreated());
        return Result.succ(group,created,null);
    }


    @ApiOperation("更新技术")
    @RequiresAuthentication
    @PostMapping("/update")
    @ResponseBody
    public Result updateGroup(@RequestParam(value = "gid")int gid
                                , @RequestParam(value = "gname")String gname
                                , @RequestParam(value = "created")String created
                                , @RequestParam(value = "gcontent")String gcontent
                                , @RequestParam(value = "gsvg")String gsvg) {

        Group group = EntityUtils.getGroup();
        group.setGid(gid);
        group.setGname(gname);
        LocalDateTime localDateTime = DateUtils.formatTime(created);
        group.setCreated(localDateTime);
        group.setGcontent(gcontent);
        group.setGsvg(gsvg);
        int i = groupService.updateGroup(group);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }


        return Result.failed(ResultCode.FAILED);
    }
}
