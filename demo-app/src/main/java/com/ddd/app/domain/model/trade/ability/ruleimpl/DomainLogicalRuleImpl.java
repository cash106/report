package com.ddd.app.domain.model.trade.ability.ruleimpl;

import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.model.trade.DomainObject;
import com.ddd.domain.model.trade.ability.rule.DomainLogicalRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 业务领域规则对象:复杂业务规则的封装
 * @author anzj
 * @date 2022/12/23 13:53
 */
public class DomainLogicalRuleImpl implements DomainLogicalRule {

    private static final Logger logger = LoggerFactory.getLogger(DomainLogicalRuleImpl.class);


    /**
     *
     * 业务规则校验异常示例
     */
    @Override
    public void check(DomainObject domainObject) {

        //todo 领域校验逻辑执行
        logger.info("领域校验逻辑执行");
        //业务规则校验示例 实际业务规则应是有关多个领域对象的属性或复杂规则验证
        if("domainrule@email.com".equals(domainObject.getEmail())){
            throw BizException.buildBizException(ErrorConstant.ERR_EMAIL);
        }

    }

}
