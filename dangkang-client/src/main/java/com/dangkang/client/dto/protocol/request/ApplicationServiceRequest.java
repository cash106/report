package com.dangkang.client.dto.protocol.request;

/**
 * @date 2022/12/19 17:06
 */
public class ApplicationServiceRequest {

    private String email;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
