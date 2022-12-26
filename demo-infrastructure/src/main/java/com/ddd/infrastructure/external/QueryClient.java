package com.ddd.infrastructure.external;

import com.ddd.infrastructure.common.Constant;

import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @author anzj
 * @date 2022/12/21 10:54
 */
public class QueryClient extends NetClient{

    public QueryClient(String url, Integer readTimeout, Integer connectTimeout) {
        super(url, readTimeout, connectTimeout);
    }

    public QueryResponse toQuery(QueryRequest request)throws RemoteException{

        if(url == null || !url.contains(IP)){
            throw new RemoteException("远程连接被拒绝",new ConnectException("Connection refused"));
        }
        return new QueryResponse().setCode(Constant.SUCCEED);
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
}
