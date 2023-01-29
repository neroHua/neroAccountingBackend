package com.nero.hua.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse <T> {

    public Boolean success;

    public String errorCode;

    public String errorMessage;

    public T data;

    public BaseResponse(T data) {
        this.success = Boolean.TRUE;
        this.data = data;
    }

    public BaseResponse(String errorCode, String errorMessage) {
        this.success = Boolean.FALSE;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
