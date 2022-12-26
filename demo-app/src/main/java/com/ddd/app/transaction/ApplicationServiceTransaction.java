package com.ddd.app.transaction;

import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.model.trade.DomainObject;
import com.ddd.domain.model.trade.ability.facade.ExternalAccessFacade;
import com.ddd.domain.model.trade.repository.DomainObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anzj
 * @date 2022/12/19 14:14
 */
@Component
public class ApplicationServiceTransaction {

    @Autowired
    private ExternalAccessFacade externalAccessFacade;
    @Autowired
    private DomainObjectRepository domainObjectRepository;

    /**
     * 如果第三方externalAccessFacade抛出BizException(RuntimeException)则如下数据存储操作回滚
     * @param domainObject
     */
    @Transactional
    public void transaction(DomainObject domainObject){
        //todo 有事务的业务逻辑
        //1.1 带事务的存储服务
        domainObjectRepository.save(domainObject);

        //1.2 第三方服务调用
        externalAccessFacade.toCall();

    }
}
