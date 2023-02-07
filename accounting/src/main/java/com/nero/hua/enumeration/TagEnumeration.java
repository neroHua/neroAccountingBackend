package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum TagEnumeration {

    TAG_IN_USE_CAN_NOT_BE_DELETED("tagInUseCanNotBeDeleted", "标签正在使用不能被删除");

    private String code;
    private String message;

    TagEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
