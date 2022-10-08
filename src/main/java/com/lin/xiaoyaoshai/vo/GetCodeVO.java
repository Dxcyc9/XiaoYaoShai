package com.lin.xiaoyaoshai.vo;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class GetCodeVO {

    @Email(message = "邮箱格式错误")
    private String id;
}
