package com.nero.hua.exception;

import com.nero.hua.enumeration.TagEnumeration;

public class TagException extends BusinessException {

    public TagException(TagEnumeration tagEnumeration) {
        super(tagEnumeration.getCode(), tagEnumeration.getMessage());
    }

    public TagException(String message, String code) {
        super(message, code);
    }

    public TagException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
