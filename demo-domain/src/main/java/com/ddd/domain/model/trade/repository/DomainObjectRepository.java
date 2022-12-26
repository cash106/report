package com.ddd.domain.model.trade.repository;

import com.ddd.domain.model.trade.DomainObject;

/**
 * @author anzj
 * @date 2022/12/23 10:23
 */
public interface DomainObjectRepository {

    DomainObject findAndCheckEmpty(String email);

    void save(DomainObject domainObject);
    void update(DomainObject domainObject);
}
