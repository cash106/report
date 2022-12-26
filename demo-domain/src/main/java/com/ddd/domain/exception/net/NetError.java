package com.ddd.domain.exception.net;

import com.ddd.domain.exception.Error;

/**
 * @author anzj
 * @date 2022/12/20 15:04
 */
public class NetError {

    /*网络异常消息*/
    public static final String SOCKET_READ_TIMEOUT = "Read timed out";
    public static final String SOCKET_CONNECTION_TIMEOUT = "connect timed out";
    public static final String CONNECTION_TIMEOUT = "Connection timed out";
    public static final String SOCKET_MESSAGE_PORT_IN_USE = "Address already in use";
    public static final String CONNECTION_REFUSED = "Connection refused";
    public static final String SOCKET_CLOSED = "Socket is closed";
    public static final String CONNECTION_RESET = "Connection reset";
    public static final String BROKEN_PIPE = "Broken pipe";

    public static final Error ERR_REMOTE_ERROR = new Error("N000","网络错误","网络错误");
    public static final Error ERR_REMOTE_SOCKET_READ_TIMEOUT = new Error("N001","网络错误","远程连接到URL[%s]后读取超时,设定超时时间为[%s]ms");
    public static final Error ERR_REMOTE_CONNECTION_TIMEOUT = new Error("N002","网络错误","远程连接到RUL[%s]超时,设定超时时间为[%s]ms");
    public static final Error ERR_REMOTE_SOCKET_CLOSED = new Error("N003","网络错误","连接被关闭，检查客户端地址[%s]或服务端代码中是否主动关闭了连接(显式或隐式的调用了socket.closed())");
    public static final Error ERR_REMOTE_CONNECTION_REFUSED = new Error("N004","网络错误","网络连接被拒绝,请检查地址[%s]中ip、端口是否正确或网络是否连通");
    public static final Error ERR_REMOTE_CONNECTION_RESET = new Error("N005","网络错误","服务端地址[%s]或客户端关闭了连接接，读写仍然进行。请排查1、服务器是否连接过多；2、客户端是否关闭了连接；3、防火墙是否打开");
    public static final Error ERR_REMOTE_PIPE_BROKEN = new Error("N006","网络错误","服务端地址[%s]或客户端为正常关闭连接");
    public static final Error ERR_REMOTE_TOO_MANY_SOCKET = new Error("N007","网络错误","网络连接过多");
    public static final Error ERR_REMOTE_SSL_PEER_SHUTDOWN = new Error("N008","网络错误","文件错误关闭");
    public static final Error ERR_REMOTE_ALREADY_BIND = new Error("N009","网络错误","地址[%s]端口被占用");




}
