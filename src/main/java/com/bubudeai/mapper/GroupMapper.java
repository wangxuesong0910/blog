package com.bubudeai.mapper;

import com.bubudeai.dto.DeleteGroupDto;
import com.bubudeai.entity.Group;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiOperation("分类")
@Mapper
@Repository
public interface GroupMapper {

    @ApiOperation("添加分类")
    int addGroup(Group group);

    @ApiOperation("获取全部分类")
    List<Group> queryAllGroup();

    @ApiOperation("删除分类")
    int deleteGroup(int gid);

    @ApiOperation("获取指定id的技术分类")
    Group queryGroupForUpdate(int gid);

    @ApiOperation("更新分类")
    int updateGroup(Group group);

    @ApiOperation("删除前查询当前技术分类下是否还有文章")
    List<DeleteGroupDto> queryContentByGroupID(int gid);


}
