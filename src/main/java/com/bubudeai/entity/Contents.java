package com.bubudeai.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Component
@Data
public class Contents {
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
    /**
     *图片
     */
    private String titlePic;
    /**
     *文章内容主体
     */
    private String content;
    /**
     *作者
     */
    private String tauthor;
    /**
     *创建时间
     */
    private Date created;
    /**
     *最后修改时间
     */
    private Date lastchange;
    /**
     *属组id
     */
    private Integer gid;
}
