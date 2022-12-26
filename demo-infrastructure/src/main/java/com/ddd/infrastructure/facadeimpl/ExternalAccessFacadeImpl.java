package com.ddd.infrastructure.facadeimpl;

import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.exception.net.NetError;
import com.ddd.domain.exception.net.NetErrorContext;
import com.ddd.domain.exception.net.NetErrorManager;
import com.ddd.domain.model.trade.ability.facade.ExternalAccessFacade;
import com.ddd.domain.model.trade.type.ExternalResult;
import com.ddd.infrastructure.common.Constant;
import com.ddd.infrastructure.external.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;

/**
 * @author anzj
 * @date 2022/12/19 14:47
 */
@Component
public class ExternalAccessFacadeImpl implements ExternalAccessFacade {

    private static final Logger logger = LoggerFactory.getLogger(ExternalAccessFacadeImpl.class);

    @Override
    public ExternalResult toCall() {
        ExternalResult result = new ExternalResult();
        String url = "https://0.0.0.1:8080/call";
        ExternalClient externalClient = new ExternalClient(url,Constant.CONNECT_TIMEOUT,Constant.READ_TIMEOUT);
        try {
            //调用三方接口

            ExternalRequest request = new ExternalRequest();
            logger.info("第三方toCall方法调用：request = [{}]",request);
            ExternalResponse externalResponse = externalClient.toCall(request);
            logger.info("第三方toCall方法调用结果：response = [{}]",externalResponse);
            if(Constant.SUCCEED.equals(externalResponse.getCode())){
                result.setResultCode(ExternalResult.SUCCESS_CODE);
            }else{
                result.setResultCode(ExternalResult.FAILURE_CODE);
            }

        } catch (Exception e) {
            //支付失败则查询订单支付情况
            logger.error("第三方接口调用失败",e);
            if(NetErrorManager.isReadTimeout(e)){
                return query();
            }
            handleException(url, e, externalClient.getConnectTimeout(),externalClient.getReadTimeout());
        }
        return result;
    }

    public ExternalResult query(){
        ExternalResult result = new ExternalResult();
        String url = "https://0.0.0.1:8080/query";
        QueryClient client = new QueryClient(url,Constant.CONNECT_TIMEOUT,Constant.READ_TIMEOUT);
        try {
            QueryRequest request = new QueryRequest();
            logger.info("第三方toQuery方法调用：request = [{}]",request);
            QueryResponse response = client.toQuery(request);
            logger.info("第三方toQuery方法调用：response = [{}]",response);
            if(Constant.SUCCEED.equals(response.getCode())){
                result.setResultCode(ExternalResult.SUCCESS_CODE);
            }else{
                result.setResultCode(ExternalResult.FAILURE_CODE);
            }
        } catch (Exception e) {
            logger.error("第三方toCall方法读取超时，发起toCall方法状态查询的toQuery方法，toQuery执行再次发生异常，" +
                         "此时toCall方法执行结果未知，这会导致当前系统与第三方系统数据可能不一致，" +
                         "此处一般应完整记录当前场景信息并立即告警通知异常处理平台或人工处理");
            throw BizException.buildBizException(ErrorConstant.ERR_REMOTE_UNKNOWN,e);
        }
        return result;
    }

    private void handleException(String url, Exception e, Integer connectTimeout,Integer readTimeout) {
        Error error = NetErrorManager.parse(new NetErrorContext()
                            .setThrowable(e)
                            .setUrl(url)
                            .setConnectTimeout(connectTimeout)
                            .setReadTimeout(readTimeout)
                            );
        throw BizException.buildBizException(error, e.getCause());
    }
}
