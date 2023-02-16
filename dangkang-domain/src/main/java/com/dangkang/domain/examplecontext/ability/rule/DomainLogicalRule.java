package com.dangkang.domain.examplecontext.ability.rule;

import com.dangkang.domain.examplecontext.model.DomainObject;

/**
 *
 * Rule规则类可以定义为接口也可以定义为类，1、当定义为接口时在app模块相同包目录下实现它
 * 2、校验不符合业务规则时抛出异常在applicationService层进行捕获处理
 */
public interface DomainLogicalRule {

    String ERR_DOMAINLOGICRULE_CODE="V002";
    String ERR_DOMAINLOGICRULE_MESSAGE="领域规则校验出错提示";
    void check(DomainObject domainObject);

}
