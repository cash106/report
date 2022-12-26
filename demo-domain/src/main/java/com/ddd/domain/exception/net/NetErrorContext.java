package com.ddd.domain.exception.net;


import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.strategy.NetErrorStrategy;

/**
 * @author anzj
 * @date 2022/12/20 15:43
 */
public class NetErrorContext {

    private Throwable throwable;
    private String url;
    private Integer readTimeout;
    private Integer connectTimeout;



    public Throwable getThrowable() {
        return throwable;
    }

    public NetErrorContext setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public NetErrorContext setUrl(String url) {
        this.url = url;
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
