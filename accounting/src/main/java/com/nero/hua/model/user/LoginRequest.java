package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class LoginRequest {

    @NotNull(message = "账号不能为空")
    @NotBlank(message = "账号不能为空")
    @Length(max = 12, message = "账号字长不能超过12")
    private String userId;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    @Length(max = 12, message = "密码字长不能超过12")
    private String password;
}
