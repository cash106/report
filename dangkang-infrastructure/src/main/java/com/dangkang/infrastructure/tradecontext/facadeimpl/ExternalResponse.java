package com.dangkang.infrastructure.tradecontext.facadeimpl;

/**
 * @date 2022/12/20 17:38
 */
public class ExternalResponse {

    private String type;
    private String code;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public ExternalResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
