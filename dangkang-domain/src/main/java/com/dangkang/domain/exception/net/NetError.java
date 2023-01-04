package com.dangkang.domain.exception.net;

public class NetError {

    String errorCode;
    String errorMessage;

    public NetError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public NetError(){}
    public String getErrorCode() {
        return errorCode;
    }

    public NetError setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public NetError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }


    public NetError buildError(String... values){
     return new NetError().setErrorCode(this.errorCode).setErrorMessage(String.format(this.errorMessage,values));
    }


}
