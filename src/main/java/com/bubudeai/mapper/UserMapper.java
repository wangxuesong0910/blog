package com.bubudeai.mapper;

import com.bubudeai.entity.User;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@ApiOperation("用户DAO")
@Repository
@Mapper
public interface UserMapper {
   @ApiOperation("登录查询方法")
   User queryUser(String username);
}
