package com.nero.hua.dao;

import com.nero.hua.bean.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {

    UserDO selectByUserId(String userId);

    Long insertUser(@Param("userDO") UserDO userDO);
}
