package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum SystemExceptionEnumeration {

    EXCEPTION("系统异常", "系统异常"),
    THROWABLE("系统错误", "系统错误");

    private String code;
    private String message;

    SystemExceptionEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
