package com.bubudeai.dto;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/23/16:30
 * @Description:
 **/
@ApiOperation("后台主页文章列表字段")
@Component
@Data
public class AdminContentDto {
    /**
     * 文章主键
     */
    private Integer tid;
    /**
     *文章标题
     */
    private String title;
}
