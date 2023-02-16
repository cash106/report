package com.dangkang.infrastructure.tradecontext.facadeimpl;

/**
 * @date 2022/12/23 15:40
 */
public class NetClient {
    public static final String SUCCEED = "0000";
    public static final String IP = "0.0.0.0";

    protected String ip;
    protected String port;
    protected String url;
    protected Integer readTimeout;
    protected Integer connectTimeout;

    public NetClient(String ip, String port, Integer readTimeout, Integer connectTimeout) {
        this.ip = ip;
        this.port = port;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    public NetClient(String url, Integer readTimeout, Integer connectTimeout) {
        this.url = url;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
}
