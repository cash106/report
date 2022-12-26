package com.ddd.domain.exception.net.strategy;

import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.NetError;
import com.ddd.domain.exception.net.NetErrorContext;
import java.net.ConnectException;

/**
 * @author anzj
 * @date 2022/12/20 15:42
 */
public class ConnectErrorStrategy implements NetErrorStrategy {
    @Override
    public Error parseNetError(NetErrorContext context) {
        Error error = NetError.ERR_REMOTE_ERROR;
        String message = context.getThrowable().getMessage();

        if(message.contains(NetError.CONNECTION_REFUSED)){
            error = NetError.ERR_REMOTE_CONNECTION_REFUSED.buildErrorMessageForOperator(context.getUrl());
        }else if(message.contains(NetError.CONNECTION_TIMEOUT)){
            error = NetError.ERR_REMOTE_CONNECTION_TIMEOUT.buildErrorMessageForOperator(context.getUrl(),String.valueOf(context.getConnectTimeout()));
        }

        return error;
    }

    @Override
    public boolean accept(Throwable t) {
        if(t instanceof ConnectException){
            return true;
        }
        return false;
    }
}
