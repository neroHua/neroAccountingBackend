package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum LoginEnumeration {

    USER_NOT_FOUND("userNotFound", "找不到用户"),
    PASSWORD_NOT_RIGHT("passwordNotRight", "密码不正确"),
    NEED_LOGIN("needLogin", "需要登录"),
    TOKEN_EXPIRE("tokenExpire", "令牌过期");

    private String code;
    private String message;

    LoginEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
