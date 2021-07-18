package com.bubudeai.mapper;

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


}
