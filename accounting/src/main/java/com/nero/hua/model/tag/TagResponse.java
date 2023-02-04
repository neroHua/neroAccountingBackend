package com.nero.hua.model.tag;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TagResponse {

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
