package com.dangkang.client.dto.protocol.request;

/**
 * @date 2023/1/10 17:44
 */
public class ApplicationQueryRequest extends QueryRequest{

    private String email;

    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
