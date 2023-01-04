package com.dangkang.domain.model.trade.repository;

import com.dangkang.domain.model.trade.DomainObject;

/**
 * @date 2022/12/23 10:23
 */
public interface DomainObjectRepository {

    String ERR_DOMAINOBJECT_NOT_FOUND_CODE="R001";
    String ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE="未查询到领域对象";

    DomainObject findAndCheckEmpty(String email);

    void save(DomainObject domainObject);
    void update(DomainObject domainObject);
}
