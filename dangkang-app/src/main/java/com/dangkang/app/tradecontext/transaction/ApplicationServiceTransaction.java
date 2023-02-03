package com.dangkang.app.tradecontext.transaction;

import com.dangkang.domain.tradecontext.model.DomainObject;
import com.dangkang.domain.tradecontext.ability.facade.ExternalAccessFacade;
import com.dangkang.domain.tradecontext.repository.DomainObjectRepository;
import com.dangkang.infrastructure.tradecontext.converter.DomainObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
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
        domainObjectRepository.update(domainObject);

        //1.2 第三方服务调用
        externalAccessFacade.call(DomainObjectConverter.INSTANCE.toCallRequestDto(domainObject));

    }

}
