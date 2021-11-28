package com.bubudeai.entity;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@ApiOperation("技术分类实体")
@Data
@Component
public class Group {

    private Integer gid;

    private String gname;
    private LocalDateTime created;
    private String gcontent;
    private String gsvg;
}
