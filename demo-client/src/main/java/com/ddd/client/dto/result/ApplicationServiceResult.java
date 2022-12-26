package com.ddd.client.dto.result;

/**
 *
 * ApplicationServiceResult是ddd定义的dto，用于applicationService处理结果的返回值给ApplicationServiceController(ddd定义的adapter)
 * @author anzj
 * @date 2022/12/18 17:36
 */
public class ApplicationServiceResult extends Result{

    //todo 定义返回属性

    public Result buildSuccess() {
        //成功处理结果赋值
        return super.buildSuccess();
    }

    public Result buildFailure() {
        //错误处理赋值
        return super.buildFailure();
    }

}
