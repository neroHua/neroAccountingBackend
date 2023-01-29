package com.nero.hua.handler;

import com.nero.hua.enumeration.SystemExceptionEnumeration;
import com.nero.hua.exception.BusinessException;
import com.nero.hua.model.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.nero.hua")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BaseResponse<Object> handlerBusinessException(BusinessException businessException) {
        log.error("", businessException);
        return new BaseResponse<Object>(businessException.getCode(), businessException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse<Object> handlerException(Exception exception) {
        log.error("", exception);
        return new BaseResponse<Object>(SystemExceptionEnumeration.EXCEPTION.getCode(), SystemExceptionEnumeration.EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public BaseResponse<Object> handlerThrowable(Throwable throwable) {
        log.error("", throwable);
        return new BaseResponse<Object>(SystemExceptionEnumeration.THROWABLE.getCode(), SystemExceptionEnumeration.THROWABLE.getMessage());
    }

}
