package com.nero.hua.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountingDO {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private Long userId;

    private Date billCreateTime;

    private Double billMoney;

    private String description;

    private String reviewDescription;

    private Boolean valuable;

}