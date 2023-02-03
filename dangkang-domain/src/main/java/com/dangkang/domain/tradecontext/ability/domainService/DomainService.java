package com.dangkang.domain.tradecontext.ability.domainService;

import com.dangkang.domain.tradecontext.model.DomainObject;

/**
 * 领域服务定义：1、负责applicationService中某一个主逻辑步骤的具体实现
 */
public interface DomainService {

    String ERR_DOMAIN_SERVICE_CODE="S001";
    String ERR_DOMAIN_SERVICE_MESSAGE="领域服务出错提示";

    void doService(DomainObject domainObject);

    DomainObject findAndCheckEmpty(String phoneNumber);
}
