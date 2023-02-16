package com.dangkang.domain.examplecontext.repository;

import com.dangkang.domain.examplecontext.model.DomainObject;

import java.util.Map;

/**
 * @date 2022/12/23 10:23
 */
public interface DomainObjectRepository {

    String ERR_DOMAINOBJECT_NOT_FOUND_CODE="R001";
    String ERR_DOMAINOBJECT_NOT_FOUND_MESSAGE="未查询到领域对象";

    DomainObject findAndCheckEmpty(String phoneNumber);

    void save(DomainObject domainObject);

    void update(DomainObject domainObject);

    /**
     * 获取分页信息
     */
    Map<String,Object> findPage(int index, int size, String email);

}
