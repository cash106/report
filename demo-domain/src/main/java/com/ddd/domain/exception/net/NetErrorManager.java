package com.ddd.domain.exception.net;


import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.strategy.*;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anzj
 * @date 2022/12/20 15:28
 */
public class NetErrorManager {

    private static List<NetErrorStrategy> strategyList = new ArrayList<>();

    static {
        strategyList.add(new BindErrorStrategy());
        strategyList.add(new ConnectErrorStrategy());
        strategyList.add(new SocketErrorStrategy());
        strategyList.add(new SocketTimeoutErrorStrategy());
    }

    public static boolean isReadTimeout(Throwable t){
        while (t!=null){
            if(t instanceof SocketTimeoutException){
                if(t.getMessage().contains(NetError.SOCKET_READ_TIMEOUT)){
                    return true;
                }
            }
            t = t.getCause();
        }
        return false;
    }

    public static Error parse(NetErrorContext context){
        Error error =null;
        Throwable t = context.getThrowable();

        boolean done=false;

        while(t != null){

            for(NetErrorStrategy strategy : strategyList){
                if(strategy.accept(t)){
                    error = strategy.parseNetError(context);
                    done=true;
                    break;
                }
            }
            if(done)break;
            t = t.getCause();
        }
        return error;
    }

}
