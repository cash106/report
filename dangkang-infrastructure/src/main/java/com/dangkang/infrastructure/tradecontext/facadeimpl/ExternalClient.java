package com.dangkang.infrastructure.tradecontext.facadeimpl;

import java.net.ConnectException;
import java.rmi.RemoteException;

/**
 * @date 2022/12/20 17:38
 */
public class ExternalClient extends NetClient {

    public ExternalClient(String url, Integer readTimeout, Integer connectTimeout) {
        super(url, readTimeout, connectTimeout);
    }

    public ExternalResponse toCall(ExternalRequest request)throws RemoteException{

        if(url == null || !url.contains(IP)){
            throw new RemoteException("远程连接被拒绝",new ConnectException("Connection refused"));
        }

        return new ExternalResponse().setCode(SUCCEED);
    }


}
