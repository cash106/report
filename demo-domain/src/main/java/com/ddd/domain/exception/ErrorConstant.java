package com.ddd.domain.exception;

/**
 * @author anzj
 * @date 2022/12/19 17:59
 */
public abstract class ErrorConstant {

    public static final Error SUCCEED_TRADE = new Error("0000","交易成功","交易成功");
    public static final Error ERR_VALIDATION_PARAMETER = new Error("1000","输入参数校验不通过:[{}]","输入参数校验不通过:[{}]");
    public static final Error ERR_RULE_EMAIL = new Error("2000","邮箱不存在","邮箱不存在");
    public static final Error ERR_DATA_NOT_FOUND = new Error("4000","库中不存在","库中不存在");
    public static final Error ERR_DOMAIN_SERVICE = new Error("3000","领域服务异常","领域服务异常");
    public static final Error ERR_TRANSACTION = new Error("5000","事务处理异常","事务处理异常");
    public static final Error ERR_REMOTE_UNKNOWN = new Error("6000","第三方调用结果未知","第三方调用结果未知");
    public static final Error ERR_UNHANDLE = new Error("7000","未处理的异常","未处理的异常");
}
