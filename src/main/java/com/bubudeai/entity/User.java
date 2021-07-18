package com.bubudeai.entity;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ApiOperation("用户实体类")
@Data
@Component
public class User implements Serializable {
    private int uid;
    private String username;
    private String password;

}
