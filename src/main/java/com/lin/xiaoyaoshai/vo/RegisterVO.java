package com.lin.xiaoyaoshai.vo;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class RegisterVO {
    @Email(message = "邮箱格式错误")
    private String id;

    /**
     * 验证码
     */
    private String code;
}
