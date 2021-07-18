package com.bubudeai.mapper;

import com.bubudeai.entity.Contents;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@ApiOperation("文章Dao")
@Mapper
@Repository
public interface ContentMapper {
    @ApiOperation("添加文章")
    int addArticle(Contents contents);

    @ApiOperation("分页查询文章列表")
    List<Contents> queryContentById(int id,PageRowBounds pageRowBounds);

    @ApiOperation("根据id查询文章")
    Contents queryContent(int tid);
}
