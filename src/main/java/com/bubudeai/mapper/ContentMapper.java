package com.bubudeai.mapper;

import com.bubudeai.dto.AdminContentDto;
import com.bubudeai.dto.ContentListDto;
import com.bubudeai.dto.UpdateContentDto;
import com.bubudeai.entity.Contents;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiOperation("文章Dao")
@Mapper
@Repository
public interface ContentMapper {

    @ApiOperation("根据前端页面传入分组名称查询文章列表")
    List<ContentListDto> queryContentList(String name);

    @ApiOperation("添加文章")
    int addArticle(Contents contents);

    @ApiOperation("分页查询文章列表")
    List<Contents> queryContentById(int id,PageRowBounds pageRowBounds);

    @ApiOperation("根据id查询文章")
    Contents queryContent(int tid);

    @ApiOperation("用于更新文章的查询")
    UpdateContentDto queryContentForUpdate(int tid);

    @ApiOperation("更新文章")
    int updateContent(Contents contents);

    @ApiOperation("后台主页用于显示指定技术分类的所有文章")
    List<AdminContentDto> queryContentForAdmin(int gid);

    @ApiOperation("根据tid删除文章")
    int deleteContent(int tid);
}
