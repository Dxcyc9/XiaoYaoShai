package com.lin.xiaoyaoshai.service;

import com.lin.xiaoyaoshai.vo.DisRelationInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MatchService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //记录用户id数组
    ArrayList<String> mailList = new ArrayList<>();

    Map<String,String> rivalInfo = new HashMap<>();


    /**
     * 匹配对手
     * @param mail
     * @return
     */
    public String matchRival(String mail) {
        System.out.println(mailList);
        //logger.info(mail);

        if(rivalInfo.get(mail) != null) {
            //logger.info(rivalInfo.get(mail));
            return rivalInfo.get(mail);
        }
        mailList.add(mail);
        System.out.println(mailList.size());
        if(mailList.size() == 2) {
            rivalInfo.put(mailList.get(0),mailList.get(1));
            rivalInfo.put(mailList.get(1),mailList.get(0));
            mailList.clear();
        }
//        System.out.println(mailList.get(0));
//        System.out.println(mailList.get(1));
        System.out.println(rivalInfo);
        return "正在匹配";
    }

    /**
     * 解除关系
     * @param VO
     * @return
     */
    public int disRelation(DisRelationInfoVO VO) {
        try{
            String userId1 = VO.getUserId1();
            String userId2 = VO.getUserId2();
            rivalInfo.remove(userId1);
            rivalInfo.remove(userId2);
            return 1;
        }
        catch (Exception e) {
            return 0;
        }

    }
}
