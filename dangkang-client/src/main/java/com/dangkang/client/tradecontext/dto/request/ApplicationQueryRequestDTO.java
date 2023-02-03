package com.dangkang.client.tradecontext.dto.request;

import com.dangkang.client.dto.request.MultipleQueryRequest;

/**
 * @date 2023/1/11 10:48
 */
public class ApplicationQueryRequestDTO extends MultipleQueryRequest {

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
