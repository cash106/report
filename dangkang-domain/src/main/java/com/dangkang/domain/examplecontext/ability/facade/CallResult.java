package com.dangkang.domain.examplecontext.ability.facade;

/**
 * @date 2022/12/20 17:48
 */
public class CallResult<T> {
    public static final String SUCCESS_CODE = "S";
    public static final String FAILURE_CODE = "F";
    public static final String UNKNOWN = "U";

    private String resultCode;

    private T resultData;

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

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
