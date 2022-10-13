package com.lin.xiaoyaoshai.controller;

import com.lin.xiaoyaoshai.config.CodeMsg;
import com.lin.xiaoyaoshai.config.Result;
import com.lin.xiaoyaoshai.service.MatchService;
import com.lin.xiaoyaoshai.vo.DisRelationInfoVO;
import com.lin.xiaoyaoshai.vo.MatchInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatchController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MatchService matchService;

    /**
     * 匹配对手
     * @param mail
     * @return
     */
    @GetMapping("/matchRival/{mail}")
    public Result<MatchInfoVO> matchRival(@PathVariable String mail) {
        logger.info(mail);
        MatchInfoVO VO = new MatchInfoVO();
        VO = matchService.matchRival(mail);
        logger.info("saas"+VO.getRivalId());

        String rivalId = VO.getRivalId();

        logger.info(rivalId);
        if(rivalId == null || rivalId.length() == 0){
            return Result.error(CodeMsg.MATCH_WAIT);
        }
        return Result.success(matchService.matchRival(mail));
    }

    /**
     * 解除关系
     * @param VO
     * @return
     */
    @PostMapping("disRelation")
    public Result<String> disRelation(@RequestBody DisRelationInfoVO VO) {
        int result = matchService.disRelation(VO);
        if(result == 1){
            return Result.success("成功解除关系");
        }
        else
            return Result.error(CodeMsg.DIS_ERROR);
    }
}
