package com.dangkang.domain.model.tradecontext.type;

public class QueryResult<T> {

    public static final String SUCCESS_CODE = "S";//如果查询没有返回值，表示执行成功
    public static final String FAILURE_CODE = "F";//如果没有返回，表示执行出错

    private T resultData;//查询的结果
    private String resultCode;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
