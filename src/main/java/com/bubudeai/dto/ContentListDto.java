package com.bubudeai.dto;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *此dto为文章列表映射字段
 * @Author: wxs
 * @Date: 2021/11/21/14:24
 * @Description:
 **/
@ApiOperation("文章列表字段")
@Component
@Data
public class ContentListDto {
    /**
     * 文章主键
     */
    private Integer tid;
    /**
     *文章标题
     */
    private String title;
    /**
     *摘要
     */
    private String tabstract;
}
