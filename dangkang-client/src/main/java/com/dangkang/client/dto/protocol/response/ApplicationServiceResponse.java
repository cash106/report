package com.dangkang.client.dto.protocol.response;

/**
 * @date 2022/12/19 17:07
 */
public class ApplicationServiceResponse {

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
