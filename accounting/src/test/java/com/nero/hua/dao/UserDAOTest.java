package com.nero.hua.dao;

import com.nero.hua.bean.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testInsertUser() {
        UserDO userDO = new UserDO();

        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());
        userDO.setCreateUserId(0L);
        userDO.setUpdateUserId(0L);

        userDO.setUserId("testCase001");
        userDO.setPassword("abc123");
        userDO.setNickName("nickName");
        Long aLong = userDAO.insertUser(userDO);
        Assert.assertTrue("插入用户应该成功", aLong > 0);
    }

    @Test
    public void testSelectByUserId() {
        UserDO userDO = userDAO.selectByUserId("admin");
        Assert.assertNotNull( "应该找到admin用户", userDO);
    }

}
