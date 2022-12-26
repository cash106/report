package com.ddd.domain.exception;

/**
 * @author anzj
 * @date 2022/12/19 17:47
 */
public class Error {

    String errorCode;
    String errorMessageForCaller;
    String errorMessageForOperator;

    public Error(String errorCode){
        this.errorCode =errorCode;
    }

    public Error(String errorCode,String errorMessageForCaller){
        this.errorCode=errorCode;
        this.errorMessageForCaller=errorMessageForCaller;
    }

    public Error(String errorCode,String errorMessageForCaller,String errorMessageForOperator) {
        this.errorCode=errorCode;
        this.errorMessageForCaller=errorMessageForCaller;
        this.errorMessageForOperator=errorMessageForOperator;
    }

    public Error buildErrorMessageForCaller(String... values){
        Error error = new Error(errorCode);
        if(values != null){
            error.errorMessageForOperator = errorMessageForOperator;
            error.errorMessageForCaller = String.format(getErrorMessageForCaller(),values);
        }
        return error;
    }

    public Error buildErrorMessageForOperator(String... values){
        Error error = new Error(errorCode);
        if(values != null){
            error.errorMessageForCaller = errorMessageForCaller;
            error.errorMessageForOperator = String.format(getErrorMessageForOperator(),values);
        }
        return error;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageForCaller() {
        return errorMessageForCaller;
    }

    public void setErrorMessageForCaller(String errorMessageForCaller) {
        this.errorMessageForCaller = errorMessageForCaller;
    }

    public String getErrorMessageForOperator() {
        return errorMessageForOperator;
    }

    public void setErrorMessageForOperator(String errorMessageForOperator) {
        this.errorMessageForOperator = errorMessageForOperator;
    }
}
