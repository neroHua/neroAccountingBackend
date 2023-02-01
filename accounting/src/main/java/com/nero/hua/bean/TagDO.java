package com.nero.hua.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TagDO {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private String code;

    private String name;

    private String description;

    private Long parentId;
}