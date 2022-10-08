package com.lin.xiaoyaoshai.service;

import com.lin.xiaoyaoshai.config.RedisUtil;
import com.lin.xiaoyaoshai.entity.User;
import com.lin.xiaoyaoshai.mapper.UserMapper;
import com.lin.xiaoyaoshai.vo.LoginVO;
import com.lin.xiaoyaoshai.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    MailService mailService;

    @Autowired
    RedisUtil redisUtil;
    /**
     * 登陆
     * @param loginVO
     * @return
     */
    public int login(LoginVO loginVO){
        User getUser;
        try {
            getUser = userMapper.selectById(loginVO.getId());
            logger.info(getUser.getId());
            if (getUser.getId().equals(loginVO.getId())) {
                logger.info("存在此邮箱");
                if (getUser.getPassword().equals(loginVO.getPassword())) {
                    logger.info("密码正确");
                    return 1;
                }
                else {
                    logger.info("密码错误");
                    return 0;
                }
            }
        }
        catch (Exception e){
            logger.info("不存在此邮箱");
            return 0;
        }
        return 0;
    }

    /**
     * 发送验证码
     * @param userMail
     * @return
     */
    public int sendCode(String userMail){
        try{
            SimpleMailMessage message = mailService.generateMailByExamId(userMail);
            mailService.sendOut(message);
            return 1;
        }
        catch (Exception e){
            logger.info("发送失败");
            return 0;
        }
    }

    /**
     * 注册
     * @param VO
     * @return
     */
    public int register(RegisterVO VO) {
        String mail = VO.getId();
        String code = VO.getCode();
        String codeInRedis = (String) redisUtil.get(mail);
        if(code.equals(codeInRedis)) {
            return 1;
        }
        return 0;
    }
}
