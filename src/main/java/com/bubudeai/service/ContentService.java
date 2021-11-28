package com.bubudeai.service;

import com.bubudeai.dto.AdminContentDto;
import com.bubudeai.dto.ContentListDto;
import com.bubudeai.dto.UpdateContentDto;
import com.bubudeai.entity.Contents;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ContentService {

    List<ContentListDto> queryContentList(String name);

    int addArticle(@RequestParam(name = "title")String title,
                   @RequestParam(name = "interest")Integer gid,
                   @RequestParam(name = "tabstract")String tabstract,
                   @RequestParam(name = "content")String content);

    List<Contents> queryContentById(int id,PageRowBounds pageRowBounds);

    Contents queryContent(int tid);


    UpdateContentDto queryContentForUpdate(int tid);

    int updateContent(Contents contents);

    List<AdminContentDto> queryContentForAdmin(int gid);

    int deleteContent(int tid);
}
