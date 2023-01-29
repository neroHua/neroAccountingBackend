package com.nero.hua.exception;

import com.nero.hua.enumeration.LoginEnumeration;

public class LoginException extends BusinessException {

    public LoginException(LoginEnumeration loginEnumeration) {
        super(loginEnumeration.getCode(), loginEnumeration.getMessage());
    }

    public LoginException(String message, String code) {
        super(message, code);
    }

    public LoginException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
