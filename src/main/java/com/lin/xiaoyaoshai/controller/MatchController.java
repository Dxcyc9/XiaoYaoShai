package com.lin.xiaoyaoshai.controller;

import com.lin.xiaoyaoshai.config.CodeMsg;
import com.lin.xiaoyaoshai.config.Result;
import com.lin.xiaoyaoshai.service.MatchService;
import com.lin.xiaoyaoshai.vo.MatchInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MatchService matchService;

    @GetMapping("/matchRival/{mail}")
    public Result<MatchInfo> matchRival(@PathVariable String mail) {
        MatchInfo matchInfo = matchService.matchRival(mail);
        System.out.println(matchInfo);
        if(matchInfo.getUserId1() == null) {
            return Result.error(CodeMsg.MATCH_WAIT);
        }
        else {

            return Result.success(matchInfo);
        }
    }
}
