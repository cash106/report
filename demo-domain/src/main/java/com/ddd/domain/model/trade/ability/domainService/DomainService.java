package com.ddd.domain.model.trade.ability.domainService;

import com.ddd.domain.model.trade.DomainObject;

/**
 * 领域服务定义：1、负责applicationService中某一个主逻辑步骤的具体实现
 */
public interface DomainService {

    void doService(DomainObject domainObject);

}
