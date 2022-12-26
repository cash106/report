package com.ddd.domain.model.trade.type;

/**
 * @author anzj
 * @date 2022/12/20 17:48
 */
public class ExternalResult {
    public static final String SUCCESS_CODE = "S";
    public static final String FAILURE_CODE = "F";
    public static final String UNKNOWN = "U";

    private String resultCode;

    public boolean isSuccess(){
        return SUCCESS_CODE.equals(resultCode);
    }

    public boolean isUnknown(){
        return UNKNOWN.equals(resultCode);
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
