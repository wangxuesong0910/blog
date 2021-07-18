package com.bubudeai.entity;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiOperation("技术分类实体")
@Data
@Component
public class Group {
    private Integer gid;
    private String gname;
    private Date created;
}
