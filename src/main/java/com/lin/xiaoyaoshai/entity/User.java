package com.lin.xiaoyaoshai.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String id;

    private String password;

    private String name;
}
