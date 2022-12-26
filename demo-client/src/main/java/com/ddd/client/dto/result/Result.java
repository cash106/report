package com.ddd.client.dto.result;

/**
 * @author anzj
 * @date 2022/12/18 17:37
 */
public class Result {


    public static final String APP_SUCCESS = "S";
    public static final String APP_FAILURE = "F";

    public static final String DEFAULT_SUCCESS_CODE = "0000";

    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    public static final String DEFAULT_FAILURE_MESSAGE = "FAILURE";
    /**
     * 返回类型 s-成功 f-失败
     */
    private String resultType; //todo 修改为enum

    /**
     * 自定义返回码
     */
    private StringBuffer resultCode = new StringBuffer();

    public Result buildSystemCode(String systemCode){
        resultCode.append(systemCode);
        return this;
    }

    public Result buildTradeCode(String tradeCode){
        resultCode.append(tradeCode);
        return this;
    }

    public Result buildMessageCode(String messageCode){
        resultCode.append(messageCode);
        return this;
    }

    /**
     * 返回消息
     */
    private StringBuffer resultDescription = new StringBuffer();

    public Result buildSystemDescription(String systemMessage){
        resultDescription.append(systemMessage);
        return this;
    }

    public Result buildTradeDescription(String tradeDescription){
        resultDescription.append(tradeDescription);
        return this;
    }

    public Result buildBusinessMessage(String businessMessage){
        resultDescription.append(businessMessage);
        return this;
    }

    public Result buildSuccess(){
        this.setResultType(APP_SUCCESS);
        return this;
    }

    public Result buildFailure(){
        this.setResultType(APP_FAILURE);
        return this;
    }

    public String getResultType() {
        return resultType;
    }

    public Result setResultType(String resultType) {
        this.resultType = resultType;
        return this;
    }

    public StringBuffer getResultCode() {
        return resultCode;
    }

    public void setResultCode(StringBuffer resultCode) {
        this.resultCode = resultCode;
    }

    public StringBuffer getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(StringBuffer resultDescription) {
        this.resultDescription = resultDescription;
    }
}
