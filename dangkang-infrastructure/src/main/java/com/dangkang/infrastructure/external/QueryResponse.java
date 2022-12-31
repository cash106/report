package com.dangkang.infrastructure.external;

/**
 * @author anzj
 * @date 2022/12/21 10:54
 */
public class QueryResponse {

    private String code;

    private String message;

    private String data;

    public String getCode() {
        return code;
    }

    public QueryResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
