package com.lin.xiaoyaoshai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.xiaoyaoshai.mapper")
public class XiaoYaoShaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoYaoShaiApplication.class, args);
    }

}
