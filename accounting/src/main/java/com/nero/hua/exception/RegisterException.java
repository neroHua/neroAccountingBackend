package com.nero.hua.exception;

import com.nero.hua.enumeration.RegisterEnumeration;

public class RegisterException extends BusinessException {

    public RegisterException(RegisterEnumeration registerEnumeration) {
        super(registerEnumeration.getCode(), registerEnumeration.getMessage());
    }

    public RegisterException(String message, String code) {
        super(message, code);
    }

    public RegisterException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
