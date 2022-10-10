package com.lin.xiaoyaoshai.controller;

import com.lin.xiaoyaoshai.config.CodeMsg;
import com.lin.xiaoyaoshai.config.Result;
import com.lin.xiaoyaoshai.mapper.UserMapper;
import com.lin.xiaoyaoshai.service.UserService;
import com.lin.xiaoyaoshai.vo.GetCodeVO;
import com.lin.xiaoyaoshai.vo.LoginVO;
import com.lin.xiaoyaoshai.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 登陆接口
     * @param loginVO
     * @return
     */
    @PostMapping("/user/login")
    Result<Map<String,String>> userLogin(@RequestBody LoginVO loginVO){
        if(userService.login(loginVO) == 1)
            return Result.success(userService.getName(loginVO.getId()));
        else
            return Result.error(CodeMsg.LOGIN_FAIL);
    }

    /**
     * 发送验证码接口
     * @param VO
     * @return
     */
    @PostMapping("/user/getCode")
    Result<String> getCode(@RequestBody GetCodeVO VO) {
        if(userService.sendCode(VO.getId()) == 1)
            return Result.success("发送成功");
        else
            return Result.error(CodeMsg.SEND_CODE_FAIL);
    }

    @PostMapping("/user/register")
    Result<String> userRegister(@RequestBody RegisterVO VO) {
        if(userService.register(VO) == 1)
            return Result.success("注册成功");
        else
            return Result.error(CodeMsg.REGISTER_FAIL);
    }

}
