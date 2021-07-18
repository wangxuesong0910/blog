package com.bubudeai.service;

import com.bubudeai.entity.Contents;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ContentService {
    int addArticle(@RequestParam(name = "title")String title,
                   @RequestParam(name = "interest")Integer gid,
                   @RequestParam(name = "tabstract")String tabstract,
                   @RequestParam(name = "content")String content);

    List<Contents> queryContentById(int id,PageRowBounds pageRowBounds);

    Contents queryContent(int tid);
}
