package com.bubudeai;

import com.bubudeai.entity.Contents;
import com.bubudeai.entity.Group;
import com.bubudeai.entity.User;
import com.bubudeai.mapper.ContentMapper;
import com.bubudeai.mapper.GroupMapper;
import com.bubudeai.mapper.UserMapper;
import com.bubudeai.service.ContentService;
import com.bubudeai.service.GroupService;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MysiteBlogApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ContentMapper contentMapper;
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupService groupService;
    @Autowired
    ContentService contentService;

    @Test
    void contextLoads() {
        Contents contents = new Contents();
        for (int i = 0; i <20 ; i++) {

        contents.setTitle("Docker文档"+"【"+i+"】");
        contents.setTabstract("Docker文档常用命令"+"【"+i+"】"+"集");
        contents.setTitlePic("");
        contents.setContent("DOCKER，我们需要用到PS1，PS1是Linux终端用户的一个环境变量，用来说明命令行提示符的设置。在终端输入命令：#set，即可在输出中找到关于PS1的定义如下：");
        contents.setTauthor("王雪松");
        contents.setCreated(new Date());
        contents.setLastchange(new Date());
        contents.setGid(3);
        int ii = contentMapper.addArticle(contents);
        System.out.println(ii);
        }
    }

    @Test
    void contextLoads1(){
//        Group group = new Group();
//        group.setGname("SQL");
//        group.setCreated(new Date());
//        int i = groupService.addGroup(group);
//        System.out.println(i);

        int i = groupMapper.deleteGroup(7);
        System.out.println(i);


    }

    @Test
    void contextLoads2() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(date);
        Date parse = sd.parse(format);
        System.out.println(format);
        System.out.println(parse);
    }

    @Test
    void contextLoad3(){
        List<Group> groups = groupService.queryAllGroup();
        for (Group group: groups
             ) {
            System.out.println(group);
        }
    }

    @Test
    void contextLoad4() {
       contentService.addArticle("sql", 1, "aaaaaaaaaa", "定义一个工厂类，它可以根据参数的不同返回不同的实例，而被创建的实例通常都有==共同的父类==");
    }

    @Test
    void contextLoad5() {
        int offset = 1;
        int limit = 5;
        PageRowBounds rowBounds = new PageRowBounds(offset, limit);
        List<Contents> contents = contentService.queryContentById(1,rowBounds);
        Long total = rowBounds.getTotal();
        Boolean count = rowBounds.getCount();
        System.out.println(total);
        System.out.println(count);
        for (Contents con: contents
             ) {
            System.out.println(con);
        }
    }

    @Test
    void contextLoad6(){
        Contents contents = contentMapper.queryContent(9);
        System.out.println(contents);
    }
}
