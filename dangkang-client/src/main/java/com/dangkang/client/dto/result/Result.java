package com.dangkang.client.dto.result;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 定义applicationService的返回结果
 * 所有applicationService返回结果DTO的父类
 */
public class Result {

    public static final String SYSTEM_CODE="dangkang";
    public static final String SYSTEM_DESCRIPTION="dangkang-ddd-template";

    public static final String APPLICATIONSERVICE_EXECUTE_ERROR_CODE_UNHANDLE_EXCEPTION="U001";//为所有交易未处理的异常定义的错误码

    /**
     * 返回码：
     * 1、成功返回码=系统编码+交易编码+交易执行成功返回码(所有交易执行成功返回码默认为“0000”)
     * 2、失败返回码=系统编码+交易编码+交易执行错误返回码(由交易执行过程中的错误码产生)
     */
    private StringBuffer resultCode = new StringBuffer();
    public static final String APPLICATIONSERVICE_EXECUTE_SUCCESS_CODE = "0000";//所有交易成功时的返回码
    /**
     * 返回消息：
     * 1、成功返回消息=系统描述+交易描述+交易执行成功描述(所有交易执行成功返回码默认为“交易成功”)
     * 2、错误返回消息=系统描述+交易描述+交易执行具体错误描述(由交易过程中的错误消息产生)
     */
    private StringBuffer resultDescription = new StringBuffer();
    public static final String APPLICATIONSERVICE_EXECUTE_SUCCESS_MESSAGE = "交易成功";
    /**
     * 返回类型 s-成功 f-失败
     */
    private String resultType;
    public static final String RESULT_TYPE_SUCCESS="S";
    public static final String RESULT_TYPE_FAILURE="F";


    public Result buildSuccess(String tradeCode,String tradeDescription){
        this.resultType=RESULT_TYPE_SUCCESS;
        this.resultCode.append(SYSTEM_CODE).append(tradeCode).append(APPLICATIONSERVICE_EXECUTE_SUCCESS_CODE);
        this.resultDescription.append(SYSTEM_DESCRIPTION).append(tradeDescription).append(APPLICATIONSERVICE_EXECUTE_SUCCESS_MESSAGE);
        return this;
    }

    public Result buildFailure(String tradeCode,String tradeDescription,String errorCode,String errorMessage){
        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode.append(SYSTEM_CODE)
                .append(tradeCode)
                .append(errorCode);
        this.resultDescription.append(SYSTEM_DESCRIPTION)
                .append(tradeDescription)
                .append(errorMessage);
        return this;
    }

    public Result buildUnknownFailure(String tradeCode,String tradeDescription,String errorMessage){
        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode.append(SYSTEM_CODE)
                .append(tradeCode)
                .append(APPLICATIONSERVICE_EXECUTE_ERROR_CODE_UNHANDLE_EXCEPTION);
        this.resultDescription.append(SYSTEM_DESCRIPTION)
                .append(tradeDescription)
                .append(errorMessage);
        return this;
    }

    public String getResultType() {
        return resultType;
    }

    public Result setResultType(String resultType) {
        this.resultType = resultType;
        return this;
    }

    public StringBuffer getResultCode() {
        return resultCode;
    }

    public Result setResultCode(StringBuffer resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public StringBuffer getResultDescription() {
        return resultDescription;
    }

    public Result setResultDescription(StringBuffer resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }
}
