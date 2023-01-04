package com.dangkang.domain.exception.net.strategy;

import com.dangkang.domain.exception.net.NetError;
import com.dangkang.domain.exception.net.NetErrorContext;
import com.dangkang.domain.exception.net.NetErrorManager;

import java.net.SocketException;

/**
 * @date 2022/12/20 15:41
 */
public class SocketErrorStrategy implements NetErrorStrategy{
    @Override
    public NetError parseNetError(NetErrorContext context) {
        NetError error = null;
        String message = context.getThrowable().getMessage();
        if(message.contains(NetErrorManager.SOCKET_CLOSED)){
            error = NetErrorManager.ERR_SOCKET_CLOSED.buildError(context.getLocalhost(),context.getRemoteIp());
        }else if(message.contains(NetErrorManager.CONNECTION_RESET)){
            error = NetErrorManager.ERR_CONNECTION_RESET.buildError(context.getLocalhost(),context.getRemoteIp());
        }else if(message.contains(NetErrorManager.BROKEN_PIPE)){
            error = NetErrorManager.ERR_PIPE_BROKEN.buildError(context.getLocalhost(),context.getRemoteIp());
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
