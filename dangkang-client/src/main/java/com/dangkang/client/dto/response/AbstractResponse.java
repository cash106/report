package com.dangkang.client.dto.response;

import com.dangkang.domain.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义applicationService的返回结果
 * 所有applicationService返回结果DTO的父类
 */
public class AbstractResponse {

    private static final Logger logger = LoggerFactory.getLogger(AbstractResponse.class);

    public static final String SYSTEM_CODE="A01";
    public static final String SYSTEM_NAME ="dangkang";

    public static final String ERROR_CODE_UNHANDLE_EXCEPTION ="U001";//为所有交易未处理的异常定义的错误码

    /**
     * 返回码：
     * 1、成功返回码=系统编码+服务编码+服务执行成功返回码(所有服务执行成功返回码默认为“0000”)
     * 2、失败返回码=系统编码+服务编码+服务执行错误返回码(由服务执行过程中的错误码产生)
     */
    public String resultCode;
    public static final String EXECUTE_SUCCESS_CODE = "0000";//所有服务执行成功时的返回码
    /**
     * 返回消息：
     * 1、成功返回消息=系统描述+服务描述+服务执行成功描述(所有服务执行成功返回码默认为“交易成功”)
     * 2、错误返回消息=系统描述+服务描述+服务执行具体错误描述(由服务过程中的错误消息产生)
     */
    public String resultDescription ;
    public static final String EXECUTE_SUCCESS_MESSAGE = "交易成功";//所有服务执行成功时的返回消息
    /**
     * 返回类型 s-成功 f-失败
     */
    public String resultType;
    public static final String RESULT_TYPE_SUCCESS="S";
    public static final String RESULT_TYPE_FAILURE="F";


    public AbstractResponse buildSuccess(String serviceCode, String serviceDescription){
        this.resultType=RESULT_TYPE_SUCCESS;
        this.resultCode=new StringBuffer().append(SYSTEM_CODE)
                                          .append(serviceCode)
                                          .append(EXECUTE_SUCCESS_CODE)
                                          .toString();
        this.resultDescription=new StringBuffer().append(SYSTEM_NAME)
                                                 .append(serviceDescription)
                                                 .append(EXECUTE_SUCCESS_MESSAGE)
                                                 .toString();
        return this;
    }

    public AbstractResponse buildFailure(String serviceCode, String serviceDescription, String errorCode, String errorMessage){


        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode=new StringBuffer().append(SYSTEM_CODE)
                                          .append(serviceCode)
                                          .append(errorCode)
                                          .toString();
        this.resultDescription=new StringBuffer().append(SYSTEM_NAME)
                                          .append(serviceDescription)
                                          .append(errorMessage)
                                          .toString();
        return this;
    }

    public AbstractResponse buildFailure(String serviceCode, String serviceDescription, ApplicationException e){

        if(e.getCause()!=null){//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
            logger.error(e.getDetailMessage(),e); //系统环境出错
        }else{
            logger.warn(e.getDetailMessage());//业务异常warn
        }

        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode=new StringBuffer().append(SYSTEM_CODE)
                                          .append(serviceCode)
                                          .append(e.getErrorCode())
                                          .toString();
        this.resultDescription=new StringBuffer().append(SYSTEM_NAME)
                                                 .append(serviceDescription)
                                                 .append(e.getPromptMessage())
                                                 .toString();
        return this;
    }

    public AbstractResponse buildUnknownFailure(String serviceCode, String serviceDescription, String errorMessage){
        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode=new StringBuffer().append(SYSTEM_CODE)
                                          .append(serviceCode)
                                          .append(ERROR_CODE_UNHANDLE_EXCEPTION)
                                          .toString();
        this.resultDescription=new StringBuffer().append(SYSTEM_NAME)
                                                 .append(serviceDescription)
                                                 .append(errorMessage)
                                                 .toString();
        return this;
    }

    public AbstractResponse buildUnknownFailure(String serviceCode, String serviceDescription, Throwable e){
        logger.error("未处理的异常",e);
        this.resultType=RESULT_TYPE_FAILURE;
        this.resultCode=new StringBuffer().append(SYSTEM_CODE)
                                          .append(serviceCode)
                                          .append(ERROR_CODE_UNHANDLE_EXCEPTION)
                                          .toString();
        this.resultDescription=new StringBuffer().append(SYSTEM_NAME)
                                          .append(serviceDescription)
                                          .append(e.getMessage())
                                          .toString();
        return this;
    }

    public String getResultType() {
        return resultType;
    }

    public AbstractResponse setResultType(String resultType) {
        this.resultType = resultType;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public AbstractResponse setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public AbstractResponse setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }
}
