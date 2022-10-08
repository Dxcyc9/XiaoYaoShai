package com.lin.xiaoyaoshai.service;

import com.lin.xiaoyaoshai.config.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 生成要发送的邮件
     *
     * @param userMail
     * @return
     */

    public SimpleMailMessage generateMailByExamId(String userMail) {
        //获取信息
        //生成验证码
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        String code = flag.toString();


        //邮件设置
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("【逍遥骰】");
        message.setText("尊敬的用户，您的验证码为" + code +",本验证码5分钟内有效，感谢您使用。");
        message.setTo(userMail);
        message.setFrom(mailFrom);

        //将邮箱内容存入缓存并设置过期时间
        redisUtil.set(userMail,code);
        redisUtil.expire(userMail,300);
        System.out.println(redisUtil.getExpire(userMail));
        return message;
    }

    /**
     * 发送邮件
     *
     * @param message
     */
    public void sendOut(SimpleMailMessage message) {
        System.out.println(message);
        mailSender.send(message);
    }
}
