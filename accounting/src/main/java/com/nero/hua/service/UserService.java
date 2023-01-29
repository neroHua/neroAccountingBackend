package com.nero.hua.service;

import com.nero.hua.model.user.LoginRequest;
import com.nero.hua.model.user.RegisterRequest;
import com.nero.hua.model.user.UserInformationResponse;

public interface UserService {

    Boolean register(RegisterRequest registerRequest);

    String login(LoginRequest loginRequest);

    UserInformationResponse getUserInformation(String userId);
}
