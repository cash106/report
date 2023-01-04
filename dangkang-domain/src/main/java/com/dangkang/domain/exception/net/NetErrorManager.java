package com.dangkang.domain.exception.net;


import com.dangkang.domain.exception.net.strategy.*;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anzj
 * @date 2022/12/20 15:28
 */
public class NetErrorManager {



    public static final String ERR_NETWORK_CODE="N001";
    /*网络异常消息*/
    public static final String SOCKET_READ_TIMEOUT = "Read timed out";
    public static final String SOCKET_CONNECTION_TIMEOUT = "connect timed out";
    public static final String CONNECTION_TIMEOUT = "Connection timed out";
    public static final String SOCKET_MESSAGE_PORT_IN_USE = "Address already in use";
    public static final String CONNECTION_REFUSED = "Connection refused";
    public static final String SOCKET_CLOSED = "Socket is closed";
    public static final String CONNECTION_RESET = "Connection reset";
    public static final String BROKEN_PIPE = "Broken pipe";


    public static final NetError ERR_NETWORK = new NetError("N000","网络错误");
    public static final NetError ERR_SOCKET_READ_TIMEOUT = new NetError("N001","本机[%s]远程连接到URL[%s]后读取超时,设定超时时间为[%s]ms");
    public static final NetError ERR_CONNECTION_TIMEOUT = new NetError("N002","本机[%s]远程连接到RUL[%s]超时,设定超时时间为[%s]ms");
    public static final NetError ERR_SOCKET_CLOSED = new NetError("N003","本机[%s]连接客户端地址[%s]被关闭，检查服务端代码中是否主动关闭了连接(显式或隐式的调用了socket.closed())");
    public static final NetError ERR_CONNECTION_REFUSED = new NetError("N004","本机[%s]连接远程地址[%s]被拒绝,请检查远程地址中ip、端口是否正确或网络是否连通");
    public static final NetError ERR_CONNECTION_RESET = new NetError("N005","本机[%s]与远程地址[%s]关闭了连接，读写仍然进行。请排查1、服务器是否连接过多；2、客户端是否关闭了连接；3、防火墙是否打开");
    public static final NetError ERR_PIPE_BROKEN = new NetError("N006","本机[%s]与服务端地址[%s]未正常关闭连接");
    public static final NetError ERR_TOO_MANY_SOCKET = new NetError("N007","本机[%s]网络连接过多,请检查打开的文件句柄是否超过最大值");
    public static final NetError ERR_SSL_PEER_SHUTDOWN = new NetError("N008","本机[%s]文件错误关闭");
    public static final NetError ERR_PORT_ALREADY_BIND = new NetError("N009","本机[%s]端口被占用");

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
                if(t.getMessage().contains(SOCKET_READ_TIMEOUT)){
                    return true;
                }
            }
            t = t.getCause();
        }
        return false;
    }

    public static String parse(NetErrorContext context){
        NetError error = ERR_NETWORK;
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
        return error.getErrorMessage();
    }

}
