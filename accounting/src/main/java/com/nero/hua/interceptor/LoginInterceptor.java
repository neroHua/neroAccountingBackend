package com.nero.hua.interceptor;

import com.nero.hua.config.LoginConfig;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginConfig loginConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        if (loginConfig.exclude(requestURI)) {
            return Boolean.TRUE;
        }

        String httpMethod = request.getMethod();
        if (HttpMethod.OPTIONS.name().equals(httpMethod)) {
            return true;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(LoginSkip.class)) {
                return Boolean.TRUE;
            }
        }

        String token = request.getHeader(loginConfig.getHeadTokenKey());

        LoginUtil.verifyToken(token);

        return Boolean.TRUE;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @Documented
    public static @interface LoginSkip {
    }
}
