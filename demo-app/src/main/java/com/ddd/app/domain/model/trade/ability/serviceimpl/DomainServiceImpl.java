package com.ddd.app.domain.model.trade.ability.serviceimpl;

import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.model.trade.DomainObject;
import com.ddd.domain.model.trade.ability.domainService.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 领域服务实现逻辑
 * @author anzj
 * @date 2022/12/23 11:29
 */
public class DomainServiceImpl implements DomainService {

    private static final Logger logger = LoggerFactory.getLogger(DomainServiceImpl.class);

    @Override
    public void doService(DomainObject domainObject) {
        //todo 封装多个领域对象协作并具有一定重用性的功能，可能会在多个applicationService之间重用。
        domainObject.toDo();
        logger.info("DomainObject.toDo领域逻辑执行成功");
        //领域服务抛出异常示例
        if("domainService@email.com".equals(domainObject.getEmail())){
            throw BizException.buildBizException(ErrorConstant.ERR_DOMAIN_SERVICE);
        }
        logger.info("DomainServiceImpl.doService领域服务执行成功");
    }
}
