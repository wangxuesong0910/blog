package com.bubudeai.dto;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/25/12:39
 * @Description:
 **/
@ApiOperation("删除技术分类")
@Component
@Data
public class DeleteGroupDto {
    /**
     * 文章主键
     */
    private int tid;
}
