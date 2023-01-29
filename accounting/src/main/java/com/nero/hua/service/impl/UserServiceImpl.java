package com.nero.hua.service.impl;

import com.nero.hua.bean.UserDO;
import com.nero.hua.convert.UserConvert;
import com.nero.hua.dao.UserDAO;
import com.nero.hua.enumeration.LoginEnumeration;
import com.nero.hua.enumeration.RegisterEnumeration;
import com.nero.hua.exception.LoginException;
import com.nero.hua.exception.RegisterException;
import com.nero.hua.model.user.LoginRequest;
import com.nero.hua.model.user.RegisterRequest;
import com.nero.hua.model.user.UserInformationResponse;
import com.nero.hua.service.UserService;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        UserDO userDOExist = userDAO.selectByUserId(registerRequest.getUserId());
        if (null != userDOExist) {
            throw new RegisterException(RegisterEnumeration.DUPLICATED_USER_ID);
        }

        UserDO userDO = UserConvert.convertRequestToDO(registerRequest);
        userDAO.insertUser(userDO);

        return Boolean.TRUE;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        UserDO userDO = userDAO.selectByUserId(loginRequest.getUserId());

        if (null == userDO) {
            throw new LoginException(LoginEnumeration.USER_NOT_FOUND);
        }

        if (!userDO.getPassword().equals(loginRequest.getPassword())) {
            throw new LoginException(LoginEnumeration.PASSWORD_NOT_RIGHT);
        }

        return LoginUtil.createToken(UserConvert.convertDOToResponse(userDO));
    }

    @Override
    public UserInformationResponse getUserInformation(String userId) {
        UserDO userDO = userDAO.selectByUserId(userId);
        if (null == userDO) {
            throw new LoginException(LoginEnumeration.USER_NOT_FOUND);
        }

        return UserConvert.convertDOToResponse(userDO);
    }

}
