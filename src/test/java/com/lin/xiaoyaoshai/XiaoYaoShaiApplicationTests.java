package com.lin.xiaoyaoshai;

import com.lin.xiaoyaoshai.config.RedisUtil;
import com.lin.xiaoyaoshai.entity.User;
import com.lin.xiaoyaoshai.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;

@SpringBootTest
class XiaoYaoShaiApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//
//    @Autowired
//    private UserMapper userMapper;

//    @Test
//    void testInsert(){
//        int result = userMapper.insert(new User("228751565@qq.com","123456"));
//        System.out.println("result:" + result);
//    }
//    @Autowired(required = false)
//    private RedisUtil redisUtil;
//
//    @Test
//    void getName(){
//        redisUtil.set("2287511565@qq.com","5654");
//        redisUtil.expire("2287511565@qq.com",30);

//        System.out.println(redisUtil.get("2287511565@qq.com"));
//        System.out.println(redisUtil.getExpire("2287511565@qq.com"));

//            String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
//            Random rand = new Random();
//            StringBuffer flag = new StringBuffer();
//            for (int j = 0; j < 6; j++)
//            {
//                flag.append(sources.charAt(rand.nextInt(9)) + "");
//            }
//            System.out.println(flag.toString());


 //   }

}
