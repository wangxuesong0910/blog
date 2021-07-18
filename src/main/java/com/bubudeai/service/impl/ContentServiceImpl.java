package com.bubudeai.service.impl;

import com.bubudeai.entity.Contents;
import com.bubudeai.mapper.ContentMapper;
import com.bubudeai.service.ContentService;
import com.bubudeai.utils.DateUtils;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;
    @Transactional
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
        contents.setCreated(DateUtils.getTime());
        contents.setLastchange(DateUtils.getTime());
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
}
