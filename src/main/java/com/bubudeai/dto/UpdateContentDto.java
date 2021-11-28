package com.bubudeai.dto;

import com.bubudeai.entity.Contents;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: wxs
 * @Date: 2021/11/22/22:10
 * @Description:
 **/
@ApiOperation("更新博客")
@Component
@Data
public class UpdateContentDto {
    private String gname;
    private Contents contents;
}
