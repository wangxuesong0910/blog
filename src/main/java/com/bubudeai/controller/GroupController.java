package com.bubudeai.controller;

import com.bubudeai.common.Result;
import com.bubudeai.common.ResultCode;
import com.bubudeai.entity.Group;
import com.bubudeai.service.GroupService;
import com.bubudeai.utils.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@ApiOperation("技术分类")
@Controller
@RequestMapping("/group")
public class GroupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);
    @Autowired
    GroupService groupService;

    @ApiOperation("获取全部技术分类")
    @GetMapping("/all")
    @ResponseBody
    public Result queryAllGroup(HttpServletRequest httpServletRequest) {
        List<Group> groups = groupService.queryAllGroup();
        httpServletRequest.setAttribute("groups", groups);
        return Result.succ(groups);
    }

    @ApiOperation("添加技术")
    @RequiresAuthentication
    @PostMapping("/add")
    @ResponseBody
    public Result addGroup(String gname) {
/**
 * 这只是简单修改，文章模块写完，再次删除时需要判断当前技术分类下，是否有文章分类，如果有，先删除文章，再删除技术分类
 */
        int i = groupService.addGroup(gname);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED);
    }

    @ApiOperation("删除技术")
    @RequiresAuthentication
    @GetMapping("/delete")
    @ResponseBody
    public Result deleteGroup(int gid) {
        int i = groupService.deleteGroup(gid);
        if (i == 1) {
            return Result.succ(ResultCode.SUCCESS);
        }
        return Result.failed(ResultCode.FAILED);
    }
}
