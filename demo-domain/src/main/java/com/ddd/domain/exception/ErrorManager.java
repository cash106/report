package com.ddd.domain.exception;

import com.ddd.domain.exception.net.strategy.BindErrorStrategy;
import com.ddd.domain.exception.net.strategy.NetErrorStrategy;

/**
 * @author anzj
 * @date 2022/12/19 18:06
 */
public class ErrorManager {

    /**
     * 构建错误码
     */
    public static String buildErrorCode(String sysCode,String tradeCode,String errorCode){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(sysCode).append(tradeCode).append(errorCode).toString();
    }

    /**
     * 构建错误消息
     */
    public static String buildErrorMessage(String sysMessage,String tradeMessage,String errorMessage){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(sysMessage).append(tradeMessage).append(errorMessage).toString();
    }

}
