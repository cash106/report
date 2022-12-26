package com.ddd.domain.exception.net.strategy;

import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.NetError;
import com.ddd.domain.exception.net.NetErrorContext;

import java.net.SocketException;

/**
 * @author anzj
 * @date 2022/12/20 15:41
 */
public class SocketErrorStrategy implements NetErrorStrategy{
    @Override
    public Error parseNetError(NetErrorContext context) {
        Error error = NetError.ERR_REMOTE_ERROR;
        String message = context.getThrowable().getMessage();
        if(message.contains(NetError.SOCKET_CLOSED)){
            error = NetError.ERR_REMOTE_SOCKET_CLOSED.buildErrorMessageForOperator(context.getUrl());
        }else if(message.contains(NetError.CONNECTION_RESET)){
            error = NetError.ERR_REMOTE_CONNECTION_RESET.buildErrorMessageForOperator(context.getUrl());
        }else if(message.contains(NetError.BROKEN_PIPE)){
            error = NetError.ERR_REMOTE_PIPE_BROKEN.buildErrorMessageForOperator(context.getUrl());
        }
        return error;
    }

    @Override
    public boolean accept(Throwable t) {
        if(t instanceof SocketException){
            return true;
        }
        return false;
    }
}
