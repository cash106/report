package com.ddd.domain.exception;

/**
 * @author anzj
 * @date 2022/12/19 11:05
 */
public class BizException extends RuntimeException {

    private Error error;
    private Throwable t;

    public BizException(Error error){
        this.error = error;
    }

    public BizException(Error error,Throwable throwable){
        this.error = error;
        this.t = throwable;
    }

    public static BizException buildBizException(Error error){
        return new BizException(error);
    }

    public static BizException buildBizException(Error error,Throwable throwable){
        return new BizException(error,throwable);
    }


    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Throwable getT() {
        return t;
    }

    public void setT(Throwable t) {
        this.t = t;
    }
}
