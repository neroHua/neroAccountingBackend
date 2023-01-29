package com.nero.hua.convert;

import com.nero.hua.bean.UserDO;
import com.nero.hua.model.user.RegisterRequest;
import com.nero.hua.model.user.UserInformationResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserConvert {

    public static UserDO convertRequestToDO(RegisterRequest registerRequest) {
        UserDO userDO = new UserDO();

        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());
        userDO.setCreateUserId(0L);
        userDO.setUpdateUserId(0L);

        userDO.setUserId(registerRequest.getUserId());
        userDO.setPassword(registerRequest.getPassword());
        userDO.setNickName(registerRequest.getNickName());

        return userDO;
    }

    public static UserInformationResponse convertDOToResponse(UserDO userDO) {
        UserInformationResponse userInformationResponse = new UserInformationResponse();

        userInformationResponse.setUserId(userDO.getUserId());
        userInformationResponse.setNickName(userDO.getNickName());

        return userInformationResponse;
    }

}
