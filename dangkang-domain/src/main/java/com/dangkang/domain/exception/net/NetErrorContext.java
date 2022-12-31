package com.dangkang.domain.exception.net;


import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

/**
 * @author anzj
 * @date 2022/12/20 15:43
 */
public class NetErrorContext {

    private Throwable throwable;
    private String localhost;
    private String remoteIp;
    private Integer readTimeout;
    private Integer connectTimeout;


    public Throwable getThrowable() {
        return throwable;
    }

    public NetErrorContext setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public String getLocalhost() {
        if(localhost != null){
            return localhost;
        }
        try {
            localhost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            localhost = "unknown ip";
        }
        return localhost;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public NetErrorContext setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
        return this;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public NetErrorContext setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;

    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public NetErrorContext setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;

    }
}
