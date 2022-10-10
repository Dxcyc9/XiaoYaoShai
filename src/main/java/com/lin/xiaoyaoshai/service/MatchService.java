package com.lin.xiaoyaoshai.service;

import com.lin.xiaoyaoshai.vo.MatchInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MatchService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //记录用户id数组
    ArrayList<String> mailList = new ArrayList<>();



    public MatchInfo matchRival(String mail) {
        MatchInfo matchInfo = new MatchInfo();
        logger.info(mail);
        mailList.add(mail);
        if(mailList.size() < 2) {
            return matchInfo;
        }
        else if(mailList.size() == 2) {
            System.out.println(mailList);
            matchInfo.setUserId1(mailList.get(0));
            matchInfo.setUserId2(mailList.get(1).toString());
            mailList.clear();
            return matchInfo;
        }
        else
            return matchInfo;
    }
}
