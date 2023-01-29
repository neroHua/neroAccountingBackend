package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum RegisterEnumeration {

    DUPLICATED_USER_ID("duplicatedUserId", "重复的账号");

    private String code;
    private String message;

    RegisterEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
