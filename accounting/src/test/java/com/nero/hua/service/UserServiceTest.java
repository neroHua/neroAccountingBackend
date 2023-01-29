package com.nero.hua.service;

import com.nero.hua.model.user.RegisterRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserId("testCase001");
        registerRequest.setPassword("abc123");
        registerRequest.setNickName("nickName");
        Boolean result = userService.register(registerRequest);
        Assert.assertTrue("注册失败", result);
    }

    @Test
    public void testLogin() {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUserId("testUser001");
//        loginRequest.setPassword("abc123");
//        Boolean login = userService.login(loginRequest);
//        Assert.isTrue(login, "用户1应该登录成功");
    }

}
