package com.bubudeai;

import com.bubudeai.dto.ContentListDto;
import com.bubudeai.dto.DeleteGroupDto;
import com.bubudeai.dto.UpdateContentDto;
import com.bubudeai.entity.Contents;
import com.bubudeai.entity.Group;
import com.bubudeai.entity.User;
import com.bubudeai.mapper.ContentMapper;
import com.bubudeai.mapper.GroupMapper;
import com.bubudeai.mapper.UserMapper;
import com.bubudeai.service.ContentService;
import com.bubudeai.service.GroupService;
import com.bubudeai.utils.DateUtils;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        contents.setTitle("JVM"+"【"+i+"】");
        contents.setTabstract("JVM摘要"+"【"+i+"】"+"集");
        contents.setTitlePic("");
        contents.setContent("引入Java语言虚拟机后，Java语言在不同平台上运行时不需要重新编译。Java语言使用Java虚拟机屏蔽了与具体平台相关的信息，使得Java语言编译程序只需生成在Java虚拟机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。");
        contents.setTauthor("王雪松");
        contents.setCreated(DateUtils.getLocalDateTime());
        contents.setLastchange(DateUtils.getLocalDateTime());
        contents.setGid(1);
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

    @Test
    void contextLoad7(){
        List<ContentListDto> java = contentService.queryContentList("Java");
        for (ContentListDto con: java
             ) {
            System.out.println(con.toString());
        }
    }

    @Test
    void contextLoad8(){
        List<Group> groups = groupMapper.queryAllGroup();
        for (Group g:groups
             ) {
            System.out.println(g);
        }
    }

    @Test
    void contextLoad9(){
        UpdateContentDto updateContentDto = contentMapper.queryContentForUpdate(1);
        System.out.println(updateContentDto);

    }

    @Test
    void contextLoad10(){
        Contents contents = new Contents();
        contents.setTid(13);
        contents.setTitle("更新功能测试1");
        contents.setTabstract("测试更新功能1");
        contents.setContent("测试更新功能contents");
        contents.setTauthor("王雪松1");
        contents.setCreated(DateUtils.getLocalDateTime());
        contents.setLastchange(DateUtils.getLocalDateTime());
        contents.setGid(6);
        int i = contentMapper.updateContent(contents);
        System.out.println(i);
    }

    @Test
    void contextLoad11(){
        Group group = groupMapper.queryGroupForUpdate(1);
        System.out.println(group);
    }

    @Test
    void contextLoad12(){
        List<DeleteGroupDto> deleteGroupDtos = groupMapper.queryContentByGroupID(33);
        boolean empty = deleteGroupDtos.isEmpty();
        System.out.println(empty);
    }

    @Test
    void contextLoad13(){
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
        Date date = new Date();
        System.out.println(date);
    }
}
