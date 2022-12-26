package com.ddd.domain.exception.net.strategy;

import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.NetError;
import com.ddd.domain.exception.net.NetErrorContext;

import java.net.SocketTimeoutException;

/**
 * @author anzj
 * @date 2022/12/20 15:42
 */
public class SocketTimeoutErrorStrategy implements NetErrorStrategy {
    @Override
    public Error parseNetError(NetErrorContext context) {
        Error error = NetError.ERR_REMOTE_ERROR;
        String message = context.getThrowable().getMessage();

        if(message.contains(NetError.SOCKET_READ_TIMEOUT)){
            error = NetError.ERR_REMOTE_SOCKET_READ_TIMEOUT.buildErrorMessageForOperator(context.getUrl(),String.valueOf(context.getReadTimeout()));
        }else  if(message.contains(NetError.SOCKET_CONNECTION_TIMEOUT)){
            error = NetError.ERR_REMOTE_CONNECTION_TIMEOUT.buildErrorMessageForOperator(context.getUrl(),String.valueOf(context.getConnectTimeout()));
        }
        return error;
    }

    @Override
    public boolean accept(Throwable t) {
        if(t instanceof SocketTimeoutException){
            return true;
        }
        return false;
    }
}
