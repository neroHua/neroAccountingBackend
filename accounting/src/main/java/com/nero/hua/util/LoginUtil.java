package com.nero.hua.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nero.hua.config.LoginConfig;
import com.nero.hua.enumeration.LoginEnumeration;
import com.nero.hua.exception.LoginException;
import com.nero.hua.model.user.UserInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class LoginUtil {

    private static String USER_ID = "userId";
    private static String NICK_NAME = "nickName";

    @Autowired
    private LoginConfig loginConfig;

    private static LoginConfig loginConfigStatic;

    @PostConstruct
    public void init() {
        loginConfigStatic = loginConfig;
    }

    public static String createToken(UserInformationResponse userInformationResponse) {
        Date issuedDate = new Date();
        Date expireDate = new Date(System.currentTimeMillis() + loginConfigStatic.getExpireMillSeconds());

        return JWT.create()
                .withIssuedAt(issuedDate)
                .withExpiresAt(expireDate)
                .withClaim(USER_ID, userInformationResponse.getUserId())
                .withAudience(NICK_NAME, userInformationResponse.getNickName())
                .sign(Algorithm.HMAC256(loginConfigStatic.getSecret()));
    }

    public static boolean verifyToken(String token) {
        if (null == token) {
            throw new LoginException(LoginEnumeration.NEED_LOGIN);
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(loginConfigStatic.getSecret())).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Date expiresAt = decodedJWT.getExpiresAt();
        if (System.currentTimeMillis() > expiresAt.getTime()) {
            throw new LoginException(LoginEnumeration.TOKEN_EXPIRE);
        }

        return Boolean.TRUE;
    }

    public static String parseUserIdFromHttpServletRequest(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(loginConfigStatic.getHeadTokenKey());
        return parseUserIdFromToken(token);
    }

    public static String parseUserIdFromToken(String token) {
        if (null == token) {
            throw new LoginException(LoginEnumeration.NEED_LOGIN);
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(loginConfigStatic.getSecret())).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Date expiresAt = decodedJWT.getExpiresAt();
        if (System.currentTimeMillis() > expiresAt.getTime()) {
            throw new LoginException(LoginEnumeration.TOKEN_EXPIRE);
        }

        return decodedJWT.getClaim(USER_ID).asString();
    }

}
