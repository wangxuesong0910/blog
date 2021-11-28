package com.bubudeai.service.impl;

import com.bubudeai.controller.PageController;
import com.bubudeai.dto.AdminContentDto;
import com.bubudeai.dto.ContentListDto;
import com.bubudeai.dto.UpdateContentDto;
import com.bubudeai.entity.Contents;
import com.bubudeai.mapper.ContentMapper;
import com.bubudeai.service.ContentService;
import com.bubudeai.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {


    @Autowired
    ContentMapper contentMapper;

    @Override
    public List<ContentListDto> queryContentList(String name) {

        List<ContentListDto> contentListDtos = contentMapper.queryContentList(name);

        return contentListDtos;
    }

    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int addArticle(@RequestParam(name = "title")String title,
                          @RequestParam(name = "interest")Integer gid,
                          @RequestParam(name = "tabstract")String tabstract,
                          @RequestParam(name = "content")String content) {

        Contents contents = new Contents();
        contents.setTitle(title);
        contents.setTabstract(tabstract);
        contents.setTitlePic("");
        contents.setContent(content);
        contents.setTauthor("王雪松");

        contents.setCreated(DateUtils.getLocalDateTime());
        contents.setLastchange(DateUtils.getLocalDateTime());
        contents.setGid(gid);
        int i = contentMapper.addArticle(contents);
        return i;
    }

    @Override
    public List<Contents> queryContentById(int id,PageRowBounds pageRowBounds) {

        List<Contents> contents = contentMapper.queryContentById(id,pageRowBounds);

        return contents;
    }

    @Override
    public Contents queryContent(int tid) {
        Contents contents = contentMapper.queryContent(tid);
        return contents;
    }

    @Override
    public UpdateContentDto queryContentForUpdate(int tid) {
        UpdateContentDto updateContentDto = contentMapper.queryContentForUpdate(tid);
        return updateContentDto;
    }

    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int updateContent(Contents contents) {
        int i = contentMapper.updateContent(contents);
        return i;
    }

    @Override
    public List<AdminContentDto> queryContentForAdmin(int gid) {
        List<AdminContentDto> adminContentDtos = contentMapper.queryContentForAdmin(gid);
        return adminContentDtos;
    }

    @Transactional(rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public int deleteContent(int tid) {
        int i = contentMapper.deleteContent(tid);
        return i;
    }
}
